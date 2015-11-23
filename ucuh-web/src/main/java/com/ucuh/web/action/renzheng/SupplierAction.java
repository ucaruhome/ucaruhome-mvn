package com.ucuh.web.action.renzheng;

import com.ucuh.entity.*;
import com.ucuh.util.HchhUtil;
import com.ucuh.dao.ActivityDao;
import com.ucuh.dao.SupplierDao;
import com.ucuh.dao.UserDao;
import com.ucuh.dao.WordbookDao;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class SupplierAction extends HchhAction{
	@Resource UserDao userDao;
	@Resource ActivityDao activityDao;
	@Resource WordbookDao wordbookDao;
	@Resource SupplierDao supplierDao;
    
	//=================================添加一条新的认证信息=========================================================================
	//input
	private String userId;
	private String jbxxsStr;
	private String qtxxtypesStr;
	private String qtxxvaluesStr;
	private int activityType;
	//output
	private int ok=0;
	//=================================查询待认证的设计师===========================================================================
	//input
	private int supplierState;
	//分页
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	//output
	private List<User> list=new ArrayList<User>();
	
	//=================================查询一个设计师信息==================================================
	//output
	private Designer designer=new Designer();
	
	//==================================审核设计师========================================================================
	//userId,supplierState,ok
	
	public String supplierRZ(){
		try{
			User user=userDao.findById(Integer.parseInt(userId));
			user.setSupplier(1);//供应商
			String[] jbxxs=jbxxsStr.split(",");
			String[] qtxxtypes=qtxxtypesStr.split(",");
			String[] qtxxvalues=qtxxvaluesStr.split(",");
			System.out.println(jbxxs.length);
			System.out.println(qtxxtypes.length);
			System.out.println(qtxxvalues.length);
			//添加基本信息
			Supplier supplier=new Supplier();
			 //通过userId查找designer是否存在
			supplier=supplierDao.findByUserId(Integer.parseInt(userId));
			supplier.setCompanyName(jbxxs[2]);
			supplier.setEmail(jbxxs[6]);
			supplier.setName(jbxxs[4]);
			supplier.setPhone(jbxxs[5]);
			supplier.setPosition(jbxxs[3]);
			supplier.setState(1);//待审核
			supplier.setUser(user);
			supplierDao.saveSupplier(supplier);
			userDao.savaOrUpdateUser(user);
			//保存一个活动信息（即：收费信息）
			Activity activity=activityDao.findBySupplierId(supplier.getId());
			activity.setState(0);
			activity.setType(0);
			activity.setSupplierId(supplier.getId());
			activity.setType(activityType);
			activityDao.saveActivity(activity);
			//添加活动信息
			for(int i=0;i<qtxxtypes.length;i++){
				String leixing=qtxxtypes[i];
				String valuestr=qtxxvalues[i];
				if("空".equals(leixing)&&"空".equals(valuestr)){
					continue;
				}else{
					Wordbook wb=wordbookDao.findByLNA("supplier_housetype", leixing, activity.getId());
					wb.setActivityId(activity.getId());
					wb.setName(leixing);
					if(!"空".equals(valuestr)){
					wb.setValue(valuestr);
					}else{
						wb.setValue("");
					}
					wb.setLeixing("supplier_housetype");
					wordbookDao.saveWordbook(wb);
				}
			}
			ok=1;
			}catch (Exception e) {
				e.printStackTrace();
				ok=2;
			}
			return "success";
	}

	public String findOneSupplierUser(){
		//1.通过userId查询对应的设计者
		Supplier d=supplierDao.findByUserId(Integer.parseInt(userId));
		//2.通过对应的设计者找到对应的活动
		Activity ac=activityDao.findBySupplierId(d.getId());
		//3.通过活动查询对应的子信息
		List<Wordbook> wbs=wordbookDao.findByActivityId(ac.getId(),"supplier_housetype");
		designer.setCompanyName(d.getCompanyName());
		designer.setEmail(d.getEmail());
		designer.setName(d.getName());
		designer.setPhone(d.getPhone());
		designer.setPosition(d.getPosition());
		designer.setRemark(d.getRemark());
		designer.setState(d.getState());
		designer.setTel(d.getTel());
		designer.setTime(d.getTime());
		//designer.setType(ac.getType());
		designer.setUser(d.getUser());
		//designer.setWbs(wbs);
		return "success";
	}
	
	public String findSupplierUsers(){
		count=userDao.findUserAllCountBySupplier(supplierState);
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
		list=userDao.findUsersAllBySupplier(supplierState, count, nowPage, maxPage, maxPageCount);
		
		return "success";
	}
	
	public String findSupplierUsersShenHeOver(){
		count=userDao.findUserAllCountBySupplierOver();
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
		list=userDao.findUsersAllBySupplierOver(count, nowPage, maxPage, maxPageCount);
		
		return "success";
	}
	
	public String shenHeSupplier(){
		//1.通过userId查询对应的设计者
		Supplier d=supplierDao.findByUserId(Integer.parseInt(userId));
		//2.通过userId查询user
		User u=userDao.findById(Integer.parseInt(userId));
		d.setState(supplierState);
		u.setSupplier(supplierState);
		userDao.savaOrUpdateUser(u);
		supplierDao.saveSupplier(d);
		ok=1;
		
		return "success";
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJbxxsStr() {
		return jbxxsStr;
	}

	public void setJbxxsStr(String jbxxsStr) {
		this.jbxxsStr = jbxxsStr;
	}

	public String getQtxxtypesStr() {
		return qtxxtypesStr;
	}

	public void setQtxxtypesStr(String qtxxtypesStr) {
		this.qtxxtypesStr = qtxxtypesStr;
	}

	public String getQtxxvaluesStr() {
		return qtxxvaluesStr;
	}

	public void setQtxxvaluesStr(String qtxxvaluesStr) {
		this.qtxxvaluesStr = qtxxvaluesStr;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	public int getSupplierState() {
		return supplierState;
	}

	public void setSupplierState(int supplierState) {
		this.supplierState = supplierState;
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

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	
	
}
