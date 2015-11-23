package com.ucuh.entity;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private String theme;
	private Integer type;
	private String content;
	private Date time;
	private Integer userId;
	
	//2015-10-30
	private Integer tanchuangYesOrNo;
	private String waplink;
	
	private String remark;
	private String fengmian;
	private String content1;
	
	//20151119  cck
	private String remark1;
	private String remark2;
	

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String theme, Integer type, String content, Date time,
			Integer userId,Integer tanchuangYesOrNo,String waplink,String remark,String fengmian,String content1,String remark1,String remark2) {
		this.theme = theme;
		this.type = type;
		this.content = content;
		this.time = time;
		this.userId = userId;
		this.tanchuangYesOrNo=tanchuangYesOrNo;
		this.waplink=waplink;
		this.remark=remark;
		this.fengmian=fengmian;
		this.content1=content1;
		this.remark1=remark1;
		this.remark2=remark2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTanchuangYesOrNo() {
		return tanchuangYesOrNo;
	}

	public void setTanchuangYesOrNo(Integer tanchuangYesOrNo) {
		this.tanchuangYesOrNo = tanchuangYesOrNo;
	}

	public String getWaplink() {
		return waplink;
	}

	public void setWaplink(String waplink) {
		this.waplink = waplink;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFengmian() {
		return fengmian;
	}

	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

}