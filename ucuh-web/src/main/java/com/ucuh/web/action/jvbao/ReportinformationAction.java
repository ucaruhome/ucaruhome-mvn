package com.ucuh.web.action.jvbao;

import com.ucuh.util.HchhCommonUtil;
import com.ucuh.util.HchhUtil;
import com.ucuh.dao.PhotoDao;
import com.ucuh.dao.ReportInformationDao;
import com.ucuh.entity.Informationflow;
import com.ucuh.entity.Photo;
import com.ucuh.entity.ReportInformation;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class ReportinformationAction extends HchhAction{
    @Resource ReportInformationDao reportIDao;
    @Resource PhotoDao photoDao;
    //==========================================分页查询=====================================
    //分页
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	//输出
	private List<ReportInformation> list=new ArrayList<ReportInformation>();
	  //output 分页显示的页数
	private String[] pages;
	  //得到举报的缩略图
	private List<List<String>> slts=new ArrayList<List<String>>();
	//===========================================删除===========================================
	private int rid;
	private int ok=0;
	//===========================================批量删除=====================================
	private String ids;
	
	public String ReportInformationslist(){
		//通过roleId查询users
		count=reportIDao.findReportInformationAllCount();
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
		list=reportIDao.findReportInformationAll(count, nowPage, maxPage, maxPageCount);
		pages=HchhCommonUtil.pageShow(maxPage, 5, nowPage);
		for(ReportInformation rif:list){
			List<String> paths=new ArrayList<String>();
			//list<String>
			Informationflow information=rif.getInformationflow();
			//通过informationflowId查询所有的缩略图
			List<Photo> photos=photoDao.findByInformationId(information.getId());
			for(Photo p:photos){
				paths.add(p.getPhotoPath());
			}
			slts.add(paths);
		}
		return "success";
	}

	public String delReportInformationflow(){
		try{
			ReportInformation rif=reportIDao.findById(rid);
			reportIDao.delReportInformationflow(rif);
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=2;
		}
		return "success";
	}
	
	public String delManyReportInformationflow(){
		String[] idss=ids.split(",");
		try{
		for(int i=0;i<idss.length;i++){
			Integer id=Integer.parseInt(idss[i]);
			ReportInformation c=reportIDao.findById(id);
			reportIDao.delReportInformationflow(c);
		}
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=2;
		}
		return "success";
	}
	
	public String settReportInformationState(){
		try{
			ReportInformation rif=reportIDao.findById(rid);
			rif.setState(2);
			reportIDao.saveReportInformation(rif);
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=2;
		}
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




	public List<ReportInformation> getList() {
		return list;
	}



	public void setList(List<ReportInformation> list) {
		this.list = list;
	}



	public String[] getPages() {
		return pages;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
	}



	public List<List<String>> getSlts() {
		return slts;
	}



	public void setSlts(List<List<String>> slts) {
		this.slts = slts;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}
