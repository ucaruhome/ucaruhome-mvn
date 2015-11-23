package com.ucuh.model;

import java.io.Serializable;
import java.util.Date;

public class UserDemo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idenify;//用户id
	//private Role role;
	private Integer roleId;//角色id
	private String roleName;//角色名称
	private String roleDes;//角色描述
	
	//private Group group;
	private Integer groupId;//组别id
	private String groupName;//组别名称
	private String groupDes;//组别描述
	
	
	private String userName;//用户名
	private String name;//真实姓名
	private String microblog;//微博账号
	private String wechat;//微信账号
	private String headPhoto;//头像文件（base64编码）
	private String nickName;//昵称
	private String sex;//性别
	private Integer age;//年龄（通过生日计算）
	private String area;//地址（区域）
	private String webSite;//个人网站
	private String personalProfile;//个人简介
	private Integer designer;//设计师认证标示：0，未认证；1，认证已经提交;2.认证审核未通过；3.认证审核已经通过;4:取消认证。
	private String companyName1;//公司名称
	private String position1;//在公司的职位
	private String realName1;//真实姓名
	private String telPhone1;//联系电话
	private String email1;//邮箱
	private String remark1;//服务范围
	
	private Integer distributor;//经销商认证（功能为开启）
	private String password;//密码
	private String remark;//备注（备用字段）
	private Integer supplier;//供应商认证标示：0，未认证；1，认证已经提交;2.认证审核未通过；3.认证审核已经通过4:取消认证。
	private String companyName2;//公司名称
	private String position2;//在公司的职位
	private String realName2;//真实姓名
	private String telPhone2;//联系电话
	private String email2;//邮箱
	private String remark2;//服务范围
	
	
	private String birthday;//生日
	private Integer headPhotoRZ;//头像审核标示：0，已上传待审核；1，审核通过；2,审核未通过
	
	private Date  addtime;//用户添加时间
	private Date  updatetime;//资料最近一次更新时间
	private String phone;//注册的手机号
	
	public UserDemo(){
		
	}

	public UserDemo(Integer idenify, Integer roleId, String roleName,
			String roleDes, Integer groupId, String groupName, String groupDes,
			String userName, String name, String microblog, String wechat,
			String headPhoto, String nickName, String sex, Integer age,
			String area, String webSite, String personalProfile,
			Integer designer, Integer distributor, String password,
			String remark, Integer supplier, String birthday,
			Integer headPhotoRZ, Date addtime, Date updatetime, String phone,String s_companyName,String s_position,String s_realName,String s_telPhone,String s_email,String s_remark
			,String d_companyName,String d_position,String d_realName,String d_telPhone,String d_email,String d_remark) {
		this.idenify = idenify;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDes = roleDes;
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDes = groupDes;
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
		this.supplier = supplier;
		this.birthday = birthday;
		this.headPhotoRZ = headPhotoRZ;
		this.addtime = addtime;
		this.updatetime = updatetime;
		this.phone = phone;
		this.companyName2=companyName2;
		this.position2=position2;
		this.realName2=realName2;
		this.telPhone2=telPhone2;
		this.email2=email2;
		this.remark2=remark2;
		this.companyName1=companyName1;
		this.position1=position1;
		this.realName1=realName1;
		this.telPhone1=telPhone1;
		this.email1=email1;
		this.remark1=remark1;
	}

	

	public Integer getIdenify() {
		return idenify;
	}

	public void setIdenify(Integer idenify) {
		this.idenify = idenify;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDes() {
		return roleDes;
	}

	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDes() {
		return groupDes;
	}

	public void setGroupDes(String groupDes) {
		this.groupDes = groupDes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMicroblog() {
		return microblog;
	}

	public void setMicroblog(String microblog) {
		this.microblog = microblog;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	public Integer getDesigner() {
		return designer;
	}

	public void setDesigner(Integer designer) {
		this.designer = designer;
	}

	public Integer getDistributor() {
		return distributor;
	}

	public void setDistributor(Integer distributor) {
		this.distributor = distributor;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
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

	public String getCompanyName1() {
		return companyName1;
	}

	public void setCompanyName1(String companyName1) {
		this.companyName1 = companyName1;
	}

	public String getPosition1() {
		return position1;
	}

	public void setPosition1(String position1) {
		this.position1 = position1;
	}

	public String getRealName1() {
		return realName1;
	}

	public void setRealName1(String realName1) {
		this.realName1 = realName1;
	}

	public String getTelPhone1() {
		return telPhone1;
	}

	public void setTelPhone1(String telPhone1) {
		this.telPhone1 = telPhone1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getCompanyName2() {
		return companyName2;
	}

	public void setCompanyName2(String companyName2) {
		this.companyName2 = companyName2;
	}

	public String getPosition2() {
		return position2;
	}

	public void setPosition2(String position2) {
		this.position2 = position2;
	}

	public String getRealName2() {
		return realName2;
	}

	public void setRealName2(String realName2) {
		this.realName2 = realName2;
	}

	public String getTelPhone2() {
		return telPhone2;
	}

	public void setTelPhone2(String telPhone2) {
		this.telPhone2 = telPhone2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	

	
	
}
