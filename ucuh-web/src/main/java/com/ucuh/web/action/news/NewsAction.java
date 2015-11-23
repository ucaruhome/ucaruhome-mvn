package com.ucuh.web.action.news;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.NewsDao;
import com.ucuh.entity.News;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller
public class NewsAction extends HchhAction {
    @Resource NewsDao newsDao;
	//==================保存一条消息记录=============================
	 //input
	private String newsId;
	private String theme;
	private String content;
	private int type;
	private int tanchuangYesOrNo;
	private String remark;
	private String content1;
	 //output
	private boolean ok=false;
	//======================得到消息list分页==============================================
	//分页
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	//输出
	private List<News> list=new ArrayList<News>();
	//======================得到一个消息信息消息==============================================
	private News news=new News();
	//=======================删除一条消息=============================================
	private int okey=0;
	public String addNews(){
		
		try{
		News news1=new News();
		User user=(User) session.get("user");
		if("".equals(newsId)){
			news1.setContent(content);
			news1.setTheme(theme);
			news1.setTime(new Date());
			news1.setType(type);
			news1.setUserId(user.getId());
			news1.setTanchuangYesOrNo(tanchuangYesOrNo);
			news1.setRemark(remark);
			news1.setContent1(content1);
			
		}else{
			news1=newsDao.findById(Integer.parseInt(newsId));
			news1.setContent(content);
			news1.setTheme(theme);
			news1.setType(type);
			news1.setTanchuangYesOrNo(tanchuangYesOrNo);
			news1.setRemark(remark);
			news1.setContent1(content1);
			//找到html文件，并将其网络路径保存到waplink中
			
		}
		String htmlHead="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
	        +"<html xmlns='http://www.w3.org/1999/xhtml'><head><meta http-equiv='Content-Type' content='text/html; charset=gbk' />"
	        +"<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />"
	        +"<title>有车有房</title>"
			+"<link href='../css.css' rel='stylesheet' type='text/css' /><link href='../iscroll.css' rel='stylesheet' type='text/css' /></head><body>"
	        +"<div class='other_text_tit'>"+theme+"<span>时间："+new SimpleDateFormat("yyyy-MM-dd").format(news1.getTime())+"</span>"
	        +"</div><div class='other_text'>";
			String htmlFoot="</div></body></html>";
		if(news1.getWaplink()==null||"".equals(news1.getWaplink())){
			//根据时间戳生成一个文件夹
	        long timeL=System.currentTimeMillis();
	        String path = ServletActionContext.getRequest().getRealPath("/upload/newsfiles/"+timeL);
	        //得到服务器的访问文件的路径
	        //pageContext.getServletContext().getRealPath("/");
	        //System.out.println(timeL);
	        File f1 = new File(path);
			//不存在则创建它
			if(!f1.exists()){
				f1.mkdirs();
			}
			String path1=path+"/"+timeL+".html";
			/* 创建存取文件 */
		     FileOutputStream fileStream = new FileOutputStream(path1);
		 
		    /* 将存取文件写入对象 */
		    // ObjectOutputStream os = new ObjectOutputStream(fileStream);
		     PrintStream ps = new PrintStream(fileStream); 
		 
		    /* 写入对象 */
		     //os.writeObject(news.getContent());
		     //os.writeUTF(content);
		     //os.writeChars(content);
		     ps.println(htmlHead+""+content+""+htmlFoot);
		     System.out.println("写入数据成功");
		     /* 关闭ObjectOutputStream */
		     //os.close();
		    ps.close();
		    fileStream.close();
		   //对保存的路径进行修改
	         String allPath=changePath(path1);
	         //将当前的文件路径变成服务器访问路径=====================================
	         //HchhUtil hu=new HchhUtil();
	         Properties prop=HchhUtil.loadProperty();
	         String urlHead=HchhUtil.getUrlHead(prop);
	         String projectName=HchhUtil.getProjectName(prop);
	         //通过项目名对allPath截取
	         String[] strs=allPath.split("/"+projectName);
	         String allPath1=urlHead+""+strs[1];
	         news1.setWaplink(allPath1);
			
		}else{
			String allPath1=news1.getWaplink();
			String path = ServletActionContext.getRequest().getRealPath("/upload/newsfiles");
			//对保存的路径进行修改
	         String allPath=changePath(path);
			 //将当前的文件路径变成服务器访问路径=====================================
	         //HchhUtil hu=new HchhUtil();
	         Properties prop=HchhUtil.loadProperty();
	         //String urlHead=HchhUtil.getUrlHead(prop);
	         String projectName=HchhUtil.getProjectName(prop);
	         //通过项目名对allPath截取
	         String[] strs=allPath.split("/"+projectName);
	         String[] strs1=allPath1.split("/"+projectName);
	         String jueduiLuJing=strs[0]+"/"+projectName+""+strs1[1];
	         File file=new File(jueduiLuJing);
	         if(file.exists()){
	        	 FileOutputStream fileStream = new FileOutputStream(file);
	    		 
	 		    /* 将存取文件写入对象 */
	 		    // ObjectOutputStream os = new ObjectOutputStream(fileStream);
	 		     PrintStream ps = new PrintStream(fileStream); 
	 		 
	 		    /* 写入对象 */
	 		     //os.writeObject(news.getContent());
	 		     //os.writeUTF(content);
	 		     //os.writeChars(content);
	 		     ps.println(htmlHead+""+content+""+htmlFoot);
	 		     System.out.println("写入数据成功");
	 		     /* 关闭ObjectOutputStream */
	 		     //os.close();
	 		    ps.close();
	 		    fileStream.close();
	         }else{
	        	 /* 创建存取文件 */
			     FileOutputStream fileStream = new FileOutputStream(jueduiLuJing);
			 
			    /* 将存取文件写入对象 */
			    // ObjectOutputStream os = new ObjectOutputStream(fileStream);
			     PrintStream ps = new PrintStream(fileStream); 
			 
			    /* 写入对象 */
			     //os.writeObject(news.getContent());
			     //os.writeUTF(content);
			     //os.writeChars(content);
			     ps.println(htmlHead+""+content+""+htmlFoot);
			     System.out.println("写入数据成功");
			     /* 关闭ObjectOutputStream */
			     //os.close();
			    ps.close();
			    fileStream.close();
	         }
		}
		newsDao.saveNews(news1);
		newsId=news1.getId().toString();
		ok=true;
		}catch (Exception e) {
			e.printStackTrace();
			ok=false;
		}
		return "success";
	}

