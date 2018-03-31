/**
 * 
 * The task definition to read the file which is continuously being updated, e.g., log file
 * 
 */

package com.openlib.fileswithstream.reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Abhishek Kumar
 *
 */
public class FileUpdateReaderTask {

	// The target file need to be read
	private File target;
	
	// Characters need to be skipped (updated content index) 
	private long offset;
	
	public FileUpdateReaderTask(File target) {
		super();
		if(target != null) {
			this.target = target;
		} else {
			System.err.println("Fatal: NULL File Object");
			System.exit(0);
		}
	}
	
	// Method needs Queue Object to be provided into which the reader will push file contents
	@SuppressWarnings("resource")
	public void readUpdatedContent(Queue<String> container) throws IOException {
		
		//BufferedReader reader = null;
		//Lock lock = null;
		final Path path = target.toPath();
		if(container != null) {
			Stream<String> stream = Files.lines(path);
			
			BufferedReader reader = Files.newBufferedReader(path);
			while(true) {
				reader.skip(offset);
				stream = reader.lines();
				Collection<String> col = stream
												.filter(e -> e.contains("Info"))
												.collect(Collectors.toList());
				offset = target.length();
				container.addAll(col);
				col .stream()
					.forEach(System.out::println);
			}
		} else {
			System.err.println("Fatal: NULL Queue Object");
			System.exit(0);
		}
	}
}
