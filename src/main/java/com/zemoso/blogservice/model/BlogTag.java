package com.zemoso.blogservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blogtag")
public class BlogTag {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blogtag_id")
	private Long blogTagId;
	
	@Column(name="blog_id")
	private Long blogId;
	
	private long tagId;

	public BlogTag() {
		super();
	}

	public BlogTag(Long blogTagId, Long blogId, long tagId) {
		super();
		this.blogTagId = blogTagId;
		this.blogId = blogId;
		this.tagId = tagId;
	}

	public Long getBlogTagId() {
		return blogTagId;
	}

	public void setBlogTagId(Long blogTagId) {
		this.blogTagId = blogTagId;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	
	
	

}
