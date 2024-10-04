package com.hotel.management.rating.service.ratingController;

import java.util.ArrayList;
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

import com.hotel.management.rating.service.ratingEntity.RatingEntity;
import com.hotel.management.rating.service.ratingService.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addRating")
	public ResponseEntity<String> addRating(@RequestBody RatingEntity rating){
		
		rating.setRatingId(UUID.randomUUID().toString());
		
		Boolean result=false;
		try {
			result=ratingService.addRating(rating);
		}catch(Exception e) {
			
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(!result) {
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<String>("Data Added",HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatingByUserId")
	public ResponseEntity<List<RatingEntity>> getAllRatingByUserId(@RequestParam String userId){
		
		List<RatingEntity> result;
		try {
			result=ratingService.getRatingByUserId(userId);
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(result==null || result.isEmpty()) {
			return new ResponseEntity<>(new ArrayList<RatingEntity>(),HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatingByHotelId")
	public ResponseEntity<List<RatingEntity>> getAllRatingByHotelId(@RequestParam String hotelId){
		
		List<RatingEntity> result;
		try {
			result=ratingService.getRatingByHotelId(hotelId);
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(result==null || result.isEmpty()) {
			return new ResponseEntity<>(new ArrayList<RatingEntity>(),HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("/getAllRating")
	public ResponseEntity<List<RatingEntity>> getAllRating(){
		
		List<RatingEntity> result;
		try {
			result=ratingService.getAllRating();
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(result==null || result.isEmpty()) {
			return new ResponseEntity<>(new ArrayList<RatingEntity>(),HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

}
