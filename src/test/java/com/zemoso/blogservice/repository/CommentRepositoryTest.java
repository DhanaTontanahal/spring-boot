package com.zemoso.blogservice.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Comment;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	public void testFindAll() {
		List<Comment> commentList = this.commentRepository.findAll();
		assertEquals(1,commentList.size());
	}
	

	public List<Comment> getCommentsById(Long blogId) throws ResourceNotFoundException {
		List<Comment> commentList = this.commentRepository.getCommentsByBlogId(blogId);
		return commentList;
	}
	
	@Test
	public void testGetCommentsByBlog() throws ResourceNotFoundException {
	
		List<Comment> commentList = getCommentsById(2l);
		assertEquals(0,commentList.size());

	}
	
	
	public void createNewComment() {
		Comment newComment = new Comment(2, "comment 2", 1, 122, "2020-02-20 05:10:00");
		this.commentRepository.save(newComment);
	}
	
	@Test
	public void testCreateComment() {
		createNewComment();
		List<Comment> commentList = this.commentRepository.findAll();
		assertEquals(2, commentList.size());
	}
	
	
}
