package com.ucuh.web.action.phone;


import com.ucuh.model.UserDemo;
import com.ucuh.util.HchhCommonUtil;
import com.ucuh.util.HchhUtil;
import com.ucuh.dao.CodeDao;
import com.ucuh.dao.DesignerDao;
import com.ucuh.dao.GroupDao;
import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.dao.RoleDao;
import com.ucuh.dao.SupplierDao;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.Code;
import com.ucuh.entity.CodeId;
import com.ucuh.entity.Designer;
import com.ucuh.entity.Group;
import com.ucuh.entity.Headphoto;
import com.ucuh.entity.Role;
import com.ucuh.entity.Supplier;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.FileUtilService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class PhoneUserAction  extends HchhAction{
	@Resource FileUtilService fileUtilService;
	@Resource UserDao userDao;
	@Resource CodeDao codeDao;
	@Resource RoleDao roleDao;
	@Resource HeadPhotoDao hpDao;
	@Resource GroupDao groupDao;
	
	@Resource DesignerDao designerDao;
	@Resource SupplierDao supplierDao;
	//================================登录===================================================================================
	//ok=0,登录失败，1，登录成功，2，用户名密码不对，3，系统异常
    public String userName;
    public String passWord;
    public String microblog;
    public String wechat;
  //返回值
    public int ok=0;
    //================================注册发送信息==================================================================================
    //userName,passWord返回发送短信的状态0,发送失败，1,发送成功,2,系统异常,3,手机号码被占用
    private String sex;
    private String nickName;
    private String phone;
    private String dateString;
    //=================================注册保存用户信息===========================================================================================
    private String address;
    private String headPhoto;
    private String photoType;
    private String state;
      //ok,0,发送失败,1,注册成功，2，验证码超时，3，手机号码被占用，4，系统异常
	public void LoginTo(){
		        User user=new User();
		        UserDemo userDemo=new UserDemo();
		        try{
				String passWord1=HchhUtil.strToMD5(passWord);
				//通过userName和passWord查询用户信息
				//通过userName和passWord1查询用户信息
				//if(userName==null||"".equals(userName)){
				  user=userDao.findUserByPhoneAndPassword(phone, passWord, passWord1);
				//}else{
				// user=userDao.findUser(userName, passWord, passWord1);
				//}
				if(user==null){
					ok=2;//用户名或者密码不对
				}else{
					ok=1;//登录成功
					
					userDemo.setIdenify(user.getId());
					userDemo.setRoleId(user.getRole().getId());
					userDemo.setRoleName(user.getRole().getRoleName());
					userDemo.setRoleDes(user.getRole().getRoleDes());
					userDemo.setGroupId(user.getGroup().getId());
					userDemo.setGroupName(user.getGroup().getGroupName());
					userDemo.setGroupDes(user.getGroup().getGroupDes());
					userDemo.setUserName(user.getUserName());
					userDemo.setName(user.getName());
					userDemo.setMicroblog(user.getMicroblog());
					userDemo.setWechat(user.getWechat());
					//userDemo.setHeadPhoto();//头像的图片base64
					  //1.得到头像的http路径
					  /* String httpPath=user.getHeadPhoto();
					   if(httpPath==null||(httpPath!=null&&"".equals(httpPath.trim()))||"".equals(httpPath)){
						   userDemo.setHeadPhoto("");
					   }else{
						   String path1 = ServletActionContext.getServletContext().getRealPath("/upload");
						   //2.得到头像的绝对路径
						   String path=HchhCommonUtil.Path(httpPath, path1);
						   String headPhoto=HchhCommonUtil.GetImageStr(path);
						   userDemo.setHeadPhoto(headPhoto);
					   }*/
					userDemo.setHeadPhoto(user.getHeadPhoto());
					userDemo.setNickName(user.getNickName());
					userDemo.setSex(user.getSex());
					userDemo.setAge(user.getAge());
					userDemo.setArea(user.getArea());
					userDemo.setWebSite(user.getWebSite());
					userDemo.setPersonalProfile(user.getPersonalProfile());
					userDemo.setDesigner(user.getDesigner());//设计师认证
					  //得到设计师资料
					   Designer d=designerDao.findByUserId(user.getId());
					   if(d!=null){
					   userDemo.setCompanyName1(d.getCompanyName());
					   userDemo.setPosition1(d.getPosition());
					   userDemo.setRealName1(d.getName());
					   userDemo.setTelPhone1(d.getPhone());
					   userDemo.setEmail1(d.getEmail());
					   userDemo.setRemark(d.getRemark());
					   }
					userDemo.setDistributor(user.getDesigner());//经销商认证
					  //得到经销商资料
					   Supplier s=supplierDao.findByUserId(user.getId());
					   if(s!=null){
					   userDemo.setCompanyName2(s.getCompanyName());
					   userDemo.setPosition2(s.getPosition());
					   userDemo.setRealName2(s.getName());
					   userDemo.setTelPhone2(s.getPhone());
					   userDemo.setEmail2(s.getEmail());
					   userDemo.setRemark2(s.getRemark());
					   }
					   
					//userDemo.setPassword(user.getPassword());
					userDemo.setRemark(user.getRemark());
					userDemo.setSupplier(user.getSupplier());//供应商认证
					  //得到供应商资料
					userDemo.setBirthday(user.getBirthday());
					userDemo.setHeadPhotoRZ(user.getHeadPhotoRZ());//头像审核
					userDemo.setAddtime(user.getAddtime());
					userDemo.setUpdatetime(user.getUpdatetime());
					userDemo.setPhone(user.getPhone());
				}
		        }catch (Exception e) {
					e.printStackTrace();
					ok=3;//系统异常
				}
				
		        HttpServletResponse response = ServletActionContext.getResponse();  
		        response.setCharacterEncoding("utf-8");
		        //response.setContentType("text/xml;charset=utf-8");
		        try {
		        	//List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		        	Map<String, Object> map = new HashMap<String, Object>();
                    map.put("ok", ok);
                    JSONObject jsonObject = JSONObject.fromObject(map);
                    //list.add(map);
                    Map<String, Object> map1 = HchhCommonUtil.UserToMap(userDemo);
                    JSONObject jsonObject1 = JSONObject.fromObject(map1);
                    //if(user!=null){
					//list.add(map1);
                    //}
					//JsonConfig jsonConfig = new JsonConfig();
				    //jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
				    //JSONArray jo = JSONArray.fromObject(list);
				    //System.out.println(jo.toString());
				    //response.getWriter().write(jo.toString());
				    //System.out.println(jsonObject.toString());
				    //System.out.println(jsonObject1.toString());
                    String result="{\"result\":"+jsonObject.toString()+"}";
                    if(user!=null){
                    	result="{\"result\":"+jsonObject.toString()+","+"\"user\":"+jsonObject1.toString()+"}";
                    }
				    //System.out.println(result);
				    response.getWriter().write(result);
				} catch (Exception e) {
					e.printStackTrace();
				}

		
	}
	
	public void RegistSend(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//判断当前手机是否被占用
		List<User> users=userDao.findByPhone(phone);
		if(users.size()!=0){
			ok=3;
		}else{
		try{
		Code delCode=codeDao.findByUserKey(phone);
		if(delCode!=null){
			codeDao.delCode(delCode);
		}
		String codeStr=HchhCommonUtil.VerificationCode(6, 0);
		//Code code=codeDao.findByUserKey("caochuankui1");
		CodeId cId=new CodeId();
		Date date=sdf.parse(dateString);
		Calendar ca=Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.SECOND, 120);
		cId.setSendOverTime(ca.getTime());
		cId.setUserCode(codeStr);
		cId.setUserKey(phone);
		Code code=new Code();
		code.setId(cId);
		codeDao.saveCode(code);
		if("0".equals(state)){
		HchhCommonUtil.SendNews(phone, codeStr, 0);
		}else{
		HchhCommonUtil.SendNews(phone, codeStr, 1);
		}
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=2;
		}
		}
		HttpServletResponse response = ServletActionContext.getResponse();  
        try {
        	Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("ok", ok);
            JSONObject json = JSONObject.fromObject(map);
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void RegistUser(){
		UserDemo userDemo=new UserDemo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//判断当前手机是否被占用
		List<User> users=userDao.findByPhone(phone);
		if(users.size()!=0){
			ok=3;
		}else{
			try{
		//通过手机号查询code
		Code code=codeDao.findByUserKey(phone);
		if(code==null){
			ok=0;
		}else{
			Date date=code.getId().getSendOverTime();
			Date date1=sdf.parse(dateString);
			if(date1.getTime()<=date.getTime()){
				
				//执行注册操作，并将传入数据保存到数据库
				//1.将用户的信息保存（除了头像以外）
				User user=new User();
				user.setAddtime(new Date());
				user.setArea(address);
				user.setSex(sex);
				user.setPhone(phone);
				user.setNickName(nickName);
				user.setPassword(passWord);
				userDao.savaOrUpdateUser(user);
				user.setUserName("ycyh"+user.getId());
				Role role=roleDao.findRole("普通用户");
				user.setRole(role);
				Group group=groupDao.findByGroupName("普通组");
				user.setGroup(group);
				user.setWechat(wechat);
				user.setMicroblog(microblog);
				//2.对头像的处理
				/*long timeL=System.currentTimeMillis();
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
	            //将user转变成userDemo
	            userDemo.setIdenify(user.getId());
				userDemo.setRoleId(user.getRole().getId());
				userDemo.setRoleName(user.getRole().getRoleName());
				userDemo.setRoleDes(user.getRole().getRoleDes());
				userDemo.setGroupId(user.getGroup().getId());
				userDemo.setGroupName(user.getGroup().getGroupName());
				userDemo.setGroupDes(user.getGroup().getGroupDes());
				userDemo.setUserName(user.getUserName());
				userDemo.setName(user.getName());
				userDemo.setMicroblog(user.getMicroblog());
				userDemo.setWechat(user.getWechat());
				userDemo.setHeadPhoto(user.getHeadPhoto());
				userDemo.setNickName(user.getNickName());
				userDemo.setSex(user.getSex());
				userDemo.setAge(user.getAge());
				userDemo.setArea(user.getArea());
				userDemo.setWebSite(user.getWebSite());
				userDemo.setPersonalProfile(user.getPersonalProfile());
				userDemo.setDesigner(user.getDesigner());//设计师认证
				  //得到设计师资料
				   Designer d=designerDao.findByUserId(user.getId());
				   if(d!=null){
				   userDemo.setCompanyName1(d.getCompanyName());
				   userDemo.setPosition1(d.getPosition());
				   userDemo.setRealName1(d.getName());
				   userDemo.setTelPhone1(d.getPhone());
				   userDemo.setEmail1(d.getEmail());
				   userDemo.setRemark(d.getRemark());
				   }
				userDemo.setDistributor(user.getDesigner());//经销商认证
				  //得到经销商资料
				   Supplier s=supplierDao.findByUserId(user.getId());
				   if(s!=null){
				   userDemo.setCompanyName2(s.getCompanyName());
				   userDemo.setPosition2(s.getPosition());
				   userDemo.setRealName2(s.getName());
				   userDemo.setTelPhone2(s.getPhone());
				   userDemo.setEmail2(s.getEmail());
				   userDemo.setRemark2(s.getRemark());
				   }
				   
				//userDemo.setPassword(user.getPassword());
				userDemo.setRemark(user.getRemark());
				userDemo.setSupplier(user.getSupplier());//供应商认证
				  //得到供应商资料
				userDemo.setBirthday(user.getBirthday());
				userDemo.setHeadPhotoRZ(user.getHeadPhotoRZ());//头像审核
				userDemo.setAddtime(user.getAddtime());
				userDemo.setUpdatetime(user.getUpdatetime());
				userDemo.setPhone(user.getPhone());
	            ok=1;
				
			}else{
				ok=2;
			}
		}
			}catch (Exception e) {
				e.printStackTrace();
				ok=4;
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setCharacterEncoding("utf-8");
        try {
        	//Map<String, Integer> map = new HashMap<String, Integer>();
            //map.put("ok", ok);
            //JSONObject json = JSONObject.fromObject(map);
			//response.getWriter().write(json.toString());
        	Map<String, Object> map = new HashMap<String, Object>();
            map.put("ok", ok);
            JSONObject jsonObject = JSONObject.fromObject(map);
            //list.add(map);
            Map<String, Object> map1 = HchhCommonUtil.UserToMap(userDemo);
            JSONObject jsonObject1 = JSONObject.fromObject(map1);
            String result="{\"result\":"+jsonObject.toString()+"}";
            if(userDemo!=null){
            	result="{\"result\":"+jsonObject.toString()+","+"\"user\":"+jsonObject1.toString()+"}";
            }
            //System.out.println(result);
            response.getWriter().write(result);
		} catch (Exception e) {
			e.printStackTrace();
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
	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}
	
	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	/*public String changePath(String path){
		String cpath=path.replace("\\", "/");
		return cpath;
	}*/

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
