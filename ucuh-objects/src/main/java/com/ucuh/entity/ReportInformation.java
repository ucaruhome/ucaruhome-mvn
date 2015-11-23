package com.ucuh.entity;

import java.util.Date;

/**
 * 举报信息表
 */

public class ReportInformation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Informationflow informationflow;
	private User user;
	private String userStartNick;
	private String userOverNick;
	private Date time;
	private Integer state;
	private String remark;

	// Constructors

	/** default constructor */
	public ReportInformation() {
	}

	/** full constructor */
	public ReportInformation(Informationflow informationflow, User user,
			String userStartNick, String userOverNick, Date time,
			Integer state, String remark) {
		this.informationflow = informationflow;
		this.user = user;
		this.userStartNick = userStartNick;
		this.userOverNick = userOverNick;
		this.time = time;
		this.state = state;
		this.remark = remark;
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

	public String getUserStartNick() {
		return this.userStartNick;
	}

	public void setUserStartNick(String userStartNick) {
		this.userStartNick = userStartNick;
	}

	public String getUserOverNick() {
		return this.userOverNick;
	}

	public void setUserOverNick(String userOverNick) {
		this.userOverNick = userOverNick;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
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

}