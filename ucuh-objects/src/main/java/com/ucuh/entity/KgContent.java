package com.ucuh.entity;

import java.util.Date;

/**
 * KgContent entity. @author MyEclipse Persistence Tools
 */

public class KgContent implements java.io.Serializable {

	// Fields

	private Integer id;
	private Photo photo;
	private Label label;
	private Integer kgType;
	private String content;
	private Date time;

	// Constructors

	/** default constructor */
	public KgContent() {
	}

	/** minimal constructor */
	public KgContent(Integer kgType) {
		this.kgType = kgType;
	}

	/** full constructor */
	public KgContent(Photo photo, Integer kgType, String content, Date time,Label label) {
		this.photo = photo;
		this.kgType = kgType;
		this.content = content;
		this.time = time;
		this.label=label;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Integer getKgType() {
		return this.kgType;
	}

	public void setKgType(Integer kgType) {
		this.kgType = kgType;
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

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}