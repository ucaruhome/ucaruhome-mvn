package com.ucuh.web.action.news;

import com.ucuh.dao.NewsDao;
import com.ucuh.entity.News;
import com.ucuh.service.FileUtilService;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FileAction extends ActionSupport {
	@Resource FileUtilService fileUtilService;
	@Resource NewsDao newsDao;
	    //input
	    private int newsId;
	    private File file;
	    private String fileFileName;
	    private String fileFileContentType;
       //output
	    private String message = "你已成功上传文件";
	    private News news=new News();
	    private String  content1;
	    private String  content2;
	    
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public File getFile() {
	        return file;
	    }

	    public void setFile(File file) {
	        this.file = file;
	    }

	    public String getFileFileName() {
	        return fileFileName;
	    }

	    public void setFileFileName(String fileFileName) {
	        this.fileFileName = fileFileName;
	    }

	    public String getFileFileContentType() {
	        return fileFileContentType;
	    }

	    public void setFileFileContentType(String fileFileContentType) {
	        this.fileFileContentType = fileFileContentType;
	    }

		public int getNewsId() {
			return newsId;
		}

		public void setNewsId(int newsId) {
			this.newsId = newsId;
		}

		public News getNews() {
			return news;
		}

		public void setNews(News news) {
			this.news = news;
		}

		public String getContent1() {
			return content1;
		}

		public void setContent1(String content1) {
			this.content1 = content1;
		}

		public String getContent2() {
			return content2;
		}

		public void setContent2(String content2) {
			this.content2 = content2;
		}

		@SuppressWarnings("deprecation")
	    @Override
	    public String execute() throws Exception {
	    	
			File f = this.getFile();
            if(this.getFile()!=null){
	        try {
	            if(!(this.getFileFileName().endsWith(".jpeg")||this.getFileFileName().endsWith(".jpg")||this.getFileFileName().endsWith(".png"))){
	                message="对不起,你上传的文件格式不允许!!!";
	                return ERROR;
	            }
	         /* //根据时间戳生成一个文件夹
		        long timeL=System.currentTimeMillis();
		        String path = ServletActionContext.getServletContext().getRealPath("/upload/newsfengmian/"+timeL);
		        //得到服务器的访问文件的路径
		        //pageContext.getServletContext().getRealPath("/");
		        //System.out.println(timeL);
		        File f1 = new File(path);
				//不存在则创建它
				if(!f1.exists()){
					f1.mkdirs();
				}
	            FileInputStream inputStream = new FileInputStream(f);
	            String aPath=path + "/"+ this.getFileFileName();
	            //对保存的路径进行修改
	            String allPath=changePath(aPath);
	            //将当前的文件路径变成服务器访问路径=====================================
	            //HchhUtil hu=new HchhUtil();
	            Properties prop=HchhUtil.loadProperty();
	            String urlHead=HchhUtil.getUrlHead(prop);
	            String projectName=HchhUtil.getProjectName(prop);
	            //通过项目名对allPath截取
	            String[] strs=allPath.split("/"+projectName);
	            String allPath1=urlHead+""+strs[1];
	            //=======================================================================
	            
	            FileOutputStream outputStream = new FileOutputStream(allPath);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	            outputStream.close();*/
	            String[] strs=fileUtilService.uploadNewsFenMianPhoto(f, this.getFileFileName());
	            //将文件路径保存并返回保存后的id
				news=newsDao.findById(newsId);
				//newsId下的封面文件删除
				String ss=news.getFengmian();
				if(ss!=null&&!"".equals(ss)){
	            	//将原有服务器上的图片删除
	            	/*String[] sss=ss.split("/");
	            	String path1=path+"\\"+sss[sss.length-1];
	            	File file = new File(path1);
	            	if(file.exists()&&file.isFile()){
	            	  file.delete();        
	            	}*/
					fileUtilService.delNewsFenMianPhoto(news);
	            }
	            news.setFengmian(strs[0]);
	            news.setRemark1(strs[1]);
	            newsDao.saveNews(news);
	            content1=news.getContent1();
	            content2=escapeExprSpecialWord(content1);
	        } catch (Exception e) {
	            e.printStackTrace();
	            message = "对不起,文件上传失败了!!!!";
	        }
            }else{
            	message = "对不起,上传文件不能为空!!!!";
            }
	        return SUCCESS;
	    }

		public String changePath(String path){
			String cpath=path.replace("\\", "/");
			return cpath;
		}
		
		/** 
		* 转义正则特殊字符 （$()*+.[]?\^{},|） 
		*  
		* @param keyword 
		* @return 
		*/  
		public static String escapeExprSpecialWord(String keyword) {  
		    if (StringUtils.isNotBlank(keyword)) {  
		        String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };  
		        for (String key : fbsArr) {  
		            if (keyword.contains(key)) {  
		                keyword = keyword.replace(key, "\\" + key);  
		            }  
		        }  
		    }  
		    return keyword;  
		} 

	}
