package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleEmptyListException(ListEmptyException e) {
		ErrorResponseModel model = ErrorResponseModel.builder().message(e.getMessage())
				.errorCode(HttpStatus.BAD_REQUEST.value()).errorReportingTime(System.currentTimeMillis()).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleProductNotFoundException(ProductNotFoundException e)
	{
		ErrorResponseModel model = ErrorResponseModel.builder().message(e.getMessage())
				.errorCode(HttpStatus.NOT_FOUND.value()).errorReportingTime(System.currentTimeMillis()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);

	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handlegeneralException(Exception e)
	{
		ErrorResponseModel model = ErrorResponseModel.builder().message(e.getMessage())
				.errorCode(HttpStatus.NOT_FOUND.value()).errorReportingTime(System.currentTimeMillis()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);

	}


}
