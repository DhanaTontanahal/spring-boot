package com.zemoso.blogservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Comment;
import com.zemoso.blogservice.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAllComments() {
		return this.commentRepository.findAll();
	}

	public Comment getComentByPostId(Long postId) throws ResourceNotFoundException {
		Comment comment = this.commentRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
		return comment;
	}

	
	public List<Comment> getCommentsByPostId(long blogId){
		return this.commentRepository.getCommentsByBlogId(blogId);
		
	}
	
	public Comment createComment(Comment comment) {
		return this.commentRepository.save(comment);
	}
	
	

	public Map<String, Boolean> deleteComment(Long commentId) throws ResourceNotFoundException {
		Comment commentFromDB = this.commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
		this.commentRepository.delete(commentFromDB);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
}
