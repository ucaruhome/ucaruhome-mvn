package com.ucuh.model;
/**
 * 数据库读取数据时的数据库缓存类---设计师
 */


import com.ucuh.entity.User;
import com.ucuh.entity.Wordbook;

import java.util.Date;
import java.util.List;

public class DesignerDemo {
	private User user;
	private String tel;
	private String phone;
	private String email;
	private Integer state;
	private String remark;
	private Date time;
	private String companyName;//公司名称
	private String position;//在公司的职位
	private String name;//真实姓名
	private Integer type;//活动的使用范围
	private List<Wordbook> wbs;
	
	public DesignerDemo(){
		
	}

	public DesignerDemo(User user, String tel, String phone, String email,
			Integer state, String remark, Date time, String companyName,
			String position, String name, Integer type, List<Wordbook> wbs) {
		super();
		this.user = user;
		this.tel = tel;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.remark = remark;
		this.time = time;
		this.companyName = companyName;
		this.position = position;
		this.name = name;
		this.type = type;
		this.wbs = wbs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Wordbook> getWbs() {
		return wbs;
	}

	public void setWbs(List<Wordbook> wbs) {
		this.wbs = wbs;
	}
	
}
