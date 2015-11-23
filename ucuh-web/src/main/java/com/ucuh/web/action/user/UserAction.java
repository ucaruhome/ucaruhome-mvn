package com.ucuh.web.action.user;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class UserAction  extends HchhAction{
	@Resource UserDao userDao;
    public String userName;
    public String passWord;
    public String microblog;
    public String wechat;
    
    public String error="";
	public String LoginTo(){
		if(userName==null||"".equals(userName)){
			error="用户名不能为空！";
			return "error";
		}else{
			if(passWord==null||"".equals(passWord)){
				error="密码不能为空！";
				return "error";
			}else{
				String passWord1=HchhUtil.strToMD5(passWord);
				//通过userName和passWord查询用户信息
				//通过userName和passWord1查询用户信息
				User user=userDao.findUser(userName, passWord, passWord1);
				
				//判断当前用户是否是管理员
				if(user==null){
					error="用户名或者密码不对！";
					return "error";
				}if("普通用户".equals(user.getRole().getRoleName())){
					error="该用户不是管理员，没有想过权限！";
					return "error";
				}else{
					session.put("user", user);
					return "success";
				}
			}
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	
	
	
}
