package com.ucuh.entity;

import java.util.Date;
import java.util.List;

/**
 * 信息流表
 */

public class Informationflow implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String theme;
	private String des;
	private Integer state;
	private String remark;
	private Date time;
	/*private Set hchhUserInformationflows = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set hchhPhotos = new HashSet(0);
	private Set hchhReportinformations = new HashSet(0);*/

	// Constructors
    //2015.10.15
	private Integer pinglunNum;
	private Integer shoucangNum;
	private Integer dianzanNum;
	
	//2015.10.19
	private Integer photoNum;
	
	private List<String> suoFangTus;//显示图片时使用
	
	/** default constructor */
	public Informationflow() {
	}

	/** full constructor */
	public Informationflow(User user, String theme, String des, Integer state,
			String remark, Date time,Integer pinglunNum,Integer shoucangNum,Integer dianzanNum) {
		this.user = user;
		this.theme = theme;
		this.des = des;
		this.state = state;
		this.remark = remark;
		this.time = time;
		this.pinglunNum=pinglunNum;
		this.shoucangNum=shoucangNum;
		this.dianzanNum=dianzanNum;
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

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
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

	public Integer getPinglunNum() {
		return pinglunNum;
	}

	public void setPinglunNum(Integer pinglunNum) {
		this.pinglunNum = pinglunNum;
	}

	public Integer getShoucangNum() {
		return shoucangNum;
	}

	public void setShoucangNum(Integer shoucangNum) {
		this.shoucangNum = shoucangNum;
	}

	public Integer getDianzanNum() {
		return dianzanNum;
	}

	public void setDianzanNum(Integer dianzanNum) {
		this.dianzanNum = dianzanNum;
	}

	public List<String> getSuoFangTus() {
		return suoFangTus;
	}

	public void setSuoFangTus(List<String> suoFangTus) {
		this.suoFangTus = suoFangTus;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(Integer photoNum) {
		this.photoNum = photoNum;
	}

	

}