/**
 * 
 * The target class definition for the FieldAnnotation defined
 * The custom FieldAnnotation usage on the class fields
 * 
 */

package com.github.annotation.target;

import com.github.annotation.defs.FieldAnnotation;

/**
 * @author Abhishek Kumar
 *
 */
public class TargetClass {

	/**
	 * FieldAnnotation annotation applied on value field with custom value: 10
	 */
	@FieldAnnotation(value = 10)
	private int value;
	
	/**
	 * FieldAnnotation annotation applied on value field with no value
	 * So, default value will be applied in this case
	 */
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
