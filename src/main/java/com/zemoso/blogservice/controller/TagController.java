package com.zemoso.blogservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Tag;
import com.zemoso.blogservice.service.TagService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	
	@GetMapping("tags")
	public List<Tag> getAllBlogs() {
		return this.tagService.getAllTags();
	}
	
	@GetMapping("tags/{tagId}")
	public ResponseEntity<Tag> getTagById(@PathVariable(value = "tagId") Long tagId) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(this.tagService.getTagById(tagId));
	}

	@PostMapping("tags")
	public Tag createTag(@RequestBody Tag tag) {
		return this.tagService.createTag(tag);
	}
	
	@DeleteMapping("tags/{id}")
	public Map<String,Boolean> deleteTag(@PathVariable(value="id") Long tagId) throws ResourceNotFoundException{
		Tag tagFromDB = tagService.getTagById(tagId);
		return tagService.deleteTag(tagFromDB);
	}

}
