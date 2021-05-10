package com.example.RestAPI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String name;
	private String address;
	private String proofOfIdentity;
	private int totalNoOfTravellers;
	private String gender;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String residentialCity;
	private String isGuest;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProofOfIdentity() {
		return proofOfIdentity;
	}
	public void setProofOfIdentity(String proofOfIdentity) {
		this.proofOfIdentity = proofOfIdentity;
	}
	public int getTotalNoOfTravellers() {
		return totalNoOfTravellers;
	}
	public void setTotalNoOfTravellers(int totalNoOfTravellers) {
		this.totalNoOfTravellers = totalNoOfTravellers;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getResidentialCity() {
		return residentialCity;
	}
	public void setResidentialCity(String residentialCity) {
		this.residentialCity = residentialCity;
	}
	public String getIsGuest() {
		return isGuest;
	}
	public void setIsGuest(String isGuest) {
		this.isGuest = isGuest;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", address=" + address + ", proofOfIdentity="
				+ proofOfIdentity + ", totalNoOfTravellers=" + totalNoOfTravellers + ", gender=" + gender + ", dob="
				+ dob + ", residentialCity=" + residentialCity + ", isGuest=" + isGuest + "]";
	}
	
	

}
