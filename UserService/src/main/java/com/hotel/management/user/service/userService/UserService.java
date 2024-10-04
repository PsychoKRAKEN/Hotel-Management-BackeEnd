package com.hotel.management.user.service.userService;

import java.util.List;
import java.util.Optional;

import com.hotel.management.user.service.userEntity.UserEntity;

public interface UserService {
	
	Boolean saveUser(UserEntity userEntity);
	
	List<UserEntity> getUser();
	
	UserEntity getUserById(String userId);
	
	Boolean deleteUser(String userId);
	
	Boolean updateUser(UserEntity userEntity);

}
