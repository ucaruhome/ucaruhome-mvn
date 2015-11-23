package com.ucuh.web.action.quanwudingzhi;

import com.ucuh.util.HchhCommonUtil;
import com.ucuh.util.HchhUtil;
import com.ucuh.dao.QuanwudingzhiDao;
import com.ucuh.entity.Quanwudingzhi;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class QuanwudingzhiAction extends HchhAction {
    @Resource QuanwudingzhiDao qwdzDao;
    //==========================================分页查询=====================================
    //分页
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	//输出
	private List<Quanwudingzhi> list=new ArrayList<Quanwudingzhi>();
	  //output 分页显示的页数
	private String[] pages;
	
	public String Quanwudingzhislist(){
		//通过roleId查询users
		count=qwdzDao.findQuanwudingzhiAllCount();
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=qwdzDao.findQuanwudingzhiAll(count, nowPage, maxPage, maxPageCount);
		pages=HchhCommonUtil.pageShow(maxPage, 5, nowPage);
		return "success";
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

	

	

	public List<Quanwudingzhi> getList() {
		return list;
	}



	public void setList(List<Quanwudingzhi> list) {
		this.list = list;
	}



	public String[] getPages() {
		return pages;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
	}
	
	
}
