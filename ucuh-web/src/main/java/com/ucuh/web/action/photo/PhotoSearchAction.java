package com.ucuh.web.action.photo;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.LabelPhotoDao;
import com.ucuh.entity.LabelPhoto;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
@Controller
public class PhotoSearchAction extends HchhAction{
	@Resource LabelPhotoDao lpDao;
	
	private int labelId;
	//分页int nowPage=1,int maxPage,int count,int maxPageCount
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	private List<LabelPhoto> list=new ArrayList<LabelPhoto>();
       
       
       public String queryPhotos(){
    	   //list=photoLabelService.QueryLabelPhotosByLabelId(labelId, nowPage, maxPage, count, maxPageCount);
    	   count=lpDao.findPhotosCountByLabelId(labelId);
   		Properties prop=HchhUtil.loadProperty();
   		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
   		maxPageCount=Integer.valueOf(maxPageCount1);
   		//通过count的值获取maxPage
   		if(count%maxPageCount==0){
   			maxPage=count/maxPageCount;
   		}else{
   			maxPage=count/maxPageCount+1;
   		}
   		list=lpDao.findPhotosByLabelId(labelId, count, nowPage, maxPage, maxPageCount);
    	   return "success";
       }


       
	public int getLabelId() {
		return labelId;
	}


	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}


	public List<LabelPhoto> getList() {
		return list;
	}


	public void setList(List<LabelPhoto> list) {
		this.list = list;
	}


	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getMaxPageCount() {
		return maxPageCount;
	}


	public void setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
	}
       
       
}
