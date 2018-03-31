/**
 * 
 * Consumer class definition to demonstrate FieldAnnotation usage
 * 
 */

package com.github.annotation.consume;

import java.lang.reflect.Field;

import com.github.annotation.defs.FieldAnnotation;
import com.github.annotation.target.TargetClass;

/**
 * @author Abhishek Kumar
 *
 */
public class FiledAnnotationConsume {
	
	public static void main(String[] args) throws Exception {
		TargetClass target = new TargetClass();
		System.out.println("target value: " + target.getValue());
		
		Field value = target.getClass().getDeclaredField("value");
		FieldAnnotation ann = value.getAnnotation(FieldAnnotation.class);
		System.out.println("Annotation Custom Value: " + ann.value());
		System.out.println("=====================================");
		System.out.println("target value: " + target.getVal());
		Field val = target.getClass().getDeclaredField("val");
		FieldAnnotation ann1 = val.getAnnotation(FieldAnnotation.class);
		System.out.println("Annotation Custom Value: " + ann1.value());
	}
}
