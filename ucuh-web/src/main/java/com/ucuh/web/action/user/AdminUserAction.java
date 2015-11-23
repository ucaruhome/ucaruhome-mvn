package com.ucuh.web.action.user;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.GroupDao;
import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.dao.RoleDao;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.Group;
import com.ucuh.entity.Headphoto;
import com.ucuh.entity.Role;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.CommService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class AdminUserAction  extends HchhAction{
	@Resource(name="commService")
	private CommService commService;
	@Resource UserDao userDao;
	@Resource RoleDao roleDao;
	@Resource GroupDao groupDao;
	@Resource HeadPhotoDao headphotoDao;
	//添加一个管理员信息
	private int headPhotoId=0;
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
    private String userId="";
    //读取列表歇息=================================================
	//分页
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	//输出
	private List<User> list=new ArrayList<User>();
	//============================================================
	
	//读取角色和组别信息===========================================
	private List<Role> roles=new ArrayList<Role>();
	private List<Group> groups=new ArrayList<Group>();
	//增加管理员用户的返回
	private int ok=0;
	
	
	public String findRolesAndGroups(){
		roles=roleDao.findRoles();
		groups=groupDao.findGroups();
		return "success";
	}
	
   
   public String addAdminUser(){
	   //根据用户名判断当前用户是否已经存在
	   List<User> us=userDao.findByUserName(userName);
	   if(us.size()>0){
		  ok=2; 
	   }else{
		//ok=1;
	   //保存一个管理员用户信息
	   User user=new User();
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
	   user.setPassword("123456");//设置初始密码
	   userDao.savaOrUpdateUser(user);
	   userId=user.getId().toString();
	   //查询待审核的上传的头像
	   if(headPhotoId!=0){
		   Headphoto hp=headphotoDao.findByID(headPhotoId);
		   hp.setUserId(user.getId());
		   headphotoDao.saveOrUpdateHeadPhoto(hp);
		   user.setHeadPhotoRZ(0);
		   user.setAddtime(new Date());
		   userDao.savaOrUpdateUser(user);
		   //添加一条新增记录
		   User user1=(User) session.get("user");
		   commService.saveUserRecord("新增", user1.getUserName(), user);
	   }
	   
	   ok=1;
	   }
		return "success";
	}
   
   public String findAdminUsers(){
		Role role=roleDao.findRole("管理员");
		//通过roleId查询users
		count=userDao.findUsersCount(role.getId());
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=userDao.findUsers(role.getId(),count,nowPage,maxPage,maxPageCount);
		
		return "success";
	}
   public String findPutongUsers(){
		Role role=roleDao.findRole("普通用户");
		//通过roleId查询users
		count=userDao.findUsersCount(role.getId());
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=userDao.findUsers(role.getId(),count,nowPage,maxPage,maxPageCount);
		
		return "success";
	}
   
   public String findUsersDRZ(){
		//通过headPhotoRZ查询users
		count=userDao.findUsersAllCount(0);
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=userDao.findUsersAll(0, count, nowPage, maxPage, maxPageCount);
		
		return "success";
	}

   public String findUsersYSHTG(){
		//通过headPhotoRZ查询users
		count=userDao.findUsersAllCount(1);
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=userDao.findUsersAll(1, count, nowPage, maxPage, maxPageCount);
		
		return "success";
	}
   
   public String findUsersYSHWTG(){
		//通过headPhotoRZ查询users
		count=userDao.findUsersAllCount(2);
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=userDao.findUsersAll(2, count, nowPage, maxPage, maxPageCount);
		
		return "success";
	}
   
   
public int getNowPage() {
	return nowPage;
}

public void setNowPage(int nowPage) {
	this.nowPage = nowPage;
}

public int getMaxPage() {
	return maxPage;
}

public void setMaxPage(int maxPage) {
	this.maxPage = maxPage;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public List<User> getList() {
	return list;
}

public void setList(List<User> list) {
	this.list = list;
}

public int getMaxPageCount() {
	return maxPageCount;
}

public void setMaxPageCount(int maxPageCount) {
	this.maxPageCount = maxPageCount;
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


public int getOk() {
	return ok;
}


public void setOk(int ok) {
	this.ok = ok;
}


public String getUserId() {
	return userId;
}


public void setUserId(String userId) {
	this.userId = userId;
}
	
}
