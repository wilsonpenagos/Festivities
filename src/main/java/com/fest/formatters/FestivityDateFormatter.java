package com.fest.formatters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fest.constants.DateFormatConstants;

/**
 * Main formatter class of the application, to centralize and unify the manipulation of dates
 * @author Wilson
 *
 */
public final class FestivityDateFormatter {

	private static final DateFormat mainFormat = 
			new SimpleDateFormat(DateFormatConstants.MAIN_DATE_FORMAT, Locale.ENGLISH);
	
	private static final DateFormat secondaryFormat = 
			new SimpleDateFormat(DateFormatConstants.SECONDARY_DATE_FORMAT, Locale.ENGLISH);
	
	/**
	 * Formats the received date into an application standard String
	 * @param date
	 * @return The String representation of the date
	 */
	public static String formatDate(Date date) {
		return mainFormat.format(date);
	}
	
	/**
	 * Parses the received String into a Date object using the application standard
	 * @param string
	 * @return The Date representation of the String
	 */
	public static Date formatString(String string) {
		try {
			return mainFormat.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * Formats the received date into an application secondary standard String
	 * @param date
	 * @return The String representation of the date
	 */
	public static String formatDateWeb(Date date) {
		return secondaryFormat.format(date);
	}
	
	/**
	 * Parses the received String into a Date object using the application secondary standard
	 * @param string
	 * @return The Date representation of the String
	 */
	public static Date formatStringWeb(String string) {
		try {
			return secondaryFormat.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}
}
