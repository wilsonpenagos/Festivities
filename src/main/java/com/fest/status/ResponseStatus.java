package com.fest.status;

/**
 * Base class that contains an identifying code and a correspondent description.
 * @author Wilson
 *
 */
public class ResponseStatus {
	
	private int code;
	private String description;
	
	/**
	 * Unique constructor for the Response Status class
	 * @param code The code numeric identification
	 * @param description Simple description to be shown in the response using the Status
	 */
	public ResponseStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
