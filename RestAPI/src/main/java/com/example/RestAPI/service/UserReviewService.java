package com.example.RestAPI.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.RestAPI.Exception.ResourceNotFoundException;
import com.example.RestAPI.dao.HotelDao;
import com.example.RestAPI.dao.UserDao;
import com.example.RestAPI.dao.UserReviewDao;
import com.example.RestAPI.entity.HotelInfo;
import com.example.RestAPI.entity.UserInfo;
import com.example.RestAPI.entity.UserReview;

@Service
public class UserReviewService {
	@Autowired
	private UserReviewDao userReviewDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private UserDao userDao;
	
	public List<UserReview> getReviews() {
		List<UserReview> reviewList=userReviewDao.findAll();
		return reviewList;
	}
	
	public void add(UserReview info) throws ResourceNotFoundException {
		float oldRating = info.getRating();
		System.out.println("info.getHotelId() "+info.getHotelId());
		HotelInfo hotel = hotelDao.findById(info.getHotelId()).orElseThrow(() -> new ResourceNotFoundException("Hotel not found on :: " + info.getHotelId()));
		float rating = hotel.getAverageRating();
		float newRating = (rating+oldRating)/2;
		hotel.setAverageRating(newRating);
		hotelDao.save(hotel);
		//info.setHotelPreRating(rating);
		userReviewDao.save(info);
	}

	public ResponseEntity<UserReview> updateUserReview(Integer userId, UserReview userReviewDetails) throws ResourceNotFoundException {
		UserReview user =
				userReviewDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found on :: " + userId));
		  
		HotelInfo hotel =
	    		hotelDao.findById(userReviewDetails.getHotelId()).orElseThrow(() -> new ResourceNotFoundException("Hotel not found on :: " + userReviewDetails.getHotelId()));
		
		float newRating = (hotel.getAverageRating()*2-user.getRating()+userReviewDetails.getRating())/2;
		hotel.setAverageRating(newRating);
		hotelDao.save(hotel);
		  user.setHotelId(userReviewDetails.getHotelId());
		  user.setUserId(userReviewDetails.getUserId());
		  user.setRating(userReviewDetails.getRating());
		  user.setReview(userReviewDetails.getReview());
		  
		  final UserReview updatedHotel=userReviewDao.save(user);
	    return ResponseEntity.ok(updatedHotel);
	}

	public Map<String, Boolean> deleteUserReview(int id) throws ResourceNotFoundException {
		 UserReview user = userReviewDao
         .findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("UserReview not found on :: " + id));
		 
		 HotelInfo hotel =
		    		hotelDao.findById(user.getHotelId()).orElseThrow(() -> new ResourceNotFoundException("Hotel not found on :: " + user.getHotelId()));
			
			float newRating = hotel.getAverageRating()*2-user.getRating();
			hotel.setAverageRating(newRating);
			hotelDao.save(hotel);

		 userReviewDao.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
	}

	

}
