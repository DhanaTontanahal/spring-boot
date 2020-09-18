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

import com.zemoso.blogservice.controller.BlogTagController;
import com.zemoso.blogservice.model.BlogTag;
import com.zemoso.blogservice.service.BlogTagService;
@RunWith(SpringRunner.class)
@WebMvcTest(BlogTagController.class)
public class BlogTagControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	BlogTagService blogTagService;
	
	
	@Test
	public void getAllBlogTagsPass1() throws Exception {
		List<BlogTag> blogTagList = new ArrayList<>();
		
		Mockito.when(blogTagService.getAllBlogTags()).thenReturn(blogTagList);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/blogtags").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
			
				andReturn();
	}
	




	
}
