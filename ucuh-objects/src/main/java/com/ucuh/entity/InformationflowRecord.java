package com.ucuh.entity;

import java.util.Date;

/**
 * InformationflowRecord entity. @author MyEclipse Persistence Tools
 */

public class InformationflowRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Informationflow informationflow;
	private String content;
	private Date maketime;
	private String userName;

	// Constructors

	/** default constructor */
	public InformationflowRecord() {
	}

	/** full constructor */
	public InformationflowRecord(Informationflow informationflow,
			String content, Date maketime, String userName) {
		this.informationflow = informationflow;
		this.content = content;
		this.maketime = maketime;
		this.userName = userName;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMaketime() {
		return this.maketime;
	}

	public void setMaketime(Date maketime) {
		this.maketime = maketime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}