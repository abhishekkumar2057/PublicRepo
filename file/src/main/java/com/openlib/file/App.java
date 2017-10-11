package com.openlib.file;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.openlib.file.job.ReaderJob;

/**
 * @author abhishek.kumar8
 * 
 * Main program to load and run the task
 *
 */

public class App {
    public static void main(String[] args ) {
    	
    	Queue<String> container = new LinkedBlockingQueue<>();
    	ReaderJob t = new ReaderJob(new File("D://poc.log"),container);
		new Thread(t).start();
		System.out.println(container.poll());
    }
}
