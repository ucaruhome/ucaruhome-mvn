package com.ucuh.entity;

/**
 * 活动详细表
 */

public class Wordbook implements java.io.Serializable {

	// Fields

	private Integer id;
	private String leixing;
	private String value;
	private String remark;
	
	//2015-11-03 cck
	private String name;
	private Integer activityId;

	// Constructors

	/** default constructor */
	public Wordbook() {
	}

	/** full constructor */
	public Wordbook(String leixing, String value, String remark,String name,Integer activityId) {
		this.leixing = leixing;
		this.value = value;
		this.remark = remark;
		this.name=name;
		this.activityId=activityId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeixing() {
		return this.leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

}