package com.hotel.management.hotel.service.hotelException;

public class ResourseNotFoundException extends RuntimeException {
	
	public ResourseNotFoundException() {
		super("Resourse Not Found on Server!");
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
