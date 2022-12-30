package com.devgetbook.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devgetbook.exceptions.ExceptionResponse;
import com.devgetbook.exceptions.InvalidJwtAuthenticationException;
import com.devgetbook.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceotionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			 Exception ex, WebRequest request){

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<> (exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
			 Exception ex, WebRequest request){

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<> (exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> handInvalidJwtAuthenticationException(
			Exception ex, WebRequest request){

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<> (exceptionResponse, HttpStatus.FORBIDDEN);

	}

}
