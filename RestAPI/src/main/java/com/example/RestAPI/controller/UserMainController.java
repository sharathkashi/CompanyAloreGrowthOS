package com.example.RestAPI.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestAPI.Exception.ResourceNotFoundException;
import com.example.RestAPI.entity.UserInfo;
import com.example.RestAPI.service.UserService;

@RestController
@RequestMapping("/user")
public class UserMainController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public void addHotels(@RequestBody UserInfo info){
		userService.add(info);
	}
	@GetMapping("/getUsers")
	public List getUsers(){
		//return "Hello";
		return userService.getUsers();
		
	}
	@PutMapping("/user/{id}")
	  public ResponseEntity<UserInfo> updateUser(@PathVariable(value = "id") Integer userId,  @RequestBody UserInfo userDetails) throws ResourceNotFoundException{
		return userService.updateUser(userId, userDetails);
	}
	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int id) throws Exception {
		return userService.deleteUser(id);
	}

}
