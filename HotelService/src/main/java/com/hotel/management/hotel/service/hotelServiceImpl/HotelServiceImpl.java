package com.hotel.management.hotel.service.hotelServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.hotel.service.hotelEntity.HotelEntity;
import com.hotel.management.hotel.service.hotelException.ResourseNotFoundException;
import com.hotel.management.hotel.service.hotelRepository.HotelRepo;
import com.hotel.management.hotel.service.hotelService.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelRepo;
	
	@Override
	public Boolean createHotel(HotelEntity hotelEntity) {
		try {
			hotelRepo.save(hotelEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<HotelEntity> getAllHotel() {
		
		return hotelRepo.findAll();
	}

	@Override
	public HotelEntity getHotelById(String hotelId) {
		
		return hotelRepo.findById(hotelId).orElseThrow(()->new ResourseNotFoundException("Hotel Not Found with Given User Id : "+hotelId));
	}

}
