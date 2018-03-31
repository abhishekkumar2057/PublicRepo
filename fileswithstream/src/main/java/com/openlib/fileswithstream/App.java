package com.openlib.fileswithstream;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.openlib.fileswithstream.reading.ThreadedFileReader;

/**
 * @author Abhishek Kumar
 *
 */
public class App {
	
	private Queue<String> resource1;
	private Queue<String> resource2;
	private Queue<String> resource3;
	private Queue<String> resource4;
	private Queue<String> resource5;
	
	private static File file;
	
	public App() {
		super();
		
		resource1 = new LinkedBlockingQueue<>();
		resource2 = new LinkedBlockingQueue<>();
		resource3 = new LinkedBlockingQueue<>();
		resource4 = new LinkedBlockingQueue<>();
		resource5 = new LinkedBlockingQueue<>();
		
		file = new File("./files/demo.log");
	}
	
    public static void main(String[] args ) {
    	
    	new App().threadRun();
    }
    
    public void threadRun() {
    	/*Thread t1 = */new Thread(new ThreadedFileReader(file, resource1)).start();
		/*Thread t2 = */new Thread(new ThreadedFileReader(file, resource2)).start();
		/*Thread t3 = */new Thread(new ThreadedFileReader(file, resource3)).start();
		/*Thread t4 = */new Thread(new ThreadedFileReader(file, resource4)).start();
		/*Thread t5 = */new Thread(new ThreadedFileReader(file, resource5)).start();
	}
}
