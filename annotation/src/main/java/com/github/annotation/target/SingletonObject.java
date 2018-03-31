package com.github.annotation.target;

import java.util.concurrent.atomic.AtomicInteger;

import com.github.annotation.defs.ClassAnnotation;
import com.github.annotation.model.BeanScope;

@ClassAnnotation(scope=BeanScope.SINGLETON)
public class SingletonObject {
	
	private static SingletonObject instance;
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	private SingletonObject() { }

	public static SingletonObject getInstance() {
		return instance;
	}

	@SuppressWarnings("unused")
	private static void setInstance(SingletonObject instance) {
		SingletonObject.instance = instance;
	}

	public static AtomicInteger getCounter() {
		return counter;
	}

	@SuppressWarnings("unused")
	private static void setCounter(AtomicInteger counter) {
		SingletonObject.counter = counter;
	}
}
