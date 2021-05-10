package com.example.RestAPI.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestAPI.Exception.ResourceNotFoundException;
import com.example.RestAPI.entity.HotelInfo;
import com.example.RestAPI.service.HotelService;


@RestController
@RequestMapping("/hotelmanagement")
public class HotelMainController {
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotel")
	public void addHotels(@RequestBody HotelInfo info){
		hotelService.add(info);
	}
	@GetMapping("/getHotels")
	public List getHotels(){
		//return "Hello";
		return hotelService.getHotels();
		
	}
	@PutMapping("/hotel/{id}")
	  public ResponseEntity<HotelInfo> updateUser(@PathVariable(value = "id") Integer hotelId,  @RequestBody HotelInfo hotelDetails) throws ResourceNotFoundException{
		return hotelService.updateUser(hotelId, hotelDetails);
	}
	@DeleteMapping("/hotel/{id}")
	public Map<String, Boolean> deleteUserReview(@PathVariable(value = "id") int id) throws Exception {
		return hotelService.deleteUserReview(id);
	}

}
