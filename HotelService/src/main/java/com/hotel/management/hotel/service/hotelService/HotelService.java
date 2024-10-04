package com.hotel.management.hotel.service.hotelService;

import java.util.List;

import com.hotel.management.hotel.service.hotelEntity.HotelEntity;

public interface HotelService {
	
	Boolean createHotel(HotelEntity hotelEntity);
	
	List<HotelEntity> getAllHotel();
	
	HotelEntity getHotelById(String hotelId);

}
