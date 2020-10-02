package com.zemoso.blogservice.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.blogservice.exception.ResourceNotFoundException;
import com.zemoso.blogservice.model.Blog;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BlogReposiTest {
	
	@Autowired
	private BlogReposit blogRep;
	
	@Test
	public void testFindAll() {
		List<Blog> blogList = this.blogRep.findAll();
		assertEquals(2,blogList.size());
	}
	
	public Blog getBlogById(Long blogId) throws ResourceNotFoundException {
		Blog blog = this.blogRep.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
		return blog;
	}
	
	@Test
	public void testFindBlogById() throws ResourceNotFoundException {
	
		Blog blog = getBlogById(2l);
		assertEquals("dhanatontanahal", blog.getPostedBy());

	}
	
	public void createNewBlog() {
		Blog newBlog = new Blog(3l, "blogtitle3", "blogcontent3",  new Date(),  "tds",  "postImgUrl",
				 "readTime", 122,  0, null);
		this.blogRep.save(newBlog);
	}
	
	@Test
	public void testCreateBlog() {
		createNewBlog();
		List<Blog> blogList = this.blogRep.findAll();
		assertEquals(3, blogList.size());
	}
	public Blog updateBlog(Blog blog) {
		Blog stagedBlog = blog;
		stagedBlog.setClapsCount(10);
		this.blogRep.save(stagedBlog);
		return stagedBlog;
	}
	
	@Test
	public void testUpdateBlog() throws ResourceNotFoundException {
		Blog blog = getBlogById(2l);
		Blog updatedBlog = updateBlog(blog);
		assertEquals(10,updatedBlog.getClapsCount());
	}
	
	public void deleteBlog(Blog blog) {
		this.blogRep.delete(blog);
	}
	@Test
	public void testDeleteBlog() throws ResourceNotFoundException {
		Blog blog = getBlogById(2l);
		deleteBlog(blog);
		List<Blog> blogList = this.blogRep.findAll();
		assertEquals(1, blogList.size());
	}
}
