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

import com.zemoso.blogservice.controller.BlogController;
import com.zemoso.blogservice.model.Blog;
import com.zemoso.blogservice.service.BlogService;

@RunWith(SpringRunner.class)
@WebMvcTest(BlogController.class)
public class BlogControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	BlogService blogService;
	
	@Test
	public void getTestBlog1() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/test-blog").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andReturn();

	}
	
	@Test
	public void getTestBlog2() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/test-blog").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andExpect(MockMvcResultMatchers.content().string("{\"blogId\":1001,\"title\":\"blog title\",\"content\":\"blog content\",\"postedDate\":null,\"postedBy\":\"dhana\",\"postImgUrl\":\"http://myimages.thisone.com/cats/1\",\"readTime\":\"2 min\",\"clapsCount\":0,\"updatedDate\":null,\"uId\":122}")).
				andReturn();

	}
	
	@Test
	public void getTestBlog3() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/blogs").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andReturn();

	}
	
	@Test
	public void getTestBlog4() throws Exception {
		List<Blog> blogList = new ArrayList<>();
		Blog blog = new Blog(1001l,"blog title" , "blog content", null, "dhana",  "http://myimages.thisone.com/cats/1","2 min", 122, 0, null);
		blogList.add(blog);
		Mockito.when(blogService.getAllBlogs()).thenReturn(blogList);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/blogs").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andExpect(MockMvcResultMatchers.content().json("[{\"blogId\":1001,\"title\":\"blog title\",\"content\":\"blog content\",\"postedDate\":null,\"postedBy\":\"dhana\",\"postImgUrl\":\"http://myimages.thisone.com/cats/1\",\"readTime\":\"2 min\",\"clapsCount\":0,\"updatedDate\":null,\"uId\":122}]")).
				andReturn();
	}
	

	@Test
	public void getTestBlog5() throws Exception {
		Blog blog = new Blog(1001l,"blog title" , "blog content", null, "dhana",  "http://myimages.thisone.com/cats/1","2 min", 122, 0, null);
		Long blogId=1001l;
		Mockito.when(blogService.getBlogById(blogId)).thenReturn(blog);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/blogs/1001").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andExpect(MockMvcResultMatchers.content().json("{\"blogId\":1001,\"title\":\"blog title\",\"content\":\"blog content\",\"postedDate\":null,\"postedBy\":\"dhana\",\"postImgUrl\":\"http://myimages.thisone.com/cats/1\",\"readTime\":\"2 min\",\"clapsCount\":0,\"updatedDate\":null,\"uId\":122}")).
				andReturn();
	}

	
	 
	
}
