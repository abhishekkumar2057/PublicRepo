package com.github.annotation.consume;

import com.github.annotation.factory.FactoryObjectCreator;
import com.github.annotation.target.SingletonObject;

public class ClassAnnotationConsume {
	
	public static void main(String[] args) {
		SingletonObject ob1 = FactoryObjectCreator.getInstance(SingletonObject.class);
		SingletonObject ob2 = FactoryObjectCreator.getInstance(SingletonObject.class);
		
		System.out.println("Equality: " +(ob1==ob2));
	}
}
