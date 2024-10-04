package com.hotel.management.hotel.service.hotelController;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.hotel.service.hotelEntity.HotelEntity;
import com.hotel.management.hotel.service.hotelService.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotel")
	public ResponseEntity<String> addHotel(@RequestBody HotelEntity hotel){
		
		hotel.setHotelId(UUID.randomUUID().toString());
		
		Boolean result=false;
		try {
			result=hotelService.createHotel(hotel);
		}catch(Exception e) {
			
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(!result) {
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<String>("Data Added",HttpStatus.OK);
	}
	
	@GetMapping("/getHotel")
	public ResponseEntity<HotelEntity> getHotel(@RequestParam String hotelId){
		
		HotelEntity result;
		result=hotelService.getHotelById(hotelId);
		
		return new ResponseEntity<HotelEntity>(result,HttpStatus.OK);
	}
	
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<HotelEntity>> getAllHotel(){
		
		List<HotelEntity> result;
		try {
			result=hotelService.getAllHotel();
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(result==null || result.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

}
