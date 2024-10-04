package com.hotel.management.user.service.userController;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.user.service.userEntity.UserEntity;
import com.hotel.management.user.service.userService.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserEntity user){
		
		user.setUserId(UUID.randomUUID().toString());
		
		Boolean result=false;
		try {
			result=userService.saveUser(user);
		}catch(Exception e) {
			
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(!result) {
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<String>("Data Added",HttpStatus.OK);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<UserEntity> getUser(@RequestParam String userId){
		
		UserEntity result;
		result=userService.getUserById(userId);
		
		
		return new ResponseEntity<UserEntity>(result,HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserEntity>> getAllUser(){
		
		List<UserEntity> result;
		try {
			result=userService.getUser();
		}catch(Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(result==null || result.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserEntity user){
		
		Boolean result=false;
		try {
			result=userService.updateUser(user);
		}catch(Exception e) {
			
			return new ResponseEntity<String>("Server Side Issue",HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(!result) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Data Updated",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam String userId){
		
		Boolean result;
		try {
			result=userService.deleteUser(userId);
		}catch(Exception e) {
			
			return new ResponseEntity<String>("Server Issue",HttpStatus.SERVICE_UNAVAILABLE);	
		}
		
		if(!result) {
			return new ResponseEntity<String>("Type Correct Mobile No",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
	}


}
