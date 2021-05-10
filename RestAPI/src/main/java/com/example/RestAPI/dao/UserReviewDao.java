package com.example.RestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RestAPI.entity.UserReview;

public interface UserReviewDao extends JpaRepository<UserReview,Integer>{

}
