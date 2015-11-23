package com.ucuh.web.action.user;

import com.ucuh.dao.ActivityDao;
import com.ucuh.dao.DesignerDao;
import com.ucuh.dao.GroupDao;
import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.dao.RoleDao;
import com.ucuh.dao.SupplierDao;
import com.ucuh.dao.UserDao;
import com.ucuh.dao.WordbookDao;
import com.ucuh.entity.Activity;
import com.ucuh.entity.Designer;
import com.ucuh.entity.Group;
import com.ucuh.entity.Headphoto;
import com.ucuh.entity.Role;
import com.ucuh.entity.Supplier;
import com.ucuh.entity.User;
import com.ucuh.entity.Wordbook;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.CommService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
/**
 * 用户信息的增删改查
 * @author Administrator
 *
 */
@Controller
public class UserHandleAction extends HchhAction{
	@Resource(name="commService")
	private CommService commService;
	@Resource UserDao userDao;
	@Resource RoleDao roleDao;
	@Resource GroupDao groupDao;
	@Resource HeadPhotoDao headphotoDao;
	@Resource SupplierDao  supplierDao;
	@Resource DesignerDao  designerDao;
	@Resource ActivityDao  activityDao;
	@Resource WordbookDao  wbDao;
	private int userId;
	//userId,headPhotoId,userName,sex,name,webSite,birthday,nickName,area,roleId,groupId,
	//microblog,wechat,personalProfile
	private int headPhotoId;
	private String userName;
	private String sex;
	private String name;
	private String webSite;
	private String birthday;
	private String nickName;
	private String area;
	private int roleId;
	private int groupId;
	private String microblog;
	private String wechat;
	private String personalProfile;
	//输出
	private User user=new User();
	private Designer designer=new Designer();
	private Designer supplier=new Designer();
	int ok=0;
	
	//待审核图片路径
	private String  headPhotoPath;
	
	
	private List<Role> roles=new ArrayList<Role>();
	private List<Group> groups=new ArrayList<Group>();
	public String queryUser(){
		user=userDao.findById(userId);
		if("".equals(user.getHeadPhoto())||user.getHeadPhoto()==null){
			user.setHeadPhoto("../image/head.jpg");
		}
		//通过userId查询状态为0的headPhoto
		List<Headphoto> hps=headphotoDao.findByUseridAndHeadphotostate(userId, 0);
		if(hps.size()!=0){
			headPhotoPath=hps.get(0).getHeadPhotoPath();
		}
		try{
		if(user.getDesigner()==1||user.getDesigner()==2||user.getDesigner()==3||user.getDesigner()==4){
			//1.通过userId查询对应的设计者
			Designer d=designerDao.findByUserId(userId);
			//2.通过对应的设计者找到对应的活动
			Activity ac=activityDao.findByDesignerId(d.getId());
			//3.通过活动查询对应的子信息
			List<Wordbook> wbs=wbDao.findByActivityId(ac.getId(),"designer_housetype");
			designer.setCompanyName(d.getCompanyName());
			designer.setEmail(d.getEmail());
			designer.setName(d.getName());
			designer.setPhone(d.getPhone());
			designer.setPosition(d.getPosition());
			designer.setRemark(d.getRemark());
			designer.setState(d.getState());
			designer.setTel(d.getTel());
			designer.setTime(d.getTime());
			//designer.setType(ac.getType());
			designer.setUser(d.getUser());
			//designer.setWbs(wbs);
		}
		if(user.getSupplier()==1||user.getSupplier()==2||user.getSupplier()==3||user.getSupplier()==4){
			//1.通过userId查询对应的供应商
			Supplier d=supplierDao.findByUserId(userId);
			//2.通过对应的设计者找到对应的活动
			Activity ac=activityDao.findBySupplierId(d.getId());
			//3.通过活动查询对应的子信息
			List<Wordbook> wbs=wbDao.findByActivityId(ac.getId(),"supplier_housetype");
			supplier.setCompanyName(d.getCompanyName());
			supplier.setEmail(d.getEmail());
			supplier.setName(d.getName());
			supplier.setPhone(d.getPhone());
			supplier.setPosition(d.getPosition());
			supplier.setRemark(d.getRemark());
			supplier.setState(d.getState());
			supplier.setTel(d.getTel());
			supplier.setTime(d.getTime());
			//supplier.setType(ac.getType());
			supplier.setUser(d.getUser());
			//supplier.setWbs(wbs);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String queryUserDSH(){
		user=userDao.findById(userId);
		if("".equals(user.getHeadPhoto())||user.getHeadPhoto()==null){
			user.setHeadPhoto("../image/head.jpg");
		}
		//通过userId查询状态为0的headPhoto
		List<Headphoto> hps=headphotoDao.findByUserid(userId);
		if(hps.size()!=0){
			headPhotoPath=hps.get(0).getHeadPhotoPath();
		}
		return "success";
	}
	public String queryUserYSHWTG(){
		user=userDao.findById(userId);
		if("".equals(user.getHeadPhoto())||user.getHeadPhoto()==null){
			user.setHeadPhoto("../image/head.jpg");
		}
		//通过userId查询状态为0的headPhoto
		List<Headphoto> hps=headphotoDao.findByUserid(userId);
		if(hps.size()!=0){
			headPhotoPath=hps.get(0).getHeadPhotoPath();
		}
		return "success";
	}
	public String updateUser(){
		roles=roleDao.findRoles();
		groups=groupDao.findGroups();
		user=userDao.findById(userId);
		if("".equals(user.getHeadPhoto())||user.getHeadPhoto()==null){
			user.setHeadPhoto("../image/head.jpg");
		}
		return "success";
	}
	public String updateUserCommit(){
		   user=userDao.findById(userId);
		   user.setArea(area);
		   user.setBirthday(birthday);
		   Group group=groupDao.findByID(groupId);
		   user.setGroup(group);
		   Role role=roleDao.findByID(roleId);
		   user.setRole(role);
		   user.setMicroblog(microblog);
		   user.setName(name);
		   user.setNickName(nickName);
		   user.setPersonalProfile(personalProfile);
		   user.setSex(sex);
		   user.setWebSite(webSite);
		   user.setWechat(wechat);
		   user.setUserName(userName);
		   //查询待审核的上传的头像
		   if(headPhotoId!=0){
			   Headphoto hp=headphotoDao.findByID(headPhotoId);
			   hp.setUserId(user.getId());
			   headphotoDao.saveOrUpdateHeadPhoto(hp);
		   }
		   user.setHeadPhotoRZ(0);
		   user.setUpdatetime(new Date());
		   userDao.savaOrUpdateUser(user);
		   User user1=(User) session.get("user");
		   commService.saveUserRecord("更新用户信息并提交重审", user1.getUserName(), user);
		ok=1;
		return "success";
	}
	public String delUser(){
		user=userDao.findById(userId);
		//将该用户下的所有信息删除
		
		userDao.delUser(user);
		ok=1;
		return "success";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public int getHeadPhotoId() {
		return headPhotoId;
	}

	public void setHeadPhotoId(int headPhotoId) {
		this.headPhotoId = headPhotoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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

	public String getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	public String getHeadPhotoPath() {
		return headPhotoPath;
	}

	public void setHeadPhotoPath(String headPhotoPath) {
		this.headPhotoPath = headPhotoPath;
	}
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	public Designer getSupplier() {
		return supplier;
	}
	public void setSupplier(Designer supplier) {
		this.supplier = supplier;
	}
	
	
}
