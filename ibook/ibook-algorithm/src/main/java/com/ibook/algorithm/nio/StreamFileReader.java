package com.ibook.algorithm.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-04-04 20:14
 */
public class StreamFileReader {
    private BufferedInputStream fileIn;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public StreamFileReader(String fileName, int arraySize) throws IOException {
        this.fileIn = new BufferedInputStream(new FileInputStream(fileName), arraySize);
        this.fileLength = fileIn.available();
        this.arraySize = arraySize;
    }

    public int read() throws IOException {
        byte[] tmpArray = new byte[arraySize];
        int bytes = fileIn.read(tmpArray);// 暂存到字节数组中
        if (bytes != -1) {
            array = new byte[bytes];// 字节数组长度为已读取长度
            System.arraycopy(tmpArray, 0, array, 0, bytes);// 复制已读取数据
            return bytes;
        }
        return -1;
    }

    public void close() throws IOException {
        fileIn.close();
        array = null;
    }

    public byte[] getArray() {
        return array;
    }

    public long getFileLength() {
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        StreamFileReader reader = new StreamFileReader("/home/zfh/movie.mkv", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1) {}
        long end = System.nanoTime();
        reader.close();
        System.out.println("StreamFileReader: " + (end - start));
    }
}
