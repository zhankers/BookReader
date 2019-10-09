package com.ibook.algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class GeekA02 {

	public static void main(String[] args) {
		if (args == null || args.length != 0) {
			System.out.println("please input the inputFile and outPutFile!");
		} else {
			System.out.println(args.length);
			String inputFile = args[0];
			String outputFile = args[1];

			// Test
			//String inputFile = "D:\\ZzqSpaces\\yaunde\\git\\BookReader\\ibook\\ibook-algorithm\\src\\main\\resources\\geekA06_simple.in";
			//String outputFile = "D:\\ZzqSpaces\\yaunde\\git\\BookReader\\ibook\\ibook-algorithm\\src\\main\\resources\\geekA06_simple.out";
			Map<String, Integer> result = new HashMap<>();

			try {
				Stream<String> inputFileStream = Files.lines(Paths.get(inputFile)); //.peek(System.out::println);
				inputFileStream.forEach(fileLine ->{
					if (result.containsKey(fileLine)) {
						result.compute(fileLine, (key, oldValue) -> ++oldValue);
					} else {
						result.put(fileLine, 1);
					}
				});

				// System.out.println("result："+ result);

				Path outPath = Paths.get(outputFile);

				result.forEach((k, v) -> {
					try {
						if (v > 1) {
							Path write = Files.write(outPath, (k + "\t" + v + "\n").getBytes(), CREATE, APPEND);
							// System.out.println("write.getFileName() :" + write.getFileName());
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

			} catch (IOException e) {
				e.printStackTrace();
			}


		}

	}
}
