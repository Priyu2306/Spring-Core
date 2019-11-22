package com.cts.exceptions;

@SuppressWarnings("serial")
public class InvalidEmpNameException extends Exception {
public InvalidEmpNameException(){
	super("Employee Name should consists of only alphabets and space");}
}
