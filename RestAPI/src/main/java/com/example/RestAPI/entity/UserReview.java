package com.example.RestAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserReview {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int hotelId;
	private int userId;
	private String review;
	private float rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "UserReview [id=" + id + ", hotelId=" + hotelId + ", userId=" + userId + ", review=" + review
				+ ", rating=" + rating +  "]";
	}
	
	

}
