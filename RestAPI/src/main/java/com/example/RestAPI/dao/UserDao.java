package com.example.RestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RestAPI.entity.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, Integer>{

}
