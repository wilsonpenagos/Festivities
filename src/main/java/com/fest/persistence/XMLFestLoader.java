package com.fest.persistence;

import java.util.ArrayList;

/**
 * Contract of XML extract, transform and load
 * @author Wilson
 *
 */
public interface XMLFestLoader {

	/**
	 * Transforms an XML file whit the example structure into an array of festivities. 
	 * @param file The string representing the source file
	 * @return
	 */
	public ArrayList<Festivity> extractTrasnformLoad(String file);
	
}
