package com.zemoso.blogservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zemoso.blogservice.WelcomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getMessageTest() throws Exception {
		// call /welcome
		// verify "Welcome to ZeMoSo Technologies"
		
		RequestBuilder request = MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andExpect(MockMvcResultMatchers.content().string("Welcome to ZeMoSo Technologies")).
				andReturn();
		
		assertEquals("Welcome to ZeMoSo Technologies", result.getResponse().getContentAsString());
	}

}
