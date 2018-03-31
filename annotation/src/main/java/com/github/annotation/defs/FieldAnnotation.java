/**
 * 
 * The annotation definition with
 * Target: field
 * Retention Policy: runtime
 * 
 */

package com.github.annotation.defs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Abhishek Kumar
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {

	/**
	 * 
	 * @return
	 * 
	 */
	int value() default -1;
}
