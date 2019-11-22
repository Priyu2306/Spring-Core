package com.cts.presentation;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * @author Author name
 * 
 */
public class DateUtility {


	/**
	 * accepts the Date object and return the date in String format
	 * 
	 * @param args
	 *            : Date entryDate- date object that needs to returned in
	 *            string format
	 * @return: String- date in string format
	 */
	public  String getStringFromDate(Date entryDate)
			throws Exception {

		/* Declaration of variables */

		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy");

		/*
		 * Getting Date from the calendar object and using format method for
		 * retrieval of date in text format
		 */

		
		String textDate = simpleDate.format(entryDate);

		/* the string date is returned */

		return textDate;
	}

}
