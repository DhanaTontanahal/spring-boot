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

import com.zemoso.blogservice.model.BlogTag;
import com.zemoso.blogservice.repository.BlogTagReposit;
import com.zemoso.blogservice.service.BlogTagService;

@RunWith(MockitoJUnitRunner.class)
public class BlogTagsServiceTest {
	
	@InjectMocks
	private BlogTagService blogTagService;
	
	@Mock
	private BlogTagReposit blogTagReposit;
	
	@Test
	public void testGetAllBlogTags() {
		List<BlogTag> blogTagList = new ArrayList<>();
		
		Mockito.when(blogTagReposit.findAll()).thenReturn(blogTagList);
		
		List<BlogTag> blogTagListReturned = blogTagService.getAllBlogTags();
		assertEquals( 0,blogTagListReturned.size());
		
		
	}

}
