package com.hotel.management.hotel.service.hotelRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.hotel.service.hotelEntity.HotelEntity;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, String>{

}
