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

import com.zemoso.blogservice.controller.CommentController;
import com.zemoso.blogservice.model.Comment;
import com.zemoso.blogservice.service.CommentService;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CommentService commentService;
	
	

	
	@Test
	public void testGetComments() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/comments").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andReturn();
	}
	
	@Test
	public void getTestBlog4() throws Exception {
		List<Comment> commentList = new ArrayList<>();
		
		Mockito.when(commentService.getAllComments()).thenReturn(commentList);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/comments").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andExpect(MockMvcResultMatchers.content().json("[]")).
				andReturn();
	}
	




	
}
