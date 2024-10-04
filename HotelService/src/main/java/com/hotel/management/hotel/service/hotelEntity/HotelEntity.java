package com.hotel.management.hotel.service.hotelEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="HOTEL_MANAGEMENT_HOTEL")
public class HotelEntity {
	
	@Id
	@Column(name="HOTEL_ID")
	private String hotelId;
	
	@Column(name="HOTEL_NAME")
	private String hotelName;
	
	@Column(name="HOTEL_LOCATION")
	private String location;
	
	@Column(name="HOTEL_ABOUT")
	private String about;
	
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "HotelEntity [hotelId=" + hotelId + ", hotelName=" + hotelName + ", location=" + location + ", about="
				+ about + "]";
	}
	
	
	

}
