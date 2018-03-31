package com.openlib.fileswithstream.reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Abhishek Kumar
 * 
 * Demonstration of file reading in trivial style, before JDK 1.7
 *
 */
public class ReadFileTrivial {
	
	public static void main(String[] args) {
		File target = new File("./files/DemoFile.csv");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(target));
			String line = reader.readLine();
			while(line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
