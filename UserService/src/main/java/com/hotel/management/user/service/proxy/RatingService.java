package com.hotel.management.user.service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.management.user.service.userEntity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/getAllRatingByUserId")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@RequestParam String userId);

}
