package com.qa.Exceptions;

@SuppressWarnings("serial")
public class InvalidExcelPathException extends FrameworkExceptions {

	public InvalidExcelPathException(String message) {
		super(message);
		
	}
	public InvalidExcelPathException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
