package com.zemoso.blogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zemoso.blogservice.model.BlogTag;

@Repository
public interface BlogTagReposit extends JpaRepository<BlogTag, Long> {

	@Query("SELECT c FROM BlogTag c WHERE c.blogId = ?1")
	List<BlogTag> getBlogTagsByBlogId(long blogId);
	
	@Query(nativeQuery = true, value="select tag_name from blogtag bt , tag t where bt.tag_id=t.tag_id and bt.blog_id=5")
	List<String> getTagNameListForBlogId(long blogId);
	
	
}

