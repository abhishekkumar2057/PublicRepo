/**
 * 
 * The enum definition for the scopes of the objects which needs to be created
 * 
 */

package com.github.annotation.model;

/**
 * @author Abhishek Kumar
 *
 */
public enum BeanScope {
	
	/**
	 * 
	 * The SINGLETON scope: One and only one object needs to be created
	 * 
	 */
	SINGLETON,
	
	/**
	 * 
	 * The PROTOTYPE scope: Many object can be created
	 * 
	 */
	PROTOTYPE;
}
