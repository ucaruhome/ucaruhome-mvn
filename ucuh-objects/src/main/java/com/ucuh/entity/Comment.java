package com.ucuh.entity;

import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private User userStart;
	private User userOver;
	private Informationflow informationflow;
	private String content;
	private byte[] photoContent;
	private Integer state;
	private Date time;
	private String remark;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(User userStart, User userOver,
			Informationflow informationflow, String content,
			byte[] photoContent, Integer state, Date time, String remark) {
		this.userStart = userStart;
		this.userOver = userOver;
		this.informationflow = informationflow;
		this.content = content;
		this.photoContent = photoContent;
		this.state = state;
		this.time = time;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public User getUserStart() {
		return userStart;
	}

	public void setUserStart(User userStart) {
		this.userStart = userStart;
	}

	public User getUserOver() {
		return userOver;
	}

	public void setUserOver(User userOver) {
		this.userOver = userOver;
	}

	public Informationflow getInformationflow() {
		return informationflow;
	}

	public void setInformationflow(Informationflow informationflow) {
		this.informationflow = informationflow;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getPhotoContent() {
		return this.photoContent;
	}

	public void setPhotoContent(byte[] photoContent) {
		this.photoContent = photoContent;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}