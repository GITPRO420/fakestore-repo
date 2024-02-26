package com.pk.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseEntityExceptionHandlerForProduct extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResposne> handlerProductNotFoundException(ProductNotFoundException e) {

		return new ResponseEntity<>(ErrorResposne.builder().message(e.getMessage()).errorCode(e.getErrorCode()).build(),
				HttpStatus.OK);

	}

}
