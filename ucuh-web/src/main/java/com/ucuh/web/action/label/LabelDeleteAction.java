package com.ucuh.web.action.label;

import com.ucuh.util.FileUtil;
import com.ucuh.dao.LabelDao;
import com.ucuh.entity.Label;
import com.ucuh.web.action.HchhAction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 *
 */
@Controller
public class LabelDeleteAction extends HchhAction{
	@Resource LabelDao labelDao;
	
	//输入
	private int id;
	//输出
	private Label label=new Label();
	private boolean ok=false;
	public String deleteLabel(){
		        label=labelDao.findByID(id);
		        //判断此标签下是否有子项
		        List<Label> labels=labelDao.findByParentId(label.getId());
		        if(labels==null||labels.size()==0){
		        	String path = ServletActionContext.getServletContext().getRealPath("/upload/tag");
			        String path1=label.getPhotoPath();
			        //得到文件名称
			        /*if(path1!=null&&!"".equals(path1)){
			        	String[] paths=path1.split("/");
				        String fileName=paths[paths.length-1];
			            	String path2=path+"\\"+fileName;
			            	File file = new File(path2);
			            	if(file.exists()&&file.isFile()){
			            	file.delete();        
			            	//file.deleteOnExit();
			            	}
			        }*/
			        FileUtil.delLabel(path, path1);
			       labelDao.deleteLabel(label); 
			        ok=true;
		        }else{
		        	ok=false;
		        }
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	
	public String changePath(String path){
		String cpath=path.replace("\\", "/");
		return cpath;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
