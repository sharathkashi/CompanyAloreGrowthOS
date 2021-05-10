package com.example.RestAPI.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.RestAPI.Exception.ResourceNotFoundException;
import com.example.RestAPI.dao.HotelDao;
import com.example.RestAPI.entity.HotelInfo;
import com.example.RestAPI.entity.UserReview;

@Service
public class HotelService {
	@Autowired
	private HotelDao hotelDao;
	
	public List getHotels(){
		
		List HotelList = null;
		HotelList=hotelDao.findAll();
		return HotelList;
	}

	public void add(HotelInfo info) {
		HotelInfo saved = hotelDao.save(info);
		//System.out.println(saved);
		// TODO Auto-generated method stub
		
	}
	
	  public ResponseEntity<HotelInfo> updateUser( Integer hotelId,HotelInfo hotelDetails)
	      throws ResourceNotFoundException {

		  HotelInfo hotel =
	    		hotelDao.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found on :: " + hotelId));
		  hotel.setAddress(hotelDetails.getAddress());
		  hotel.setAverageRating(hotelDetails.getAverageRating());
		  hotel.setCastPerDay(hotelDetails.getCastPerDay());
		  hotel.setCheckIn(hotelDetails.getCheckIn());
		  hotel.setCity(hotelDetails.getCity());
		  hotel.setName(hotelDetails.getName());
		  hotel.setIsAirconditionAvailable(hotelDetails.getIsAirconditionAvailable());
		  hotel.setIsMealAvailable(hotelDetails.getIsMealAvailable());
		  hotel.setIsrestaurentAvailable(hotelDetails.getIsrestaurentAvailable());
		  hotel.setIsWifiAvailable(hotelDetails.getIsWifiAvailable());
		  hotel.setRoomsAvailable(hotelDetails.getRoomsAvailable());
		  hotel.setRoomsBookedTillDate(hotelDetails.getRoomsBookedTillDate());
		  hotel.setTotalrooms(hotelDetails.getTotalrooms());
		  
		  final HotelInfo updatedHotel=hotelDao.save(hotel);
	    return ResponseEntity.ok(updatedHotel);
	  }
	  public Map<String, Boolean> deleteUserReview(int id) throws ResourceNotFoundException {
			  HotelInfo user = hotelDao
	         .findById(id)
	         .orElseThrow(() -> new ResourceNotFoundException("UserReview not found on :: " + id));
			 hotelDao.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
		}

}
