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

import com.zemoso.blogservice.controller.CommentController;
import com.zemoso.blogservice.model.Comment;
import com.zemoso.blogservice.service.CommentService;
import com.zemoso.blogservice.utilities.JsonUtils;

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
	

	@Test
	public void testCreateComment() throws Exception {
		Comment mockComment = new Comment();
		mockComment.setCommentId(1l);
		mockComment.setBlogId(1001l);
		mockComment.setCommentValue("Thank you");
		mockComment.setCreatedDate(new Date().toString());
		mockComment.setUserId(122l);
		
		String inputAsJson = JsonUtils.mapToJson(mockComment);
		
		String URI = "/api/v1/comments";
		
		Mockito.when(commentService.createComment(Mockito.any(Comment.class))).thenReturn(mockComment);
		
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
