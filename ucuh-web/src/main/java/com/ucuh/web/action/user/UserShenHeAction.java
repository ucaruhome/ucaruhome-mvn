package com.ucuh.web.action.user;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.Headphoto;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.CommService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class UserShenHeAction  extends HchhAction{
	@Resource(name="commService")
	private CommService commService;
	@Resource UserDao userDao;
	@Resource HeadPhotoDao hpDao;
	//input
    private int userId;
    private int headPhotoState;
    //output
    private boolean ok=false;
    
    
	public String shenHe(){
		User user=userDao.findById(userId);
		user.setHeadPhotoRZ(headPhotoState);
		List<Headphoto> hps=hpDao.findByUserid(userId);
		if(headPhotoState==1){
			//根据时间排序第一个设置为1，其它都为0
			for(int i=0;i<hps.size();i++){
				Headphoto hp=hps.get(i);
				if(i==0){
					hp.setHeadPhotoState(1);
					user.setHeadPhoto(hp.getHeadPhotoPath());
				}
				hp.setHeadPhotoState(0);
				hpDao.saveOrUpdateHeadPhoto(hp);
			}
		}else{
			//根据时间排序第一个设置为2，其它都为0
			for(int i=0;i<hps.size();i++){
				Headphoto hp=hps.get(i);
				if(i==0){
					hp.setHeadPhotoState(2);
					String headpath=HchhUtil.getUrlHead(HchhUtil.loadProperty());
					user.setHeadPhoto(headpath+"/frame/image/head.jpg");
				}
				hp.setHeadPhotoState(0);
				hpDao.saveOrUpdateHeadPhoto(hp);
			}
		}
		userDao.savaOrUpdateUser(user);
		User user1=(User) session.get("user");
		if(headPhotoState==1){
		commService.saveUserRecord("审核通过", user1.getUserName(), user);
		}else{
		commService.saveUserRecord("审核不通过", user1.getUserName(), user);	
		}
		
		ok=true;
		return "success";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHeadPhotoState() {
		return headPhotoState;
	}
	public void setHeadPhotoState(int headPhotoState) {
		this.headPhotoState = headPhotoState;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	
}
