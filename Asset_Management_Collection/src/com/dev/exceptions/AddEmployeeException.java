package com.dev.exceptions;

@SuppressWarnings("serial")
public class AddEmployeeException extends RuntimeException {
	@Override
	public String getMessage()
	{
		return "add employee exception";

	}
}
