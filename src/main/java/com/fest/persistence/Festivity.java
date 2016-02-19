package com.fest.persistence;

import java.util.Date;

import com.fest.formatters.FestivityDateFormatter;

/**
 * Class representation of the festivity concept
 * @author Wilson
 *
 */
public class Festivity {
	
	private final long id;
	private String festName;
	private Date festStartDate;
	private Date festEndDate;
	private String festPlace;
	
	/**
	 * Main constructor of the Festivity class, receives directly the presumably right parameters.
	 * @param festName
	 * @param festStartDate
	 * @param festEndDate
	 * @param festPlace
	 */
	public Festivity(long id, String festName, Date festStartDate, Date festEndDate, String festPlace){
		this.id = id;
		this.festName = festName;
		this.festStartDate = festStartDate;
		this.festEndDate = festEndDate;
		this.festPlace = festPlace;
		
	}

	/**
	 * Creates a string representation of the festivity, separating by pipes Name, Start date,
	 * End date and place
	 * @return A pipe separated string with the object data.
	 */
	public String getPipedString(){
		String result = new String(
				String.valueOf(id) + "|" + 
				festName + "|" + 
				FestivityDateFormatter.formatDate(festStartDate) + "|" +
				FestivityDateFormatter.formatDate(festEndDate) + "|" +
				festName
				);
		return result;
	}
	
	public String getFestName() {
		return festName;
	}

	public Date getFestStartDate() {
		return festStartDate;
	}

	public Date getFestEndDate() {
		return festEndDate;
	}

	public String getFestPlace() {
		return festPlace;
	}

	public long getId() {
		return id;
	}
	
}
