package com.ucuh.web.action.label;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.LabelDao;
import com.ucuh.entity.Label;
import com.ucuh.web.action.HchhAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 *读取所有用户的自定义标签
 */
@Controller
public class LabelReadCustomAction extends HchhAction {
	@Resource LabelDao labelDao;
	//输入数据
	private int id;
	//读取数据返回(系统标签的列表)
    private List<Label> listYX=new ArrayList<Label>();
    //读取单个标签的信息
    private Label label=new Label();
    //url头
    private String urlT;
    
    
    //归类到自定义后的返回值
    private boolean ok=false;
    public String readLabelXXXX(){
    	label=labelDao.findByID(id);
    	//获取url头信息
    	//HchhUtil hu=new HchhUtil();
        Properties prop=HchhUtil.loadProperty();
        urlT=HchhUtil.getUrlHead(prop);
    	return "success";
    }
    
	public String readLabelCustomXT() throws IOException{
		listYX=labelDao.findByTypeAndTreeCodeAsc(1);
		return "success";
	}
	public String readLabelCustomXZ() throws IOException{
		listYX=labelDao.findByTypeAndTreeCodeAsc(2);
		return "success";
	}

	public String labelCustomGL(){
		label=labelDao.findByID(id);
		//获得自定义标签总类
		Label label1=labelDao.findByTPG(1, 0, 0);
		label.setType(1);
		label.setParentId(label1.getId());
		label.setTreeCode(label1.getTreeCode()+"-"+label.getId());
		label.setGrade(label1.getGrade()+1);
		labelDao.saveLabel(label);
		ok=true;
		return "success";
	}

	public String labelCustomHL(){
		label=labelDao.findByID(id);
		//设置为忽略
		label.setType(10);
		labelDao.saveLabel(label);
		ok=true;
		return "success";
	}
	public List<Label> getListYX() {
		return listYX;
	}

	public void setListYX(List<Label> listYX) {
		this.listYX = listYX;
	}



	public Label getLabel() {
		return label;
	}



	public void setLabel(Label label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlT() {
		return urlT;
	}

	public void setUrlT(String urlT) {
		this.urlT = urlT;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	
	
	
}
