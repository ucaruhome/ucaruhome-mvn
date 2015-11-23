package com.ucuh.entity;

import java.util.Date;

/**
 * 用户信息流收藏夹
 */

public class UserInformationflow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Informationflow informationflow;
	private User user;
	private String remark;
	private Date time;

	// Constructors

	/** default constructor */
	public UserInformationflow() {
	}

	/** full constructor */
	public UserInformationflow(Informationflow informationflow, User user,
			String remark, Date time) {
		this.informationflow = informationflow;
		this.user = user;
		this.remark = remark;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Informationflow getInformationflow() {
		return this.informationflow;
	}

	public void setInformationflow(Informationflow informationflow) {
		this.informationflow = informationflow;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}