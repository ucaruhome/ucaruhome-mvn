package com.ucuh.service.impl;

import com.ucuh.service.FileUtilService;
import com.ucuh.entity.Label;
import com.ucuh.entity.News;
import com.ucuh.entity.Photo;
import com.ucuh.entity.User;
import com.ucuh.util.FileUtil;
import com.ucuh.util.HchhCommonUtil;
import com.ucuh.util.HchhUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FileUtilServiceImpl implements FileUtilService {
    /**
     * folder所包含的父文件夹
     * file上传的文件base64编码
     * String[]返回的是url和删除标记，上传失败返回null
     * 
     */
	public String[] uploadHeadPhoto(User user,String file,String photoType) {
		String[] strs=new String[2];
		//String fwPath=user.getHeadPhoto();
		long timeL=System.currentTimeMillis();
        //TODO String path = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName());
		String path = "/upload/"+user.getUserName();
        //得到服务器的访问文件的路径
        //pageContext.getServletContext().getRealPath("/");
        //System.out.println(timeL);
        File f1 = new File(path);
		//不存在则创建它
		if(!f1.exists()){
			f1.mkdirs();
		}
		//TODO String path1 = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/"+timeL);
		String path1 = ("/upload/"+user.getUserName()+"/"+timeL);
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
        String[] strs1=allPath.split("/"+projectName);
        String allPath1=urlHead+""+strs1[1];
        //=======================================================================
        boolean okey= HchhCommonUtil.GenerateImage(file, aPath);
        if(okey){
        	strs[0]=allPath1;
        	strs[1]=allPath;
		return strs;
        }else{
        	return null;
        }
	}

	/**
	 *user用户
	 *f上传的文件
	 *String[]返回的是url和删除标记，上传失败返回null
	 */
	public String[] uploadHeadPhotoAdmin(User user, File f,String fileName) {
		String[] strs=new String[2];
		try{
		//根据时间戳生成一个文件夹
        long timeL=System.currentTimeMillis();
        //TODO String path = ServletActionContext.getServletContext().getRealPath("/upload/" + user.getUserName());
		String path = "/upload/"+user.getUserName();
        //得到服务器的访问文件的路径
        //pageContext.getServletContext().getRealPath("/");
        //System.out.println(timeL);
        File f1 = new File(path);
		//不存在则创建它
		if(!f1.exists()){
			f1.mkdirs();
		}
		//String path1 = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/"+timeL);
         String path1 = "/upload/"+user.getUserName()+"/"+timeL;
		 File f11 = new File(path1);
			//不存在则创建它
			if(!f11.exists()){
				f11.mkdirs();
			}
		FileInputStream inputStream = new FileInputStream(f);
        String aPath=path1 + "/"+ fileName;
        //对保存的路径进行修改
        String allPath= FileUtil.changePath(aPath);
        //将当前的文件路径变成服务器访问路径=====================================
        //HchhUtil hu=new HchhUtil();
        Properties prop= HchhUtil.loadProperty();
        String urlHead=HchhUtil.getUrlHead(prop);
        String projectName=HchhUtil.getProjectName(prop);
        //通过项目名对allPath截取
        String[] strs1=allPath.split("/"+projectName);
        String allPath1=urlHead+""+strs1[1];
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
        strs[0]=allPath1;//url
        strs[1]=allPath;//绝对路径，即是删除路径
        return strs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 *user用户
	 *f上传的文件
	 *date创建文件夹
	 *String[]返回的是url和删除标记，上传失败返回null
	 */
	public String[] uploadPhoto(User user, File f, String fileName, Date date) {
		String[] strs=new String[2];
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		  String str = sdf.format(date);
	    //TODO String path2=ServletActionContext.getServletContext().getRealPath("/upload/");
	    String path2="/upload/";
	    File file2 = new File(path2); // 判断文件夹是否存在,如果不存在则创建文件夹
	    if (!file2.exists()&&!file2.isDirectory()){
	      file2.mkdir();
	    }
		//TODO String path1=ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/");
		String path1="/upload/"+user.getUserName()+"/";
		File file1 = new File(path1); // 判断文件夹是否存在,如果不存在则创建文件夹
	    if (!file1.exists()&&!file1.isDirectory()){
	      file1.mkdir();
	    }
	    //TODO String path = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/"+str+"/");
		String path = "/upload/"+user.getUserName()+"/"+str+"/";
	    File file = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
	    if (!file.exists()&&!file.isDirectory()){
	      file.mkdir();
	    }
	    String fileName1 = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
        String name = fileName1 + fileName; //保存在硬盘中的文件名

        FileInputStream inputStream = new FileInputStream(f);
        FileOutputStream outputStream = new FileOutputStream(path+ "\\" + name);
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buf)) != -1) {
          outputStream.write(buf, 0, length);
        }
        inputStream.close();
        outputStream.flush();
        //文件保存的完整路径
        // 如：D:\tomcat6\webapps\struts_ajaxfileupload\\upload\a0be14a1-f99e-4239-b54c-b37c3083134a.png
        String filePath= path + "\\" + name;
          //==================================================================
      //将绝对路径变成访问路径
			//对保存的路径进行修改
        String allPath=FileUtil.changePath(filePath);
        //将当前的文件路径变成服务器访问路径
        //HchhUtil hu=new HchhUtil();
        Properties prop=HchhUtil.loadProperty();
        String urlHead=HchhUtil.getUrlHead(prop);
        String projectName=HchhUtil.getProjectName(prop);
        //通过项目名对allPath截取
        String[] strs1=allPath.split("/"+projectName);
        String allPath1=urlHead+""+strs1[1];
        System.out.println(allPath1);
        
        strs[0]=allPath1;
        strs[1]=allPath;
        return strs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;	
		}
		
	}

	/**
	 * 通过访问的url删除   后续可以通过删除的url删除
	 */
	public void delPhoto(Photo photo) {
		String path1=photo.getPhotoPath();
		FileUtil.delPhoto(path1);
	}

	/**
	 *user用户
	 *f上传的文件
	 *date创建文件夹
	 *String[]返回的是url和删除标记，上传失败返回null
	 */
	public String[] uploadLabelPhoto(File f, String fileName) {
		String[] strs=new String[2];
		try{
		//TODO String path = ServletActionContext.getServletContext().getRealPath("/upload/tag");
		String path = "/upload/tag";
		String fileName1 = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
        String name = fileName1 + fileName; //保存在硬盘中的文件名
        FileInputStream inputStream = new FileInputStream(f);
        FileOutputStream outputStream = new FileOutputStream(path+ "\\" + name);
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buf)) != -1) {
          outputStream.write(buf, 0, length);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
		//将封面上传，并将其路径保存到数据库中
		System.out.println(path+ "\\" + name);
		String jdPath=path+ "\\" + name;
		//将绝对路径变成访问路径
		//对保存的路径进行修改
      String allPath=FileUtil.changePath(jdPath);
      //将当前的文件路径变成服务器访问路径=====================================
      //HchhUtil hu=new HchhUtil();
      Properties prop=HchhUtil.loadProperty();
      String urlHead=HchhUtil.getUrlHead(prop);
      String projectName=HchhUtil.getProjectName(prop);
      //通过项目名对allPath截取
      String[] strs1=allPath.split("/"+projectName);
      String allPath1=urlHead+""+strs1[1];
      System.out.println(allPath1);
      
      strs[0]=allPath1;
      strs[1]=allPath;
      
      return strs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * 删除标签的封面
	 */
	public void delLabelPhoto(Label label) {
		//String path = ServletActionContext.getServletContext().getRealPath("/upload/tag");
		String path = "/upload/tag";
		String ss=label.getPhotoPath();
		if(ss!=null&&!"".equals(ss)){
		//将原有服务器上的图片删除
    	String[] sss=ss.split("/");
    	String path1=path+"\\"+sss[sss.length-1];
    	File file = new File(path1);
    	if(file.exists()&&file.isFile()){
    	file.delete();        
    	//file.deleteOnExit();
    	}
		}
	}

	/**
	 *f上传的文件
	 *String[]返回的是url和删除标记，上传失败返回null
	 */
	public String[] uploadNewsFenMianPhoto(File f, String fileName) {
		String[] strs=new String[2];
		try{
		//根据时间戳生成一个文件夹
        long timeL=System.currentTimeMillis();
        //TODO String path = ServletActionContext.getServletContext().getRealPath("/upload/newsfengmian/" + timeL);
        String path = "/upload/newsfengmian/"+timeL;
        //得到服务器的访问文件的路径
        //pageContext.getServletContext().getRealPath("/");
        //System.out.println(timeL);
        File f1 = new File(path);
		//不存在则创建它
		if(!f1.exists()){
			f1.mkdirs();
		}
        FileInputStream inputStream = new FileInputStream(f);
        String aPath=path + "/"+ fileName;
        //对保存的路径进行修改
        String allPath=FileUtil.changePath(aPath);
        //将当前的文件路径变成服务器访问路径=====================================
        //HchhUtil hu=new HchhUtil();
        Properties prop=HchhUtil.loadProperty();
        String urlHead=HchhUtil.getUrlHead(prop);
        String projectName=HchhUtil.getProjectName(prop);
        //通过项目名对allPath截取
        String[] strs1=allPath.split("/"+projectName);
        String allPath1=urlHead+""+strs1[1];
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
        
        strs[0]=allPath1;
        strs[1]=allPath;
        
        return strs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	/**
	 * 删除消息的封面图片
	 */
	public void delNewsFenMianPhoto(News news) {
		String ss=news.getFengmian();
		if(ss!=null&&!"".equals(ss)){
		//TODO String path = ServletActionContext.getServletContext().getRealPath("/upload/newsfengmian");
		String path = "/upload/newsfengmian";
		//将原有服务器上的图片删除
    	String[] sss=ss.split("/");
    	String path1=path+"\\"+sss[sss.length-2];
    	String path2=path+"\\"+sss[sss.length-2]+"\\"+sss[sss.length-1];
    	File file = new File(path2);
    	if(file.exists()&&file.isFile()){
    	  file.delete();        
    	}
    	File file1=new File(path1);
    	if(file1.exists()){
      	  file1.delete();        
      	}
		}
	}
	
	
	

}
