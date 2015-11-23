package com.ucuh.entity;

import java.util.Set;

/**
 * 权限表
 */

public class Power implements java.io.Serializable {

	// Fields

	private Integer id;
	private String powerName;
	private String powerDes;

	// Constructors

	/** default constructor */
	public Power() {
	}

	/** full constructor */
	public Power(String powerName, String powerDes, Set hchhRolePowers) {
		this.powerName = powerName;
		this.powerDes = powerDes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPowerDes() {
		return this.powerDes;
	}

	public void setPowerDes(String powerDes) {
		this.powerDes = powerDes;
	}


}