package com.ucuh.entity;

/**
 * Activity entity. @author MyEclipse Persistence Tools
 */

public class Activity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer designerId;
	private Integer supplierId;
	private Integer state;
	private Integer distributorId;
	private Integer type;

	// Constructors

	/** default constructor */
	public Activity() {
	}

	/** full constructor */
	public Activity(Integer designerId, Integer supplierId, Integer state,
			Integer distributorId, Integer type) {
		this.designerId = designerId;
		this.supplierId = supplierId;
		this.state = state;
		this.distributorId = distributorId;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDesignerId() {
		return this.designerId;
	}

	public void setDesignerId(Integer designerId) {
		this.designerId = designerId;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDistributorId() {
		return this.distributorId;
	}

	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}