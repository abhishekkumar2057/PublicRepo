/**
 * 
 * Consumer class definition to demonstrate ClassAnnotation usage
 * 
 */

package com.github.annotation.consume;

import com.github.annotation.factory.FactoryObjectCreator;
import com.github.annotation.target.SingletonObject;

/**
 * @author Abhishek Kumar
 *
 */
public class ClassAnnotationConsume {
	
	public static void main(String[] args) {
		SingletonObject ob1 = FactoryObjectCreator.getInstance(SingletonObject.class);
		SingletonObject ob2 = FactoryObjectCreator.getInstance(SingletonObject.class);
		
		System.out.println("Equality: " +(ob1==ob2));
	}
}
