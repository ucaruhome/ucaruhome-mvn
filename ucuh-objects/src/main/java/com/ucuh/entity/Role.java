package com.ucuh.entity;

/**
 * 角色表
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private String roleDes;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleName, String roleDes) {
		this.roleName = roleName;
		this.roleDes = roleDes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDes() {
		return this.roleDes;
	}

	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}


}