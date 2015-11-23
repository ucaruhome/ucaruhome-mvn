package com.ucuh.entity;

import java.util.Date;

/**
 * CodeId entity. @author MyEclipse Persistence Tools
 */

public class CodeId implements java.io.Serializable {

	// Fields

	private String userKey;
	private String userCode;
	private Date sendOverTime;

	// Constructors

	/** default constructor */
	public CodeId() {
	}

	/** full constructor */
	public CodeId(String userKey, String userCode, Date sendOverTime) {
		this.userKey = userKey;
		this.userCode = userCode;
		this.sendOverTime = sendOverTime;
	}

	// Property accessors

	public String getUserKey() {
		return this.userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Date getSendOverTime() {
		return this.sendOverTime;
	}

	public void setSendOverTime(Date sendOverTime) {
		this.sendOverTime = sendOverTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CodeId))
			return false;
		CodeId castOther = (CodeId) other;

		return ((this.getUserKey() == castOther.getUserKey()) || (this
				.getUserKey() != null
				&& castOther.getUserKey() != null && this.getUserKey().equals(
				castOther.getUserKey())))
				&& ((this.getUserCode() == castOther.getUserCode()) || (this
						.getUserCode() != null
						&& castOther.getUserCode() != null && this
						.getUserCode().equals(castOther.getUserCode())))
				&& ((this.getSendOverTime() == castOther.getSendOverTime()) || (this
						.getSendOverTime() != null
						&& castOther.getSendOverTime() != null && this
						.getSendOverTime().equals(castOther.getSendOverTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserKey() == null ? 0 : this.getUserKey().hashCode());
		result = 37 * result
				+ (getUserCode() == null ? 0 : this.getUserCode().hashCode());
		result = 37
				* result
				+ (getSendOverTime() == null ? 0 : this.getSendOverTime()
						.hashCode());
		return result;
	}

}