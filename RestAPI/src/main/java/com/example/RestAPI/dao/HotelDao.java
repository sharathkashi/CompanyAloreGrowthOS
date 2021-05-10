package com.example.RestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestAPI.entity.HotelInfo;

@Repository
public interface HotelDao extends JpaRepository<HotelInfo, Integer> {

}
