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
import com.example.RestAPI.entity.UserReview;
import com.example.RestAPI.service.UserReviewService;

@RestController
@RequestMapping("/userreview")
public class UserReviewController {
	@Autowired
	private UserReviewService userReviewService; 
	
	@GetMapping("/getreviews")
	public List<UserReview> getReviews(){
		List<UserReview> reviewList=userReviewService.getReviews();
		return reviewList;
	}
	@PostMapping("/addreview")
	public void addReview(@RequestBody UserReview info) throws ResourceNotFoundException{
		userReviewService.add(info);
	}
	@PutMapping("/user/{id}")
	  public ResponseEntity<UserReview> updateUser(@PathVariable(value = "id") Integer userId,  @RequestBody UserReview userReviewDetails) throws ResourceNotFoundException{
		return userReviewService.updateUserReview(userId, userReviewDetails);
	}
	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUserReview(@PathVariable(value = "id") int id) throws Exception {
		return userReviewService.deleteUserReview(id);
	}
	    
}
