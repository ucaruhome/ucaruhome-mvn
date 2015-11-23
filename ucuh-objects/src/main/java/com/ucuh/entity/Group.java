package com.ucuh.entity;

import java.util.Set;

/**
 * 分组表
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer id;
	private String groupName;
	private String groupDes;

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	public Group(String groupName, String groupDes, Set hchhUsers) {
		this.groupName = groupName;
		this.groupDes = groupDes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDes() {
		return this.groupDes;
	}

	public void setGroupDes(String groupDes) {
		this.groupDes = groupDes;
	}


}