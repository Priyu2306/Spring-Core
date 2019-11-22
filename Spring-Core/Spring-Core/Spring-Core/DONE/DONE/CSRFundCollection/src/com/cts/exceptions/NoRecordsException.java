package com.cts.exceptions;

@SuppressWarnings("serial")
public class NoRecordsException extends Exception {
public NoRecordsException(){
	super("No  details available for the unitCode entered");
}
}
