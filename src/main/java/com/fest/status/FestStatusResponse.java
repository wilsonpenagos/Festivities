package com.fest.status;

/**
 * A public access class that defines the valid Status Responses.
 * @author Wilson
 *
 */
public final class FestStatusResponse {

	public static final ResponseStatus SUCCESS = new ResponseStatus(200, "Succesful search.");
	public static final ResponseStatus MISSING_DATA = new ResponseStatus(400, "There is missing data for the creation of the new festivity.");
	public static final ResponseStatus NO_RESULTS = new ResponseStatus(404, "There are no results for the specified search.");
	public static final ResponseStatus ERROR = new ResponseStatus(500, "There has been a technical error.");
	
}
