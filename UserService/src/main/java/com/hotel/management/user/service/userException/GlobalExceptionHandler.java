package com.hotel.management.user.service.userException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.management.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourseNotFoundException ex){
		
		ApiResponse apiResponse=new ApiResponse();
		
		apiResponse.setMessage(ex.getMessage());
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(true);
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
