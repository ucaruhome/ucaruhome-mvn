package com.ucuh.entity;

import java.util.Date;

/**
 * 用户表
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Group group;
	private String userName;
	private String name;
	private String microblog;
	private String wechat;
	private String headPhoto;
	private String nickName;
	private String sex;
	private Integer age;
	private String area;
	private String webSite;
	private String personalProfile;
	private Integer designer;//设计师认证
	private Integer distributor;//经销商认证
	private String password;
	private String remark;
	private Integer supplier;//供应商认证
	
	
	private String birthday;
	private Integer headPhotoRZ;//头像审核
	
	private Date  addtime;
	private Date  updatetime;
	
	//2015-11-11 cck
	private String phone;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Role role, Group group, String userName, String name,
			String microblog, String wechat, String headPhoto, String nickName,
			String sex, Integer age, String area, String webSite,
			String personalProfile, Integer designer, Integer distributor,
			String password, String remark,Integer supplier,String birthday,Integer headPhotoRZ,Date addtime,Date updatetime,String phone) {
		this.role = role;
		this.group = group;
		this.userName = userName;
		this.name = name;
		this.microblog = microblog;
		this.wechat = wechat;
		this.headPhoto = headPhoto;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.area = area;
		this.webSite = webSite;
		this.personalProfile = personalProfile;
		this.designer = designer;
		this.distributor = distributor;
		this.password = password;
		this.remark = remark;
		this.supplier=supplier;
		this.birthday=birthday;
		this.headPhotoRZ=headPhotoRZ;
		this.addtime=addtime;
		this.updatetime=updatetime;
		this.phone=phone;
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

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMicroblog() {
		return this.microblog;
	}

	public void setMicroblog(String microblog) {
		this.microblog = microblog;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getHeadPhoto() {
		return this.headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPersonalProfile() {
		return this.personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	public Integer getDesigner() {
		return this.designer;
	}

	public void setDesigner(Integer designer) {
		this.designer = designer;
	}

	public Integer getDistributor() {
		return this.distributor;
	}

	public void setDistributor(Integer distributor) {
		this.distributor = distributor;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSupplier() {
		return supplier;
	}

	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getHeadPhotoRZ() {
		return headPhotoRZ;
	}

	public void setHeadPhotoRZ(Integer headPhotoRZ) {
		this.headPhotoRZ = headPhotoRZ;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}