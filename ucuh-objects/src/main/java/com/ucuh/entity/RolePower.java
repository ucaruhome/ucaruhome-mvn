package com.ucuh.entity;

/**
 *角色和权限关联表
 */

public class RolePower implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Power power;
	private String remark;

	// Constructors

	/** default constructor */
	public RolePower() {
	}

	/** full constructor */
	public RolePower(Role role, Power power, String remark) {
		this.role = role;
		this.power = power;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Power getPower() {
		return this.power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}