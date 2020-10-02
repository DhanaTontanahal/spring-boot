package com.zemoso.blogservice.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.BlogTag;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BlogTagRepositoryTest {

	@Autowired
	private BlogTagReposit blogTagRepository;
	
	@Test
	public void testFindAll() {
		List<BlogTag> blogTagList = this.blogTagRepository.findAll();
		assertEquals(1,blogTagList.size());
	}
	
	
	public BlogTag getBlogTagById(Long blogTagId) throws ResourceNotFoundException {
		BlogTag blogTag = this.blogTagRepository.findById(blogTagId).orElseThrow(() -> new ResourceNotFoundException("BlogTag no found"));
		return blogTag;
	}
	
	@Test
	public void testFindBlogTagById() throws ResourceNotFoundException {
	
		BlogTag blogTag = getBlogTagById(1l);
		assertEquals(1, blogTag.getTagId());

	}
	
}
