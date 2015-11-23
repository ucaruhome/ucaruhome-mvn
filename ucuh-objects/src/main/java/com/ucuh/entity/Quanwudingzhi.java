package com.ucuh.entity;

import java.util.Date;

/**
 * 全屋定制表
 */

public class Quanwudingzhi implements java.io.Serializable {

	// Fields

	private Integer id;
	private Cost cost;
	private User user;
	private String hourseAdress;
	private String telAndPhone;
	private Integer designerId;
	private Date time;

	// Constructors

	/** default constructor */
	public Quanwudingzhi() {
	}

	/** full constructor */
	public Quanwudingzhi(Cost cost, User user, String hourseAdress,
			String telAndPhone, Integer designerId, Date time) {
		this.cost = cost;
		this.user = user;
		this.hourseAdress = hourseAdress;
		this.telAndPhone = telAndPhone;
		this.designerId = designerId;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cost getCost() {
		return this.cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHourseAdress() {
		return this.hourseAdress;
	}

	public void setHourseAdress(String hourseAdress) {
		this.hourseAdress = hourseAdress;
	}

	public String getTelAndPhone() {
		return this.telAndPhone;
	}

	public void setTelAndPhone(String telAndPhone) {
		this.telAndPhone = telAndPhone;
	}

	public Integer getDesignerId() {
		return this.designerId;
	}

	public void setDesignerId(Integer designerId) {
		this.designerId = designerId;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}