package com.hotel.management.rating.service.ratingServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.rating.service.ratingEntity.RatingEntity;
import com.hotel.management.rating.service.ratingRepository.RatingRepo;
import com.hotel.management.rating.service.ratingService.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Boolean addRating(RatingEntity ratingEntity) {
		try {
			ratingRepo.save(ratingEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<RatingEntity> getAllRating() {
		List<RatingEntity> ratingList;
		try {
			ratingList=ratingRepo.findAll();
		} catch (Exception e) {
			return null;
		}
		return ratingList;
	}

	@Override
	public List<RatingEntity> getRatingByUserId(String userId) {
		List<RatingEntity> ratingList;
		try {
			ratingList=ratingRepo.findByUserId(userId);
		} catch (Exception e) {
			return null;
		}
		return ratingList;
	}

	@Override
	public List<RatingEntity> getRatingByHotelId(String hotelId) {
		List<RatingEntity> ratingList;
		try {
			ratingList=ratingRepo.findByHotelId(hotelId);
		} catch (Exception e) {
			return null;
		}
		return ratingList;
	}

}
