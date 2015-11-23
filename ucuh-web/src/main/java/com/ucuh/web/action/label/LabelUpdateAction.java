package com.ucuh.web.action.label;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.LabelDao;
import com.ucuh.entity.Label;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.FileUtilService;

import java.io.File;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 *
 */
@Controller
public class LabelUpdateAction extends HchhAction{
	@Resource FileUtilService fileUtilService;
	@Resource LabelDao labelDao;
	
	//输入
	private int id;
	private String tagName;
	private int typeT;
	private File file;
	private String fileFileName;    //文件名   
    private String filePath;        //文件路径
	//输出
	private Label label=new Label();
	private String urlT;
	/*public String updateLabel(){
		//获取url头信息
    	//HchhUtil hu1=new HchhUtil();
        Properties prop1=HchhUtil.loadProperty();
        urlT=HchhUtil.getUrlHead(prop1);
		String path = ServletActionContext.getServletContext().getRealPath("/upload/tag");
		label=labelDao.findByID(id);
		label.setTagName(tagName);
		label.setTypeT(typeT);
		try {
			if(file!=null){
				  String fileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
		          String name = fileName + fileFileName.substring(fileFileName.lastIndexOf(".")); //保存在硬盘中的文件名

		          FileInputStream inputStream = new FileInputStream(file);
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
	            String allPath=changePath(jdPath);
	            //将当前的文件路径变成服务器访问路径=====================================
	            //HchhUtil hu=new HchhUtil();
	            Properties prop=HchhUtil.loadProperty();
	            String urlHead=HchhUtil.getUrlHead(prop);
	            String projectName=HchhUtil.getProjectName(prop);
	            //通过项目名对allPath截取
	            String[] strs=allPath.split("/"+projectName);
	            String allPath1=urlHead+""+strs[1];
	            System.out.println(allPath1);
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
	            	label.setPhotoPath(allPath1);
	            }else{
	            label.setPhotoPath(allPath1);
	            }
			}
		} catch (Exception e) {

		}
		labelDao.saveLabel(label);
		return "success";
	}*/
	
	
	
	
	
	
	public String updateLabel(){
		//获取url头信息
    	//HchhUtil hu1=new HchhUtil();
        Properties prop1=HchhUtil.loadProperty();
        urlT=HchhUtil.getUrlHead(prop1);
		//String path = ServletActionContext.getServletContext().getRealPath("/upload/tag");
		label=labelDao.findByID(id);
		label.setTagName(tagName);
		label.setTypeT(typeT);
		try {
			if(file!=null){
				  //String fileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
		          String name = fileFileName.substring(fileFileName.lastIndexOf(".")); //保存在硬盘中的文件名
                //上传封面
		        String[] strs=fileUtilService.uploadLabelPhoto(file, name);
	            String ss=label.getPhotoPath();
	            if(ss!=null&&!"".equals(ss)){
	            	/*//将原有服务器上的图片删除
	            	String[] sss=ss.split("/");
	            	String path1=path+"\\"+sss[sss.length-1];
	            	File file = new File(path1);
	            	if(file.exists()&&file.isFile()){
	            	file.delete();        
	            	//file.deleteOnExit();
	            	}*/
	            	fileUtilService.delLabelPhoto(label);
	            	label.setPhotoPath(strs[0]);
	            	label.setRemark1(strs[1]);
	            }else{
	            label.setPhotoPath(strs[0]);
	            label.setRemark1(strs[1]);
	            }
			}
		} catch (Exception e) {

		}
		labelDao.saveLabel(label);
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String changePath(String path){
		String cpath=path.replace("\\", "/");
		return cpath;
	}
	public int getTypeT() {
		return typeT;
	}
	public void setTypeT(int typeT) {
		this.typeT = typeT;
	}
	public String getUrlT() {
		return urlT;
	}
	public void setUrlT(String urlT) {
		this.urlT = urlT;
	}
	
}
