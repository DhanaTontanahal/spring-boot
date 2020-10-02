package com.zemoso.blogservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Tag;
import com.zemoso.blogservice.repository.TagRepository;
@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public List<Tag> getAllTags() {
		return this.tagRepository.findAll();
	}

	public Tag getTagById(Long tagId) throws ResourceNotFoundException {
		return this.tagRepository.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
	}
	public Tag createTag(Tag tag) {
		return this.tagRepository.save(tag);
	}
	
	public Map<String,Boolean> deleteTag(Tag tag) throws ResourceNotFoundException{
		
		this.tagRepository.delete(tag);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	
}
