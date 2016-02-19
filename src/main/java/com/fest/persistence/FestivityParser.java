package com.fest.persistence;

/**
 * Contract of the classes that implement different ways to obtain Festivities information.
 * @author Wilson
 *
 */
public interface FestivityParser {
	
	/**
	 * Get all existent festivities .
	 * @return A string containing an ampersand separated list of all existent festivities,
	 *  which themselves are pipe separated.  
	 */
	String getAll();
	
	/**
	 * Get all existent festivities that match all the received parameters.
	 * @return A string containing an ampersand separated list of all existent festivities,
	 *  which themselves are pipe separated, that match all the received parameters.
	 */
	String getBy(String festName, String festStartDate, String festEndDate, String festPlace);
	
	/**
	 * Persist a new Festivity with the received parameters.
	 * Note: Must assure that no NULL date is used in the process
	 * @return 0 if there is any problem with the creation (at the moment, lack of parameters) or
	 * the long number representing the id of the created Festivity
	 */
	long createFestivity(String festName, String festStartDate, String festEndDate, String festPlace);
	
	/**
	 * Updates the festivity indicated by the received id with the received values
	 * @param id
	 * @param festName
	 * @param festStartDate
	 * @param festEndDate
	 * @param festPlace
	 * @return A boolean indicating if the update was successful or not (at the moment, only by lack of parameters)
	 */
	boolean updateFestivity(long id, String festName, String festStartDate, String festEndDate, String festPlace);

}
