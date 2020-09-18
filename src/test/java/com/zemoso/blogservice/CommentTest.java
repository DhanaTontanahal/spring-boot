package com.zemoso.blogservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.blogservice.model.Comment;
import com.zemoso.blogservice.repository.CommentRepository;
import com.zemoso.blogservice.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {
	@Autowired
	private CommentService commentService;

	@MockBean
	private CommentRepository commentRepository;
	
	@org.junit.Test
	public void getAllCOmments() {
		when(commentRepository.findAll()).thenReturn(Stream.of(
				new Comment(1l, "thank you",  122l, 22l,"Sep-16-2020" ))
				.collect(Collectors.toList()));
		assertEquals(1, commentService.getAllComments().size());
	}

	
	
}
