package com.zemoso.blogservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zemoso.blogservice.controller.FollowUserMapController;
import com.zemoso.blogservice.model.FollowUserMap;
import com.zemoso.blogservice.service.FollowUserMapService;
@RunWith(SpringRunner.class)
@WebMvcTest(FollowUserMapController.class)
public class FollowUserMapControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	FollowUserMapService followUserMapService;
	
	@Test
	public void getAllFollowUserMapsPass1() throws Exception {
		List<FollowUserMap> followUserMapList = new ArrayList<>();
		Mockito.when(followUserMapService.getAllFollowUserMaps()).thenReturn(followUserMapList);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/followusermaps").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andReturn();
	}
}
