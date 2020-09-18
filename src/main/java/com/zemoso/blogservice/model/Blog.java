package com.zemoso.blogservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="blog")
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blog_id")
	private Long blogId;
	
	@Column(name="title" , length=32)
	private String title;

	@Column(name="content")
	@Lob //for the postgresql DB type text for unlimited text 
	private String content;
	
	@Column(name="blogged_date", length=8)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date postedDate;
	
	@Column(name="blogged_by", length=255)
	private String postedBy;
		
	@Column(name="blog_img")
	private String postImgUrl;
	
	@Column(name="read_time", length=8)
	private String readTime;
	
	@Column(name="user_id", length=8)
	private long userId;
	
	@Column(name="claps_count", length=8)
	private int clapsCount;
	
	@Column(name="updated_date", length=8)
	private Date updatedDate;
	
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getPostImgUrl() {
		return postImgUrl;
	}

	public void setPostImgUrl(String postImgUrl) {
		this.postImgUrl = postImgUrl;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public long getuId() {
		return userId;
	}

	public void setuId(long uId) {
		this.userId = uId;
	}

	public int getClapsCount() {
		return clapsCount;
	}

	public void setClapsCount(int clapsCount) {
		this.clapsCount = clapsCount;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Blog(Long blogId, String title, String content, Date postedDate, String postedBy, String postImgUrl,
			String readTime, long userId, int clapsCount, Date updatedDate) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.content = content;
		this.postedDate = postedDate;
		this.postedBy = postedBy;
		this.postImgUrl = postImgUrl;
		this.readTime = readTime;
		this.userId = userId;
		this.clapsCount = clapsCount;
		this.updatedDate = updatedDate;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

}
