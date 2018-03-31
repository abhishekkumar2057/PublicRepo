package com.github.annotation.target;

import com.github.annotation.defs.FieldAnnotation;

public class TargetClass {
	
	@FieldAnnotation(value = 10)
	private int value;
	
	@FieldAnnotation
	private int val;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
}
