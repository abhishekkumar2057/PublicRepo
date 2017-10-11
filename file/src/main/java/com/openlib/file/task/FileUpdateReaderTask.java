/**
 * The core task executed by the run method.
 * Business Logic remains here to read the updated content from the file.
 * The File object need to provided for the task to be done.
 * Code runs in an infinite loop and reads update in file if any.
 */

package com.openlib.file.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Abhishek Kumar
 * 
 * Task class containing core business logic
 *
 */
public class FileUpdateReaderTask {
	
	// The target file need to be read
	private File target;
	
	// Thread-Safe counter (Java-API)
	private AtomicLong counter;
	
	// Characters need to be skipped (updated content index) 
	private long offset;
	
	public FileUpdateReaderTask(File target) {
		super();
		if(target != null) {
			this.target = target;
			counter = new AtomicLong();
		} else {
			System.err.println("Fatal: NULL File Object");
			System.exit(0);
		}
	}
	
	// Method needs Queue Object to be provided into which the reader will push file contents
	public void readUpdatedContent(Queue<String> container) throws IOException {
		
		BufferedReader reader = null;
		Lock lock = null;
		
		if(container != null) {

			try {
				FileReader stream = new FileReader(target);
				reader = new BufferedReader(stream);
				
				String row = null;
				//int count = 0;
				
				//offset = file.length();
				reader.skip(counter.get());
				lock = new ReentrantLock();
				while(true && lock.tryLock()) {
					// 2 sec. Delay
					Thread.sleep(2000);
					long time = System.currentTimeMillis();
					row = reader.readLine();
					//count++;
					
					if(row != null && time>=target.lastModified()) {
						offset = counter.incrementAndGet();
						System.out.println("Data read from file: " + row + "\t-> by: " + Thread.currentThread().getName());
						container.offer(row);
					} else {
						try {
							reader.reset();
						} catch (IOException exception) {
							reader.skip(offset);
						}
						reader = new BufferedReader(new FileReader(target));
						reader.skip(offset);
					}
					offset = target.length();
					lock.unlock();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				if(lock != null)
					lock.unlock();
			} catch (IOException e) {
				e.printStackTrace();
				if(lock != null)
					lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Fatal: NULL Queue Object");
			System.exit(0);
		}
	}
}
