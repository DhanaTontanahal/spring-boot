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

import com.zemoso.blogservice.model.Comment;
import com.zemoso.blogservice.repository.CommentRepository;
import com.zemoso.blogservice.service.CommentService;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {
	
	@InjectMocks
	private CommentService commentService;
	
	@Mock
	private CommentRepository commentRepository;
	
	@Test
	public void testGetAllComments() {
		List<Comment> commentList = new ArrayList<>();
		Mockito.when(commentRepository.findAll()).thenReturn(commentList);
		List<Comment> commentListReturned = commentService.getAllComments();
		assertEquals(commentListReturned.size(), 0);
		
	}

}
