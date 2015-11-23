package com.ucuh.web.action.user;

import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.Headphoto;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.FileUtilService;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

//@SuppressWarnings("serial")
@Controller
public class FileAction extends HchhAction {
	@Resource FileUtilService fileUtilService;
	@Resource HeadPhotoDao hpdao;
	@Resource UserDao userDao;
	    private String userId="";
	    private File file;
	    private String fileFileName;
	    private String fileFileContentType;

	    private String message = "你已成功上传文件";
	    private String hpId="";
	    private String url="";
	    
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public File getFile() {
	        return file;
	    }

	    public void setFile(File file) {
	        this.file = file;
	    }

	    public String getFileFileName() {
	        return fileFileName;
	    }

	    public void setFileFileName(String fileFileName) {
	        this.fileFileName = fileFileName;
	    }

	    public String getFileFileContentType() {
	        return fileFileContentType;
	    }

	    public void setFileFileContentType(String fileFileContentType) {
	        this.fileFileContentType = fileFileContentType;
	    }

	    public String getHpId() {
			return hpId;
		}

		public void setHpId(String hpId) {
			this.hpId = hpId;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		
	    public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		/*public String execute() throws Exception {
			User user=(User) session.get("user");
			if(!"".equals(userId)){
				user=userDao.findById(Integer.parseInt(userId));
				user.setHeadPhotoRZ(0);
				userDao.savaOrUpdateUser(user);
			}
	    	
	    	//根据时间戳生成一个文件夹
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
            if(this.getFile()!=null){
	        try {
	            File f = this.getFile();
	            if(!(this.getFileFileName().endsWith(".jpeg")||this.getFileFileName().endsWith(".jpg")||this.getFileFileName().endsWith(".png"))){
	                message="对不起,你上传的文件格式不允许!!!";
	                return "error";
	            }
	            FileInputStream inputStream = new FileInputStream(f);
	            String aPath=path1 + "/"+ this.getFileFileName();
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
	            
	            FileOutputStream outputStream = new FileOutputStream(allPath);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	            outputStream.close();
	            //将文件路径保存并返回保存后的id
	            Headphoto hp=new Headphoto();
	            hp.setHeadPhotoPath(allPath1);
	            hp.setHeadPhotoState(0);
	            hp.setTime(new Date());
	            if(!"".equals(userId)){
	            hp.setUserId(Integer.parseInt(userId));
	            }
	            hpdao.saveOrUpdateHeadPhoto(hp);
	            hpId=hp.getId().toString();
	            url=hp.getHeadPhotoPath();
	        } catch (Exception e) {
	            e.printStackTrace();
	            message = "对不起,文件上传失败了!!!!";
	        }
            }else{
            	message = "对不起,上传文件不能为空!!!!";
            }
	        return "success";
	    }*/

		public String execute() throws Exception {
			User user=(User) session.get("user");
			if(!"".equals(userId)){
				user=userDao.findById(Integer.parseInt(userId));
				user.setHeadPhotoRZ(0);
				userDao.savaOrUpdateUser(user);
			}
	    	
			File f = this.getFile();
            if(f!=null){
		            if(!(this.getFileFileName().endsWith(".jpeg")||this.getFileFileName().endsWith(".jpg")||this.getFileFileName().endsWith(".png"))){
		                message="对不起,你上传的文件格式不允许!!!";
		                return "error";
		     }
		        //上传文件代码
		        String[] strs=fileUtilService.uploadHeadPhotoAdmin(user, f, this.getFileFileName());
		        if(strs!=null){
		        //将文件路径保存并返回保存后的id
	            Headphoto hp=new Headphoto();
	            hp.setHeadPhotoPath(strs[0]);
	            hp.setRemark1(strs[1]);
	            hp.setHeadPhotoState(0);
	            hp.setTime(new Date());
	            if(!"".equals(userId)){
	            hp.setUserId(Integer.parseInt(userId));
	            }
	            hpdao.saveOrUpdateHeadPhoto(hp);
	            hpId=hp.getId().toString();
	            url=hp.getHeadPhotoPath();
	            }else{
	            message = "对不起,文件上传失败了!!!!";
	        }
            }else{
            	message = "对不起,上传文件不能为空!!!!";
            }
	        return "success";
	    }
	}
