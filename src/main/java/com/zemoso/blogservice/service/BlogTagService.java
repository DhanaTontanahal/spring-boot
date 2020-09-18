package com.zemoso.blogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blogservice.model.BlogTag;
import com.zemoso.blogservice.repository.BlogTagReposit;
@Service
public class BlogTagService {
	
	@Autowired
	private BlogTagReposit blogTagReposit;
	
	public List<BlogTag> getAllBlogTags() {
		return this.blogTagReposit.findAll();
	}

	public BlogTag createBlogTag(BlogTag blogTag) {
		return this.blogTagReposit.save(blogTag);
	}
	
	public List<BlogTag> getBlogTagsByBlogId(Long blogId) {
		return this.blogTagReposit.getBlogTagsByBlogId(blogId);
	}
	
	public List<String> getTagNameListForBlogId(Long blogId) {
		return this.blogTagReposit.getTagNameListForBlogId(blogId);
	}
	
	
}
