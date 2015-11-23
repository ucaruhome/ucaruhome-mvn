package com.ucuh.entity;

import java.util.Date;

/**
 * 供应商表
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String tel;
	private String phone;
	private String email;
	private Integer state;
	private String remark;
	private Date time;
	
	//2015-11-09 cck
	private String companyName;//公司名称
	private String position;//在公司的职位
	private String name;//真实姓名

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** full constructor */
	public Supplier(User user, String tel, String phone, String email,
			Integer state, String remark, Date time,String companyName,String position,String name) {
		this.user = user;
		this.tel = tel;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.remark = remark;
		this.time = time;
		this.companyName=companyName;
		this.position=position;
		this.name=name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}