package com.zemoso.blogservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Blog;
import com.zemoso.blogservice.repository.BlogReposit;

@Service
public class BlogService {
	
	@Autowired
	private BlogReposit blogRepository;
	
	public List<Blog> getAllBlogs() {
		return this.blogRepository.findAll();
	}
	
	public Blog getBlogById(Long blogId) throws ResourceNotFoundException {
		return this.blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
	}

	public Blog createBlog(Blog blog) {
		return this.blogRepository.save(blog);
	}

	public Map<String,Boolean> deleteBlog(Blog blog) throws ResourceNotFoundException{
	
		this.blogRepository.delete(blog);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	
}
