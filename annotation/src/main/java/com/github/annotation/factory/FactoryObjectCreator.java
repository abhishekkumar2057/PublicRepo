/**
 * 
 * The following implementation 
 */

package com.github.annotation.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

import com.github.annotation.defs.ClassAnnotation;
import com.github.annotation.model.BeanScope;

public class FactoryObjectCreator {
	
	private static final String REGEX = "com.test.annotations.*";
	
	public static <T>T getInstance(Class<T> clazz) {
		
		T object = null;
		ClassAnnotation clsAnn = clazz.getAnnotation(ClassAnnotation.class);
		BeanScope scope = clsAnn.scope();
		if(scope.name().equals("SINGLETON")) {
			try {
				object = singleInstance(clazz);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return object;
	}
	
	@SuppressWarnings("unchecked")
	private static <T>T singleInstance(Class<T> clazz) throws Exception {
		
		T instance = null;
		Lock lock = new ReentrantLock();
		Package pack = clazz.getPackage();
		boolean flag = Pattern.matches(REGEX, pack.getName());
		
		Field counter = clazz.getDeclaredField("counter");			counter.setAccessible(true);
		Field inst = clazz.getDeclaredField("instance");			inst.setAccessible(true);
		/*
		Method getCount = clazz.getDeclaredMethod("getCounter");	getCount.setAccessible(true);
		Method getInst = clazz.getDeclaredMethod("getInstance");	getInst.setAccessible(true);
		Method setInst = clazz.getDeclaredMethod("setInstance");	setInst.setAccessible(true);
		*/
		/**
		 * If the above method declarations don't work, and throws RuntimeExceptions
		 * then the following alternative can be used.
		 */
		Method getCount = null;
		Method getInst = null;
		Method setInst = null;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m: methods) {
			if(m.getName()=="getCounter") {
				m.setAccessible(true);
				getCount = m;
			}
			if(m.getName()=="getInstance") {
				m.setAccessible(true);
				getInst = m;
			}
			if(m.getName()=="setInstance") {
				m.setAccessible(true);
				setInst = m;
			}

		}
		
		Object val = getCount.invoke(clazz);
		AtomicInteger count = (AtomicInteger) val;
		boolean noInst = count.get() == 0;
		
		if(flag) {
			if(noInst) {
				lock.lock();
				if(noInst) {
					Constructor<T>[] cons = (Constructor<T>[]) clazz.getDeclaredConstructors();
					cons[0].setAccessible(true);
					instance = cons[0].newInstance();
					count.set(count.get()+1);
					setInst.invoke(clazz, instance);
					lock.unlock();
				}
			} else {
				instance = (T) getInst.invoke(clazz);
			}
		}
		
		return instance;
	}
}
