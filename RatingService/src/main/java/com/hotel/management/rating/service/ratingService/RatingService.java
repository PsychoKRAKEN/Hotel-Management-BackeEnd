package com.hotel.management.rating.service.ratingService;

import java.util.List;

import com.hotel.management.rating.service.ratingEntity.RatingEntity;

public interface RatingService {
	
	Boolean addRating(RatingEntity ratingEntity);
	
	List<RatingEntity> getAllRating();
	
	List<RatingEntity> getRatingByUserId(String userId);
	
	List<RatingEntity> getRatingByHotelId(String hotelId);

}
