package com.cts.exceptions;

@SuppressWarnings("serial")
public class InvalidUnitCodeException extends Exception {
public InvalidUnitCodeException(){
	super("Unit Code entered should be valid");
}
}
