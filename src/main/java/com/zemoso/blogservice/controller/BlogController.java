package com.zemoso.blogservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Blog;
import com.zemoso.blogservice.service.BlogService;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping("test-blog")
	public Blog getDummyBlog() {

		return new Blog(1001l, "blog title", "blog content", null, "dhana", "http://myimages.thisone.com/cats/1",
				"2 min", 122l, 0, null);
	}

	@GetMapping(value = "blogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Blog> getAllBlogs() {
		return this.blogService.getAllBlogs();
	}

	@GetMapping(value = "blogs/{blogId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getBlogById(@PathVariable(value = "blogId") Long blogId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(this.blogService.getBlogById(blogId));
	}

	@PostMapping(value = "blogs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Blog createBlog(@RequestBody Blog blog) {
		return blogService.createBlog(blog);
	}

	@PutMapping("blogs/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") Long blogId, @RequestBody Blog blog)
			throws ResourceNotFoundException {
		Blog blogFromDB = blogService.getBlogById(blogId);

		blogFromDB.setBlogId(blog.getBlogId());
		blogFromDB.setTitle(blog.getTitle());
		blogFromDB.setContent(blog.getContent());
		blogFromDB.setPostedDate(blog.getPostedDate());
		blogFromDB.setPostImgUrl(blog.getPostImgUrl());
		blogFromDB.setPostedBy(blog.getPostedBy());
		blogFromDB.setReadTime(blog.getReadTime());
		blogFromDB.setuId(blog.getuId());
		blogFromDB.setClapsCount(blog.getClapsCount());
		blogFromDB.setUpdatedDate(blog.getUpdatedDate());

		return ResponseEntity.ok(blogService.createBlog(blog));
	}

	@DeleteMapping("blogs/{id}")
	public Map<String, Boolean> deleteBlog(@PathVariable(value = "id") Long blogId) throws ResourceNotFoundException {
		Blog blogFromDB = blogService.getBlogById(blogId);
		return blogService.deleteBlog(blogFromDB);
	}

}
