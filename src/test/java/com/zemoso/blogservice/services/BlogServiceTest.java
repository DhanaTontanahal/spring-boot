package com.zemoso.blogservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.Mockito;

import com.zemoso.blogservice.model.Blog;
import com.zemoso.blogservice.repository.BlogReposit;
import com.zemoso.blogservice.service.BlogService;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceTest {
	
	@InjectMocks
	private BlogService blogService;
	
	@Mock
	private BlogReposit blogReposit;
	
	@Test
	public void testGetAllBlogs() {
		List<Blog> blogList = new ArrayList<>();
		Blog blog = new Blog(1001l,"blog title" , "blog content", null, "dhana",  "http://myimages.thisone.com/cats/1","2 min", 122, 0, null);
		blogList.add(blog);
		Mockito.when(blogReposit.findAll()).thenReturn(blogList);
		
		List<Blog> blogListReturned = blogService.getAllBlogs();
		assertEquals( 1,blogListReturned.size());
	}
	
	private Blog getBlog(Long blogId) {
		Blog blog = new Blog(1001l,"blog title" , "blog content", null, "dhana",  "http://myimages.thisone.com/cats/1","2 min", 122, 0, null);
		return blog;
	}

//	@Test
	public void testGetBlogById() throws Exception{
		Optional<Blog> blog = Optional.ofNullable(getBlog(1001l));
		Long id = 1001l;
		Mockito.when(blogReposit.findById(id)).thenReturn(blog);
	}
}
