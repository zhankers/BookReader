package com.ibook.algorithm;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-10-24 14:57
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        ClassPathResource testFile = new ClassPathResource("test.in");

        Files.lines(testFile.getFile().toPath()).forEach(System.out::println);
        // oqutoturweoteqio \n jtu09ttuqetu \n aijqitqtq

        System.out.println("-----------------------------");

        Path outPath = Paths.get("E:\\logs\\test.in");
        Files.lines(testFile.getFile().toPath())
                .flatMap(line -> Stream.of(line.split("\\\\n")))
                .forEach(line -> {
                    try {
                        Files.write(outPath, (line + "\n").getBytes(), CREATE, APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

    }
}
