package com.openlib.fileswithstream.reading;

import java.io.File;
import java.io.IOException;
import java.util.Queue;

public class ThreadedFileReader implements Runnable {
	
	private File target;
	private Queue<String> container;
	
	private FileUpdateReaderTask reader;
	
	public ThreadedFileReader(File target, Queue<String> container) {
		super();
		this.target = target;
		this.container = container;
	}

	@Override
	public void run() {
		reader = new FileUpdateReaderTask(target);
		try {
			reader.readUpdatedContent(container);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
