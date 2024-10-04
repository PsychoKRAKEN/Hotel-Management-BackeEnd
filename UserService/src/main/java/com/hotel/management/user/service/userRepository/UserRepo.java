package com.hotel.management.user.service.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.user.service.userEntity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>{

}
