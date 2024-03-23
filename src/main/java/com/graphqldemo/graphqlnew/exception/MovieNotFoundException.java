package com.graphqldemo.graphqlnew.exception;

public class MovieNotFoundException extends RuntimeException{
	public MovieNotFoundException(String message) {
		super(message);
	}
}
