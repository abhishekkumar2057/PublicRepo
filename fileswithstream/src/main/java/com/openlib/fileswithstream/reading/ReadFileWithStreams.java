package com.openlib.fileswithstream.reading;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Abhishek Kumar
 * 
 * Demonstration of file reading in trivial style, after JDK 1.7 and 1.8
 *
 */
public class ReadFileWithStreams {
	
	private static List<File> files = new LinkedList<>();
	private static final String DIR = "./files";
	
	public static void main(String[] args) {
		
		// Read a single file
		File target = new File(DIR +"/DemoFile.csv");
		List<String> list = null;
		try {
			list = Files.readAllLines(target.toPath());
			System.out.println(list);
			Files.lines(Paths.get(target.toURI()))
					.filter(e -> e.contains("Bangalore"))
					.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Read multiple files
		File dir = new File(DIR);
		list = Arrays.asList(dir.list());
		list.stream()
				   .filter(e -> e.contains(".log"))
				   //.collect(Collectors.toList());
				   .forEach(e -> files.add(new File(dir, e))/*createFiles(e)*/);
		//files.stream().forEach(e -> System.out.println(e.getName()));
		files.stream()
			 //.parallel()
			 .forEach(e -> {
				try {
					Files.lines(Paths.get(e.toURI()))
						 //.parallel()
						 .filter(a -> a.contains("Info"))
						 .forEach(System.out::println);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
	}
	/*
	private static String createFiles(String name) {
		files.add(new File(DIR, name));
		
		return null;
	}*/
}
