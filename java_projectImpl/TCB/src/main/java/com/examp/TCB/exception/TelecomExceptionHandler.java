package com.examp.TCB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TelecomExceptionHandler {

	@ExceptionHandler(value = { TelecomNotFoundException.class })
	public ResponseEntity<Object> handleTelecomNotFoundException(TelecomNotFoundException telecomNotFoundException) {

		// Create a custom TelecomException with the message, cause, and status
		TelecomException telecomException = new TelecomException(telecomNotFoundException.getMessage(),
				telecomNotFoundException.getCause(), HttpStatus.NOT_FOUND

		);

		// Return a ResponseEntity with the custom TelecomException and HTTP status
		return new ResponseEntity<>(telecomException, HttpStatus.NOT_FOUND);
	}
}
