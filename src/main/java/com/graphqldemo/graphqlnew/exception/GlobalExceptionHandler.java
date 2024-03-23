package com.graphqldemo.graphqlnew.exception;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.GraphQLError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@GraphQlExceptionHandler
	public GraphQLError handleMovieNotFoundException(MovieNotFoundException ex) {
		return GraphQLError.newError().message(ex.getMessage()).build();
	}
}
