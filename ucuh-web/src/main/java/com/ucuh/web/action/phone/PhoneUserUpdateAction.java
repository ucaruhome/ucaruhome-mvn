package com.ucuh.web.action.phone;

import com.ucuh.dao.CodeDao;
import com.ucuh.dao.DesignerDao;
import com.ucuh.dao.GroupDao;
import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.dao.RoleDao;
import com.ucuh.dao.SupplierDao;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.Headphoto;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.FileUtilService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller
public class PhoneUserUpdateAction  extends HchhAction {
	@Resource FileUtilService fileUtilService;
	@Resource UserDao userDao;
	@Resource CodeDao codeDao;
	@Resource RoleDao roleDao;
	@Resource HeadPhotoDao hpDao;
	@Resource GroupDao groupDao;
	
	@Resource DesignerDao designerDao;
	@Resource SupplierDao supplierDao;
	//================================更新用户信息===================================================================================
	private String phone;//手机号码
	private String headPhoto;//头像
	private String photoType;
	
	private String nickName;//昵称
	private String sex;//性别
	private String age;//年龄
	private String address;//区域（地址）
	private String personalProfile;
	
	//ok
	private int ok=0;
    
	
	public void UpdateUser(){
		User user=new User();
		String str="";
		//通过手机号查询该用户
		List<User> users=userDao.findByPhone(phone);
		if(users.size()!=0){
			user=users.get(0);
			if(headPhoto!=null&&!"".equals(headPhoto)){
				/*//String fwPath=user.getHeadPhoto();
				long timeL=System.currentTimeMillis();
		        String path = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName());
		        //得到服务器的访问文件的路径
		        //pageContext.getServletContext().getRealPath("/");
		        //System.out.println(timeL);
		        File f1 = new File(path);
				//不存在则创建它
				if(!f1.exists()){
					f1.mkdirs();
				}
				String path1 = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/"+timeL);
				File f11 = new File(path1);
				//不存在则创建它
				if(!f11.exists()){
					f11.mkdirs();
				}
				String aPath=path1 + "/headphoto"+photoType;
	            //对保存的路径进行修改
	            String allPath=FileUtil.changePath(aPath);
	            //将当前的文件路径变成服务器访问路径=====================================
	            //HchhUtil hu=new HchhUtil();
	            Properties prop=HchhUtil.loadProperty();
	            String urlHead=HchhUtil.getUrlHead(prop);
	            String projectName=HchhUtil.getProjectName(prop);
	            //通过项目名对allPath截取
	            String[] strs=allPath.split("/"+projectName);
	            String allPath1=urlHead+""+strs[1];
	            //=======================================================================
	            boolean okey=HchhCommonUtil.GenerateImage(headPhoto, aPath);
	            if(okey){
	            user.setHeadPhoto(allPath1);
	            user.setHeadPhotoRZ(0);
	            Headphoto hp=new Headphoto();
	            hp.setHeadPhotoPath(allPath1);
	            hp.setHeadPhotoState(0);
	            hp.setTime(new Date());
	            hp.setUserId(user.getId());
	            hpDao.saveOrUpdateHeadPhoto(hp);
	            }*/
				String[] strs=fileUtilService.uploadHeadPhoto(user, headPhoto, photoType);
				if(strs!=null){
		            user.setHeadPhoto(strs[0]);
		            user.setHeadPhotoRZ(0);
		            Headphoto hp=new Headphoto();
		            hp.setHeadPhotoPath(strs[0]);
		            hp.setHeadPhotoState(0);
		            hp.setTime(new Date());
		            hp.setUserId(user.getId());
		            hp.setRemark1(strs[1]);
		            hpDao.saveOrUpdateHeadPhoto(hp);
		            }
	            userDao.savaOrUpdateUser(user);
	            str=user.getHeadPhoto();
			}
            if(nickName!=null&&!"".equals(nickName)){
				user.setNickName(nickName);
				userDao.savaOrUpdateUser(user);
				str=user.getNickName();
			}
            if(sex!=null&&!"".equals(sex)){
				user.setSex(sex);
				userDao.savaOrUpdateUser(user);
				str=user.getSex();
			}
            if(age!=null&&!"".equals(age)){
	            user.setBirthday(age);
	            userDao.savaOrUpdateUser(user);
	            str=user.getBirthday();
            }
            if(address!=null&&!"".equals(address)){
	            user.setArea(address);
	            userDao.savaOrUpdateUser(user);
	            str=user.getArea();
            }
            if(personalProfile!=null&&!"".equals(personalProfile)){
	            user.setPersonalProfile(personalProfile);
	            userDao.savaOrUpdateUser(user);
	            str=user.getPersonalProfile();
            }
			ok=1;//正常
		}else{
			ok=2;//没有该手机的用户
		}
		//UserDemo userDemo=new UserDemo();
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
        try {
        	//Map<String, Integer> map = new HashMap<String, Integer>();
            //map.put("ok", ok);
            //JSONObject json = JSONObject.fromObject(map);
			//response.getWriter().write(json.toString());
        	Map<String, Object> map = new HashMap<String, Object>();
            map.put("ok", ok);
            map.put("strvalue", str);
            JSONObject jsonObject = JSONObject.fromObject(map);
            
            String result="{\"result\":"+jsonObject.toString()+"}";
            response.getWriter().write(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getPhotoType() {
		return photoType;
	}


	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	
	
}
