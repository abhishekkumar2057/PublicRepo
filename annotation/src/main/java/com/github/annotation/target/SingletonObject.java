/**
 * 
 * Class definition for which the object needs to be created
 * And the scope defined as SINGLETON
 * The thread-safe counter object to count the number of instances created
 * 
 * The range of values for the counter must be [0, 1]
 * Ideally it must be 0 if no instances created
 * And 1 if the instance is created.
 * It must not increase to more than 1
 * 
 */

package com.github.annotation.target;

import java.util.concurrent.atomic.AtomicInteger;

import com.github.annotation.defs.ClassAnnotation;
import com.github.annotation.model.BeanScope;

/**
 * @author Abhishek Kumar
 *
 */
@ClassAnnotation(scope=BeanScope.SINGLETON)
public class SingletonObject {
	
	private static SingletonObject instance;
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	/**
	 * 
	 * private constructor to restrict object creation from outside.
	 * 
	 */
	private SingletonObject() { }

	/**
	 * 
	 * @return SingletonObject
	 * 
	 * public method to invoke/get instance of the class
	 * 
	 */
	public static SingletonObject getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * @param instance
	 * 
	 * To set the instance field when object is created
	 * But must not be visible from outside
	 * 
	 */
	@SuppressWarnings("unused")
	private static void setInstance(SingletonObject instance) {
		SingletonObject.instance = instance;
	}

	/**
	 * 
	 * @return AtomicInteger
	 * 
	 */
	public static AtomicInteger getCounter() {
		return counter;
	}

	/**
	 * 
	 * @param counter
	 * 
	 * To set the counter but must not be visible outside
	 * As the field is to keep track number of objects created
	 * 
	 */
	@SuppressWarnings("unused")
	private static void setCounter(AtomicInteger counter) {
		SingletonObject.counter = counter;
	}
}
