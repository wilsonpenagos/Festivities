package com.fest;

/**
 * POJO with the basic response information of the RESTful service
 * @author Wilson
 *
 */
public class RestQueryResponse {

    private final int code;
    private final String description;
    private final String content;
    
    public RestQueryResponse(int code, String description, String content) {
    	this.code = code;
    	this.description = description;
    	this.content = content;
    }

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getContent() {
		return content;
	}
	
}
