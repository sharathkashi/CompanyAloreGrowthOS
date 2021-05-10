package com.example.RestAPI.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.RestAPI.Exception.ResourceNotFoundException;
import com.example.RestAPI.dao.HotelDao;
import com.example.RestAPI.dao.UserDao;
import com.example.RestAPI.entity.HotelInfo;
import com.example.RestAPI.entity.UserInfo;
import com.example.RestAPI.entity.UserReview;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public List getUsers(){
		
		List userList = null;
		userList=userDao.findAll();
		return userList;
	}

	public void add(UserInfo info) {
		UserInfo saved = userDao.save(info);
		//System.out.println(saved);
		// TODO Auto-generated method stub
		
	}
	
	  public ResponseEntity<UserInfo> updateUser( Integer userId,UserInfo userDetails)
	      throws ResourceNotFoundException {

		  UserInfo user =
	    		userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found on :: " + userId));
		  
		  user.setAddress(userDetails.getAddress());
		  user.setDob(userDetails.getDob());
		  user.setGender(userDetails.getGender());
		  user.setIsGuest(userDetails.getIsGuest());
		  user.setName(userDetails.getName());
		  user.setProofOfIdentity(userDetails.getProofOfIdentity());
		  user.setResidentialCity(userDetails.getResidentialCity());
		  user.setTotalNoOfTravellers(userDetails.getTotalNoOfTravellers());
		  
		  final UserInfo updatedHotel=userDao.save(user);
	    return ResponseEntity.ok(updatedHotel);
	  }

	  public Map<String, Boolean> deleteUser(int id) throws ResourceNotFoundException {
			  UserInfo user = userDao
	         .findById(id)
	         .orElseThrow(() -> new ResourceNotFoundException("UserReview not found on :: " + id));

			  userDao.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
		}
}
