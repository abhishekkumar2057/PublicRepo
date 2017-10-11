package com.openlib.file.job;

import java.io.File;
import java.io.IOException;
import java.util.Queue;

import com.openlib.file.task.FileUpdateReaderTask;

public class ReaderJob implements Runnable {
	
	private File target;
	private Queue<String> container;
	
	private FileUpdateReaderTask reader;
	
	public ReaderJob(File target, Queue<String> container) {
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