	public String findAllNews(){
		//通过roleId查询users
		count=newsDao.findAllCount();
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		HchhUtil hu=new HchhUtil();
		Properties prop= HchhUtil.loadProperty();
		String maxPageCount1= HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=newsDao.findAll(count, nowPage, maxPage, maxPageCount);
		
		return "success";
	}
	
	public String findOneNews(){
		//将文件路径保存并返回保存后的id
        news=newsDao.findById(Integer.parseInt(newsId));
        content1=news.getContent1();
		return "success";
	}
	
	public String delOneNews(){
		try{
		news=newsDao.findById(Integer.parseInt(newsId));
		//将html文件,封面删除
		String waplink=news.getWaplink();
		String fengmian=news.getFengmian();
		
		String path1 = ServletActionContext.getRequest().getRealPath("/upload/newsfengmian");
		String path2=ServletActionContext.getRequest().getRealPath("/upload/newsfiles");
		//对保存的路径进行修改
         String path1c=changePath(path1);
         String path2c=changePath(path2);
		 //将当前的文件路径变成服务器访问路径=====================================
        // HchhUtil hu=new HchhUtil();
         Properties prop=HchhUtil.loadProperty();
         //String urlHead=HchhUtil.getUrlHead(prop);
         String projectName=HchhUtil.getProjectName(prop);
         //通过项目名对allPath截取
         String[] strs1c=path1c.split("/"+projectName);
         String[] strs2c=path2c.split("/"+projectName);
         String path1cJD=strs1c[0]+"/"+projectName;
         String path1cJD11=path1cJD;
         String path2cJD=strs2c[0]+"/"+projectName;
         String path2cJD22=path2cJD;
         if(news.getFengmian()!=null&&!"".equals(news.getFengmian())){
         String[] jds1=news.getFengmian().split("/"+projectName);
         String path1cJD1=path1cJD+""+jds1[1];
         String[]jds11=jds1[1].split("/");
         path1cJD11=path1cJD+"/upload/newsfengmian/"+jds11[jds11.length-2];
         File file1jd=new File(path1cJD1);
         if(file1jd.exists()){
        	 file1jd.delete();
         }
         }
         if(news.getWaplink()!=null&&!"".equals(news.getWaplink())){
             String[] jds2=news.getWaplink().split("/"+projectName);
             String path2cJD2=path2cJD+""+jds2[1];
             String[] jds22=jds2[1].split("/");
             path2cJD22=path2cJD+"/upload/newsfiles/"+jds22[jds22.length-2];
             File file1jd=new File(path2cJD2);
             if(file1jd.exists()){
            	 file1jd.delete();
             }
         }
         //删除子目录下的文件夹
         File file_path1cJD=new File(path1cJD11);
         File file_path2cJD=new File(path2cJD22);
         if(file_path1cJD.exists()){
        	 file_path1cJD.delete();
         }
         if(file_path2cJD.exists()){
        	 file_path2cJD.delete();
         }
		newsDao.delNews(news);
		okey=1;
		}catch (Exception e) {
			e.printStackTrace();
			okey=2;
		}
		return "success";
	}
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public int getTanchuangYesOrNo() {
		return tanchuangYesOrNo;
	}

	public void setTanchuangYesOrNo(int tanchuangYesOrNo) {
		this.tanchuangYesOrNo = tanchuangYesOrNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
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

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	public String changePath(String path){
		String cpath=path.replace("\\", "/");
		return cpath;
	}

	public int getOkey() {
		return okey;
	}

	public void setOkey(int okey) {
		this.okey = okey;
	}
	
}







