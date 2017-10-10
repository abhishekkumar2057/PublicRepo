package com.openlib.file.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class FileUpdateReaderTask {
	
	private File target;
	private AtomicLong counter;
	private long offset;
	
	public FileUpdateReaderTask(File target) {
		super();
		this.target = target;
		counter = new AtomicLong();
	}
	
	public void readUpdatedContent(Queue<String> container) throws IOException {

		BufferedReader reader = null;
		
		try {
			FileReader stream = new FileReader(target);
			reader = new BufferedReader(stream);
			
			String row = null;
			int count = 0;
			
			System.out.println(count);
			//offset = file.length();
			reader.skip(counter.get());
			while(true) {
				Thread.sleep(1000);
				long time = System.currentTimeMillis();
				row = reader.readLine();
				count++;
				
				if(row != null && time>=target.lastModified()) {
					offset = counter.incrementAndGet();
					//System.out.println(offset);
					System.out.println("Data read from file: " + row + "\t-> by: " + Thread.currentThread().getName());
					/*boolean b = */container.offer(row);
//					System.out.println("Inserted in queue: " + b);
					
				} else {
					Thread.sleep(5000);
					try {
						reader.reset();
					} catch (IOException exception) {
						reader.skip(offset);
					}
					reader = new BufferedReader(new FileReader(target));
					reader.skip(offset);
				}
				offset = target.length();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(offset);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
