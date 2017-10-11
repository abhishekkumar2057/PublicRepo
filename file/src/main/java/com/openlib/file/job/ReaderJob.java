package com.openlib.file.job;

import java.io.File;
import java.io.IOException;
import java.util.Queue;

import com.openlib.file.task.FileUpdateReaderTask;

public class ReaderJob implements Runnable {
	
	File target;
	Queue<String> container;
	FileUpdateReaderTask reader;
	
	public ReaderJob() {
		super();
	}
	
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
	/*
	public static void main(String[] args) {
		ReaderJob t = new ReaderJob(new File("D://poc.log"));
		new Thread(t).start();
		System.out.println(t.container.poll());
	}*/
}
