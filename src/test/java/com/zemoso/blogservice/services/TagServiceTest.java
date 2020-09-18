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

import com.zemoso.blogservice.model.Tag;
import com.zemoso.blogservice.repository.TagRepository;
import com.zemoso.blogservice.service.TagService;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {
	
	@InjectMocks
	private TagService tagService;
	
	@Mock
	private TagRepository tagRepository;
	
	@Test
	public void testGetAllTags() {
		List<Tag> tagList = new ArrayList<>();
		
		Mockito.when(tagRepository.findAll()).thenReturn(tagList);
		
		List<Tag> tagListReturned = tagService.getAllTags();
		assertEquals(tagListReturned.size(), 0);
		
		
	}

}
