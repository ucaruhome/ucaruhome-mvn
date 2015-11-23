package com.ucuh.web.action.fabu;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.InformationflowDao;
import com.ucuh.dao.PhotoDao;
import com.ucuh.entity.Informationflow;
import com.ucuh.entity.Photo;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
@Controller
public class PhotosFabuSelectAction extends HchhAction{
        @Resource InformationflowDao informationflowDao;
        @Resource PhotoDao photoDao;
        
        //得到所有的分类list
        List<Informationflow> list=new ArrayList<Informationflow>();
        //分页
        private int nowPage=1;
    	private int maxPage;
    	private int count;
    	private int maxPageCount=20;
    	
    	//==================查询所有已经通过的=====================================
        public String photoFaBuList(){
        	//查询分页list
        	count=informationflowDao.findByStateCount(1);
        	//从设置参数的.properties中获取分页的每页显示个数
 		    //maxPageCount
 		    //HchhUtil hu=new HchhUtil();
 		    Properties prop=HchhUtil.loadProperty();
 		    String maxPageCount1=HchhUtil.getMaxPageCount(prop);
 		    maxPageCount=Integer.valueOf(maxPageCount1);
 		    if(count%maxPageCount==0){
			  maxPage=count/maxPageCount;
		    }else{
			maxPage=count/maxPageCount+1;
		    }
 		   list=informationflowDao.findByState(1, count, nowPage, maxPage, maxPageCount);
 		   for(Informationflow inff:list){
 			//通过informationflow的id查询所有图片
 			List<Photo> photos=photoDao.findByInformationId(inff.getId());
 			List<String> paths=new ArrayList<String>();
 			  if(photos!=null&&photos.size()!=0){
 				for(Photo photo:photos){
 					paths.add(photo.getPhotoPath());
 				}
 			  }
 			  inff.setSuoFangTus(paths);
 		    }
        	return "success";
        }
        
      //==================查询所有未审核的=====================================
        public String photoFaBuListWSH(){
        	//查询分页list
        	count=informationflowDao.findByStateCount(0);
        	//从设置参数的.properties中获取分页的每页显示个数
 		    //maxPageCount
 		    //HchhUtil hu=new HchhUtil();
 		    Properties prop=HchhUtil.loadProperty();
 		    String maxPageCount1=HchhUtil.getMaxPageCount(prop);
 		    maxPageCount=Integer.valueOf(maxPageCount1);
 		    if(count%maxPageCount==0){
			  maxPage=count/maxPageCount;
		    }else{
			maxPage=count/maxPageCount+1;
		    }
 		   list=informationflowDao.findByState(0, count, nowPage, maxPage, maxPageCount);
 		   for(Informationflow inff:list){
 			//通过informationflow的id查询所有图片
 			List<Photo> photos=photoDao.findByInformationId(inff.getId());
 			List<String> paths=new ArrayList<String>();
 			  if(photos!=null&&photos.size()!=0){
 				for(Photo photo:photos){
 					paths.add(photo.getPhotoPath());
 				}
 			  }
 			  inff.setSuoFangTus(paths);
 		    }
        	return "success";
        }
        //==================查询所有审核未通过的=====================================
        public String photoFaBuListWTG(){
        	//查询分页list
        	count=informationflowDao.findByStateCount(2);
        	//从设置参数的.properties中获取分页的每页显示个数
 		    //maxPageCount
 		    //HchhUtil hu=new HchhUtil();
 		    Properties prop=HchhUtil.loadProperty();
 		    String maxPageCount1=HchhUtil.getMaxPageCount(prop);
 		    maxPageCount=Integer.valueOf(maxPageCount1);
 		    if(count%maxPageCount==0){
			  maxPage=count/maxPageCount;
		    }else{
			maxPage=count/maxPageCount+1;
		    }
 		   list=informationflowDao.findByState(2, count, nowPage, maxPage, maxPageCount);
 		   for(Informationflow inff:list){
 			//通过informationflow的id查询所有图片
 			List<Photo> photos=photoDao.findByInformationId(inff.getId());
 			List<String> paths=new ArrayList<String>();
 			  if(photos!=null&&photos.size()!=0){
 				for(Photo photo:photos){
 					paths.add(photo.getPhotoPath());
 				}
 			  }
 			  inff.setSuoFangTus(paths);
 		    }
        	return "success";
        }  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //==================================================get/set method==========================================================

		public List<Informationflow> getList() {
			return list;
		}

		public void setList(List<Informationflow> list) {
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
