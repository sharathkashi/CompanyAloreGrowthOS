package com.example.RestAPI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HotelInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	private String address;
	private float averageRating;
	private String isWifiAvailable;
	private String isMealAvailable;
	private String isrestaurentAvailable;
	private String isAirconditionAvailable;
	private float castPerDay;
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkIn;
	private int totalrooms;
	private String roomsAvailable;
	private int roomsBookedTillDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public String getIsWifiAvailable() {
		return isWifiAvailable;
	}

	public void setIsWifiAvailable(String isWifiAvailable) {
		this.isWifiAvailable = isWifiAvailable;
	}

	public String getIsMealAvailable() {
		return isMealAvailable;
	}

	public void setIsMealAvailable(String isMealAvailable) {
		this.isMealAvailable = isMealAvailable;
	}

	public String getIsrestaurentAvailable() {
		return isrestaurentAvailable;
	}

	public void setIsrestaurentAvailable(String isrestaurentAvailable) {
		this.isrestaurentAvailable = isrestaurentAvailable;
	}

	public String getIsAirconditionAvailable() {
		return isAirconditionAvailable;
	}

	public void setIsAirconditionAvailable(String isAirconditionAvailable) {
		this.isAirconditionAvailable = isAirconditionAvailable;
	}

	public float getCastPerDay() {
		return castPerDay;
	}

	public void setCastPerDay(float castPerDay) {
		this.castPerDay = castPerDay;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public int getTotalrooms() {
		return totalrooms;
	}

	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}

	public String getRoomsAvailable() {
		return roomsAvailable;
	}

	public void setRoomsAvailable(String roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

	public int getRoomsBookedTillDate() {
		return roomsBookedTillDate;
	}

	public void setRoomsBookedTillDate(int roomsBookedTillDate) {
		this.roomsBookedTillDate = roomsBookedTillDate;
	}

	@Override
	public String toString() {
		return "HotelInfo [id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", averageRating="
				+ averageRating + ", isWifiAvailable=" + isWifiAvailable + ", isMealAvailable=" + isMealAvailable
				+ ", isrestaurentAvailable=" + isrestaurentAvailable + ", isAirconditionAvailable="
				+ isAirconditionAvailable + ", castPerDay=" + castPerDay + ", checkIn=" + checkIn + ", totalrooms="
				+ totalrooms + ", roomsAvailable=" + roomsAvailable + ", roomsBookedTillDate=" + roomsBookedTillDate
				+ "]";
	}
	

}
