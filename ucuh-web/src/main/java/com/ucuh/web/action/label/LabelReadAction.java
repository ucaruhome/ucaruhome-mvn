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
 *
 */
@Controller
public class LabelReadAction extends HchhAction {
	@Resource LabelDao labelDao;
	//输入数据
	private int id;
	//读取数据返回(系统标签的列表)
    private List<Label> listYX=new ArrayList<Label>();
    //读取单个标签的信息
    private Label label=new Label();
    //url头
    private String urlT;
    
    public String readLabelXXXX(){
    	label=labelDao.findByID(id);
    	//获取url头信息
    	//HchhUtil hu=new HchhUtil();
        Properties prop=HchhUtil.loadProperty();
        urlT=HchhUtil.getUrlHead(prop);
    	return "success";
    }
    
	public String readLabelXT() throws IOException{
		listYX=labelDao.findByTypeAndTreeCodeAsc(0);
		return "success";
	}
	public String readLabelXZ() throws IOException{
		listYX=labelDao.findByTypeAndTreeCodeAsc(0);
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

	
	
	
}
