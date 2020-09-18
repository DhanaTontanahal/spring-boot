package com.zemoso.blogservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private long commentId;
	
	@Column(name="comment_value")
	private String commentValue;
	
	@Column(name="blog_id")
	private long blogId;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="created_date")
	private String createdDate;

	public Comment() {
		super();
		}

	public Comment(long commentId, String commentValue, long blogId, long userId, String createdDate) {
		super();
		this.commentId = commentId;
		this.commentValue = commentValue;
		this.blogId = blogId;
		this.userId = userId;
		this.createdDate = createdDate;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getCommentValue() {
		return commentValue;
	}

	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	
}
