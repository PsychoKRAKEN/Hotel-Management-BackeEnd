package com.hotel.management.user.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.management.user.service.userEntity.Hotels;


@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/hotels/getHotel")
	public ResponseEntity<Hotels> getHotel(@RequestParam String hotelId);

}
