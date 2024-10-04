package com.hotel.management.rating.service.ratingRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.rating.service.ratingEntity.RatingEntity;

@Repository
public interface RatingRepo extends JpaRepository<RatingEntity, String>{
	
	List<RatingEntity> findByUserId(String userId);
	
	List<RatingEntity> findByHotelId(String hotelId);

}
