package com.zemoso.blogservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.blogservice.model.Blog;
import com.zemoso.blogservice.repository.BlogReposit;
import com.zemoso.blogservice.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogTest {

	@Autowired
	private BlogService service;

	@MockBean
	private BlogReposit repository;

	@org.junit.Test
	public void getAllBlogsest() {
		when(repository.findAll()).thenReturn(Stream.of(
				new Blog( 1002l,  "title",  "content", new Date (0), "postedBy", "String postImgUrl",
						"String readTime", 100l ,  0, new Date (0)))
				.collect(Collectors.toList()));
		assertEquals(1, service.getAllBlogs().size());
	}

	
	


}
