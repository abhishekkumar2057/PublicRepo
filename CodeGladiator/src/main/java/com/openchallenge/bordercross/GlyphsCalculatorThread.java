package com.openchallenge.bordercross;

import java.util.Iterator;
import java.util.List;

public class GlyphsCalculatorThread implements Runnable {

	private List<String> glyphs;
	private String data;
	private Integer count;
	
	public GlyphsCalculatorThread(List<String> glyphs, String data, Integer count) {
		this.glyphs = glyphs;
		this.data = data;
		this.count = count;
	}
	
	@Override
	public void run() {
		Iterator<String> it = glyphs.iterator();
		//int count = 0;
		while(it.hasNext()) {
			String target = data;
			String token = it.next();
			if(target.contains(token)) {
				target = target.replaceAll(token, "0");
			}
			if(target.charAt(target.length()-1)=='0')
				target = target.concat("x");
			count += target.split("0").length-1;
		}
		System.out.println(Thread.currentThread().getName() + " --> " + count);
	}
}
