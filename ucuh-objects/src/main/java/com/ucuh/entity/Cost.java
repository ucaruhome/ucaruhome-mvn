package com.ucuh.entity;

/**
 * 设计费用表
 */

public class Cost implements java.io.Serializable {

	// Fields

	private Integer id;
	private Designer hchhDesigner;
	private double costMoney;
	private String unit;
	private double count;
	private String remark;
	private String huxing;
	//private Set hchhQuanwudingzhis = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cost() {
	}

	/** full constructor */
	public Cost(Designer hchhDesigner, double costMoney, String unit,
			double count, String remark, String huxing) {
		this.hchhDesigner = hchhDesigner;
		this.costMoney = costMoney;
		this.unit = unit;
		this.count = count;
		this.remark = remark;
		this.huxing = huxing;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Designer getHchhDesigner() {
		return this.hchhDesigner;
	}

	public void setHchhDesigner(Designer hchhDesigner) {
		this.hchhDesigner = hchhDesigner;
	}

	public double getCostMoney() {
		return this.costMoney;
	}

	public void setCostMoney(double costMoney) {
		this.costMoney = costMoney;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getCount() {
		return this.count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHuxing() {
		return this.huxing;
	}

	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}

	/*public Set getHchhQuanwudingzhis() {
		return this.hchhQuanwudingzhis;
	}

	public void setHchhQuanwudingzhis(Set hchhQuanwudingzhis) {
		this.hchhQuanwudingzhis = hchhQuanwudingzhis;
	}*/

}