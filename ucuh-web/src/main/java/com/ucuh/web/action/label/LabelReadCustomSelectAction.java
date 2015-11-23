package com.ucuh.web.action.label;

import com.ucuh.dao.LabelDao;
import com.ucuh.entity.Label;
import com.ucuh.web.action.HchhAction;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 *读取所有用户的自定义标签
 */
@Controller
public class LabelReadCustomSelectAction extends HchhAction {
	@Resource LabelDao labelDao;
	private String sousuo="";
	//读取数据返回(系统标签的列表)
    private List<Label> listYX=new ArrayList<Label>();
	public String readLabelCustomXTSouSuo() throws IOException{
		String sousuo1=URLDecoder.decode(sousuo, "utf-8");
		listYX=labelDao.findBySouSuo(sousuo1,1);
		return "success";
	}
	public String readLabelCustomXZSouSuo() throws IOException{
		String sousuo1=URLDecoder.decode(sousuo, "utf-8");
		listYX=labelDao.findBySouSuo(sousuo1,2);
		return "success";
	}

	

	public List<Label> getListYX() {
		return listYX;
	}

	public void setListYX(List<Label> listYX) {
		this.listYX = listYX;
	}

	public String getSousuo() {
		return sousuo;
	}

	public void setSousuo(String sousuo) {
		this.sousuo = sousuo;
	}

	
	
	
}
