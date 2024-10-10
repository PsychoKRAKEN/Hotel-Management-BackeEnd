package com.hotel.management.user.service.userServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.user.service.proxy.HotelService;
import com.hotel.management.user.service.proxy.RatingService;
import com.hotel.management.user.service.userEntity.Hotels;
import com.hotel.management.user.service.userEntity.Rating;
import com.hotel.management.user.service.userEntity.UserEntity;
import com.hotel.management.user.service.userException.ResourseNotFoundException;
import com.hotel.management.user.service.userRepository.UserRepo;
import com.hotel.management.user.service.userService.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private HotelService hotelService;

	@Override
	public Boolean saveUser(UserEntity userEntity) {
		try {
			userRepo.save(userEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<UserEntity> getUser() {
		List<UserEntity> userList;
		try {
			userList=userRepo.findAll();
		} catch (Exception e) {
			return null;
		}
		return userList;
	}

	@Override
	public UserEntity getUserById(String userId) {
		Optional<UserEntity> userEntity;
		try {
			userEntity=userRepo.findById(userId);
		} catch (Exception e) {
			return null;
		}
		
		UserEntity user= userEntity.orElseThrow(()-> new ResourseNotFoundException("User Not Found with Given User Id : "+userId));
		
		List<Rating> ratings=ratingService.getAllRatingByUserId(user.getUserId()).getBody();
		
		if(ratings!=null && !ratings.isEmpty()) {
			ratings.forEach(r->{
				r.setHotel(hotelService.getHotel(r.getHotelId()).getBody());
			});
			
			user.setRatings(ratings);
		}
		
		return user;
	}

	@Override
	public Boolean deleteUser(String userId) {
		Optional<UserEntity> userEntity=userRepo.findById(userId);
		
		
		if(!userEntity.isPresent()) {
			return false;
		}
		
		try {
			userRepo.deleteById(userId);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean updateUser(UserEntity userEntity) {
		Optional<UserEntity> tempUserEntity=userRepo.findById(userEntity.getUserId());
		
		if(tempUserEntity.isPresent()) {
			if(userEntity.getUserEmail()==null || userEntity.getUserEmail().isEmpty()) {
				userEntity.setUserEmail(tempUserEntity.get().getUserEmail());
			}
			if(userEntity.getAbout()==null || userEntity.getAbout().isEmpty()) {
				userEntity.setAbout(tempUserEntity.get().getAbout());
			}
			if(userEntity.getUserName()==null || userEntity.getUserName().isEmpty()) {
				userEntity.setUserName(tempUserEntity.get().getUserName());
			}
		}else {
			return false;
		}
		
		try {
			
			userRepo.save(userEntity);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
