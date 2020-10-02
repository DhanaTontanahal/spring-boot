package com.zemoso.blogservice.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Tag;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryTest {

	@Autowired
	private TagRepository tagRepository;
	
	@Test
	public void testFindAll() {
		List<Tag> tagList = this.tagRepository.findAll();
		assertEquals(1,tagList.size());
	}
	
	public Tag getTagById(Long tagId) throws ResourceNotFoundException {
		Tag tag = this.tagRepository.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag no found"));
		return tag;
	}
	
	@Test
	public void testFindTagById() throws ResourceNotFoundException {
	
		Tag tag = getTagById(1l);
		assertEquals("React", tag.getTagName());

	}
	
	
	public void createNewTag() {
		Tag newTag = new Tag(2l, "Java");
		this.tagRepository.save(newTag);
	}
	
	@Test
	public void testCreateTag() {
		createNewTag();
		List<Tag> tagList = this.tagRepository.findAll();
		assertEquals(2, tagList.size());
	}
	
	public Tag updateTag(Tag tag) {
		Tag stagedTag = tag;
		stagedTag.setTagName("JavaScriptES6");
		this.tagRepository.save(stagedTag);
		return stagedTag;
	}
	
	@Test
	public void testUpdateTag() throws ResourceNotFoundException {
		Tag tag = getTagById(1l);
		Tag updatedTag = updateTag(tag);
		assertEquals("JavaScriptES6",updatedTag.getTagName());
	}
	
	public void deleteTag(Tag tag) {
		this.tagRepository.delete(tag);
	}
	@Test
	public void testDeleteTag() throws ResourceNotFoundException {
		Tag tag = getTagById(1l);
		deleteTag(tag);
		List<Tag> tagList = this.tagRepository.findAll();
		assertEquals(0, tagList.size());
	}
	
	
}
