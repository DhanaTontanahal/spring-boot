package com.zemoso.blogservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="followusermap")
public class FollowUserMap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="followusermap_id")
	private Long followUserMapId;
	
	@Column(name = "followby_userid")
	private Long followByUserId;
	
	@Column(name = "followto_userid")
	private Long followToUserId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date followedTimeStamp;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date unFollowedTimeStamp;

	public FollowUserMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FollowUserMap(Long followUserMapId, Long followByUserId, Long followToUserId, Date followedTimeStamp,
			Date unFollowedTimeStamp) {
		super();
		this.followUserMapId = followUserMapId;
		this.followByUserId = followByUserId;
		this.followToUserId = followToUserId;
		this.followedTimeStamp = followedTimeStamp;
		this.unFollowedTimeStamp = unFollowedTimeStamp;
	}

	public Long getFollowUserMapId() {
		return followUserMapId;
	}

	public void setFollowUserMapId(Long followUserMapId) {
		this.followUserMapId = followUserMapId;
	}

	public Long getFollowByUserId() {
		return followByUserId;
	}

	public void setFollowByUserId(Long followByUserId) {
		this.followByUserId = followByUserId;
	}

	public Long getFollowToUserId() {
		return followToUserId;
	}

	public void setFollowToUserId(Long followToUserId) {
		this.followToUserId = followToUserId;
	}

	public Date getFollowedTimeStamp() {
		return followedTimeStamp;
	}

	public void setFollowedTimeStamp(Date followedTimeStamp) {
		this.followedTimeStamp = followedTimeStamp;
	}

	public Date getUnFollowedTimeStamp() {
		return unFollowedTimeStamp;
	}

	public void setUnFollowedTimeStamp(Date unFollowedTimeStamp) {
		this.unFollowedTimeStamp = unFollowedTimeStamp;
	}
	
	
	
}
