package com.hotel.management.user.service.userException;

public class ResourseNotFoundException extends RuntimeException {
	
	public ResourseNotFoundException() {
		super("Resourse Not Found on Server!");
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
