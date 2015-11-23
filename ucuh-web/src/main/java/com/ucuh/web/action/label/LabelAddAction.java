package com.ucuh.web.action.label;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.LabelDao;
import com.ucuh.entity.Label;
import com.ucuh.web.action.HchhAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 *
 */
@Controller
public class LabelAddAction extends HchhAction{
	@Resource LabelDao labelDao;
	
	//输入
	private String biaoqianming;
	private int xuanzexiang;
	private File file;
	private String fileFileName;    //文件名   
    private String filePath;        //文件路径
	//输出
	private Label label=new Label();
	public String addLabel(){
		String path = ServletActionContext.getServletContext().getRealPath("/upload/tag");
		label.setTagName(biaoqianming);
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
	            label.setPhotoPath(allPath1);
	            //将treeCode和grade添加
	            Label la=labelDao.findByID(xuanzexiang);
	            label.setGrade(la.getGrade()+1);
	            label.setDateTime(new Date());
	            label.setParentId(xuanzexiang);
	            label.setPhotoNum(0);
	            label.setType(0);
	            labelDao.saveLabel(label);
	            String treeCode=la.getTreeCode()+"-"+label.getId();
	            label.setTreeCode(treeCode);
	            labelDao.saveLabel(label);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
		return "success";
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

	public String getBiaoqianming() {
		return biaoqianming;
	}

	public void setBiaoqianming(String biaoqianming) {
		this.biaoqianming = biaoqianming;
	}

	public int getXuanzexiang() {
		return xuanzexiang;
	}

	public void setXuanzexiang(int xuanzexiang) {
		this.xuanzexiang = xuanzexiang;
	}
	
}
