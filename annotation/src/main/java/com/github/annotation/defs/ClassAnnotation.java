/**
 * 
 * The annotation definition with
 * Target: class
 * Retention Policy: runtime
 * 
 */

package com.github.annotation.defs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.annotation.model.BeanScope;

/**
 * @author Abhishek Kumar
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassAnnotation {
	
	/**
	 * 
	 * @return
	 * 
	 */
	BeanScope scope() default BeanScope.SINGLETON;
}
