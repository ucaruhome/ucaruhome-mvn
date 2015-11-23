package com.ucuh.entity;

import java.util.Date;

/**
 * UserRecord entity. @author MyEclipse Persistence Tools
 */

public class UserRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userNameCz;
	private Integer userId;
	private String contentCz;
	private Date time;

	// Constructors

	/** default constructor */
	public UserRecord() {
	}

	/** full constructor */
	public UserRecord(String userNameCz, Integer userId, String contentCz,
			Date time) {
		this.userNameCz = userNameCz;
		this.userId = userId;
		this.contentCz = contentCz;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserNameCz() {
		return this.userNameCz;
	}

	public void setUserNameCz(String userNameCz) {
		this.userNameCz = userNameCz;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContentCz() {
		return this.contentCz;
	}

	public void setContentCz(String contentCz) {
		this.contentCz = contentCz;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}