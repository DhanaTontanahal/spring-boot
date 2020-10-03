package com.zemoso.blogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoso.blogservice.model.FollowUserMap;
import com.zemoso.blogservice.service.FollowUserMapService;

@RestController
@RequestMapping("/api/v1")
public class FollowUserMapController {
	
	@Autowired
	private FollowUserMapService followUserMapService;
	
	@GetMapping("followusermaps")
	public List<FollowUserMap> getAllFollowUserMaps() {
		return this.followUserMapService.getAllFollowUserMaps();
	}

}
