package com.zemoso.blogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.BlogTag;
import com.zemoso.blogservice.service.BlogTagService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://gentle-shelf-71423.herokuapp.com")
public class BlogTagController {

	@Autowired
	private BlogTagService blogTagService;
	
	@GetMapping("blogtags")
	public List<BlogTag> getAllBlogTags() {
		return this.blogTagService.getAllBlogTags();
	}
	
	@PostMapping("blogtags")
	public BlogTag createBlog(@RequestBody BlogTag blogTag) {
		return this.blogTagService.createBlogTag(blogTag);
	}
	
	@GetMapping("blogtags/{blogId}")
	public ResponseEntity<List<BlogTag>> getBlogTagByBlogId(@PathVariable(value = "blogId") Long blogId) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(this.blogTagService.getBlogTagsByBlogId(blogId));
	}
	
	@GetMapping("blogtags/tagnames/{blogId}")
	public ResponseEntity<List<String>> getTagNameListByBlogId(@PathVariable(value = "blogId") Long blogId) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(this.blogTagService.getTagNameListForBlogId(blogId));
	}
	
	
}
