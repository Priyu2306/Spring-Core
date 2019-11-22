package com.cts.exceptions;

@SuppressWarnings("serial")
public class InvalidPhoneNoException extends Exception {
public InvalidPhoneNoException(){
	super("Phone Number should be valid");
}
}
