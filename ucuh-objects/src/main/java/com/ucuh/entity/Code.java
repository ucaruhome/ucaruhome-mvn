package com.ucuh.entity;

/**
 * Code entity. @author MyEclipse Persistence Tools
 */

public class Code implements java.io.Serializable {

	// Fields

	private CodeId id;

	// Constructors

	/** default constructor */
	public Code() {
	}

	/** full constructor */
	public Code(CodeId id) {
		this.id = id;
	}

	// Property accessors

	public CodeId getId() {
		return this.id;
	}

	public void setId(CodeId id) {
		this.id = id;
	}

}