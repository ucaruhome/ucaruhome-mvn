package com.ucuh.entity;

import java.util.Date;

/**
 * 上传的图片表
 */

public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Informationflow informationflow;
	private User user;
	private String photoPath;
	private String theme;
	private String des;
	private String remark;
	private Date time;
	/*private Set labelPhotos = new HashSet(0);*/

	//20151013 cck
	private String type;
	private String typeDes;
	
	//2015-11-19 cck
	private String remark1;
	private String remark2;
	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(Informationflow informationflow, User user, String photoPath,
			String theme, String des, String remark, Date time,String remark1,String remark2) {
		this.informationflow = informationflow;
		this.user = user;
		this.photoPath = photoPath;
		this.theme = theme;
		this.des = des;
		this.remark = remark;
		this.time = time;
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

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeDes() {
		return typeDes;
	}

	public void setTypeDes(String typeDes) {
		this.typeDes = typeDes;
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

	/*public Set getLabelPhotos() {
		return this.labelPhotos;
	}

	public void setLabelPhotos(Set labelPhotos) {
		this.labelPhotos = labelPhotos;
	}*/

}