package com.zemoso.blogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blogservice.model.FollowUserMap;
import com.zemoso.blogservice.repository.FollowUserMapRepository;

@Service
public class FollowUserMapService {

	@Autowired
	private FollowUserMapRepository followUserMapRepository;
	
	public List<FollowUserMap> getAllFollowUserMaps() {
		return this.followUserMapRepository.findAll();
	}

}
