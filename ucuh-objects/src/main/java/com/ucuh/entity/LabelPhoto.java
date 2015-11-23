package com.ucuh.entity;

import java.util.Date;

/**
 * 标签和图片的关联表
 */

public class LabelPhoto implements java.io.Serializable {

	// Fields

	private Integer id;
	private Label hchhLabel;
	private Photo hchhPhoto;
	private Date time;
	private String remark;

	// Constructors

	/** default constructor */
	public LabelPhoto() {
	}

	/** full constructor */
	public LabelPhoto(Label hchhLabel, Photo hchhPhoto, Date time,
			String remark) {
		this.hchhLabel = hchhLabel;
		this.hchhPhoto = hchhPhoto;
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

	public Label getHchhLabel() {
		return this.hchhLabel;
	}

	public void setHchhLabel(Label hchhLabel) {
		this.hchhLabel = hchhLabel;
	}

	public Photo getHchhPhoto() {
		return this.hchhPhoto;
	}

	public void setHchhPhoto(Photo hchhPhoto) {
		this.hchhPhoto = hchhPhoto;
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