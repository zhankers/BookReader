package com.ibook.algorithm.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存文件映射
 *
 *
 * 这种方法就是把文件的内容被映像到计算机虚拟内存的一块区域，从而可以直接操作内存当中的数据而无需每次都通过 I/O
 * 去物理硬盘读取文件。这是由当前 java 态进入到操作系统内核态，由操作系统读取文件，再返回数据到当前 java 态的过程。
 * 这样就能大幅提高我们操作大文件的速度
 */
public class MappedFileReader {
    private FileInputStream fileIn;
    private MappedByteBuffer mappedBuf;
    private long fileLength;
    private int arraySize;
    private byte[] array;
 
    public MappedFileReader(String fileName, int arraySize) throws IOException {
        this.fileIn = new FileInputStream(fileName);
        FileChannel fileChannel = fileIn.getChannel();
        this.fileLength = fileChannel.size();
        this.mappedBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
        this.arraySize = arraySize;
    }
 
    public int read() throws IOException {
        int limit = mappedBuf.limit();
        int position = mappedBuf.position();
        if (position == limit) {
            return -1;
        }
        if (limit - position > arraySize) {
            array = new byte[arraySize];
            mappedBuf.get(array);
            return arraySize;
        } else {// 最后一次读取数据
            array = new byte[limit - position];
            mappedBuf.get(array);
            return limit - position;
        }
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
        MappedFileReader reader = new MappedFileReader("/home/zfh/movie.mkv", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1);
        long end = System.nanoTime();
        reader.close();
        System.out.println("MappedFileReader: " + (end - start));
    }
}