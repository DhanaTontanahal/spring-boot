package com.zemoso.blogservice.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zemoso.blogservice.controller.UserController;
import com.zemoso.blogservice.model.User;
import com.zemoso.blogservice.service.UserService;
import com.zemoso.blogservice.utilities.JsonUtils;
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@Test
	public void getAllUsersPass1() throws Exception {
		List<User> userList = new ArrayList<>();
		Mockito.when(userService.getAllUsers()).thenReturn(userList);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/users").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andReturn();
	}
	
	@Test
	public void testUser() throws Exception {
		User mockUser = new User();
		mockUser.setUserId(122l);
		mockUser.setUserName("Dhana");
		mockUser.setAbout("Self motivated");
		mockUser.setActive(true);
		mockUser.setAvatarLink("avatarLink");
		mockUser.setCreatedDate(new Date());
		mockUser.setFirstName("Dhana");
		mockUser.setLastName("Tontanahal");
		mockUser.setTwitterUrl("twitterUrl");
		
		String inputAsJson = JsonUtils.mapToJson(mockUser);
		
		String URI = "/api/v1/users";
		
		Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(mockUser);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputAsJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertEquals(outputInJson,inputAsJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
}
