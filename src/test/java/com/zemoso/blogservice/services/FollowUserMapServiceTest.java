package com.zemoso.blogservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.zemoso.blogservice.model.FollowUserMap;
import com.zemoso.blogservice.repository.FollowUserMapRepository;
import com.zemoso.blogservice.service.FollowUserMapService;

@RunWith(MockitoJUnitRunner.class)
public class FollowUserMapServiceTest {
	
	@InjectMocks
	private FollowUserMapService followUserMapService;
	
	@Mock
	private FollowUserMapRepository followUserMapRepository;
	
	@Test
	public void testGetAllFollowUserMaps() {
		List<FollowUserMap> followUserMapList = new ArrayList<>();
	
		Mockito.when(followUserMapRepository.findAll()).thenReturn(followUserMapList);
		
		List<FollowUserMap> followUserMapListReturned = followUserMapService.getAllFollowUserMaps();
		assertEquals(followUserMapListReturned.size(), 0);
		
		
	}

}
