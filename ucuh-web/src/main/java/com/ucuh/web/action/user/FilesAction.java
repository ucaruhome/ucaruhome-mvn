package com.ucuh.web.action.user;

import com.ucuh.dao.FenLeiDao;
import com.ucuh.dao.InformationflowDao;
import com.ucuh.dao.InformationflowFenleiDao;
import com.ucuh.dao.LabelDao;
import com.ucuh.dao.LabelPhotoDao;
import com.ucuh.dao.PhotoDao;
import com.ucuh.dao.UserDao;
import com.ucuh.entity.FenLei;
import com.ucuh.entity.Informationflow;
import com.ucuh.entity.InformationflowFenlei;
import com.ucuh.entity.Label;
import com.ucuh.entity.LabelPhoto;
import com.ucuh.entity.Photo;
import com.ucuh.entity.PhotoAllLabel;
import com.ucuh.entity.User;
import com.ucuh.service.CommService;
import com.ucuh.service.FileUtilService;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FilesAction extends ActionSupport {
	@Resource FileUtilService fileUtilService;
	@Resource(name="commService")
	private CommService commService;
	@Resource InformationflowDao informationflowDao;
	@Resource UserDao userDao;
	@Resource PhotoDao photoDao;
	@Resource LabelPhotoDao lpDao;
    @Resource InformationflowFenleiDao informationflowFenleiDao;
    @Resource FenLeiDao fenleiDao;
    @Resource LabelDao labelDao;
	
	private int userId;
	private String userName;
	private String[] fl;//发布的模块 
	private String des;
	private String theme;
	
	private File[] file;              //文件  
    private String[] fileFileName;    //文件名   
    private String[] filePath;        //文件路径
    private String downloadFilePath;  //文件下载路径
    private InputStream inputStream; 
    
    
    //上传成功后显示的图片
    //private List<Photo> photos=new ArrayList<Photo>();
    //output
  //信息流的详细信息
    private Informationflow informationflow;
    //信息流中的所有照片的标签信息
    private List<PhotoAllLabel> pals=new ArrayList<PhotoAllLabel>();
    
    //当前信息流的分类
    private List<InformationflowFenlei> fenleis=new ArrayList<InformationflowFenlei>();
    //所有的分类信息
    private List<FenLei> fenleisAll=new ArrayList<FenLei>();
    //得到系统标签的选择项
    private List<Label> listYX=new ArrayList<Label>();
    //得到可购标签的页面
    private List<Label> listYX1=new ArrayList<Label>();
    
    /**
     * 文件上传
     * @return
     */
 /* public String fileUpload() {
	  //保存一个信息流
	  Informationflow informationflow=new Informationflow();
	  informationflow.setTheme(theme);
	  informationflow.setDes(des);
	  informationflow.setState(0);
	  informationflow.setPhotoNum(file.length);
	  informationflow.setTime(new Date());
	  User user=userDao.findById(userId);
	  informationflow.setUser(user);
	  informationflowDao.saveInformationflow(informationflow);
	  try{
	  commService.saveInformationflowRecord("发布", userName,informationflow);
	  }catch (Exception e) {
		e.printStackTrace();
	}
	  //添加分类信息
	  for(String fenlei:fl){
		  FenLei fenlei1=fenleiDao.findById(Integer.parseInt(fenlei));
		  InformationflowFenlei iffl=new InformationflowFenlei();
		  iffl.setFenLei(fenlei1);
		  iffl.setInformationflow(informationflow);
		  informationflowFenleiDao.saveInformationflowFenlei(iffl);
		  fenleis.add(iffl);
	  }
	//获取一个时间戳
	  Date date = new Date();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	  String str = sdf.format(date);
    String path2=ServletActionContext.getServletContext().getRealPath("/upload/");
    File file2 = new File(path2); // 判断文件夹是否存在,如果不存在则创建文件夹
    if (!file2.exists()&&!file2.isDirectory()){
      file2.mkdir();
    }
	String path1=ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/");
	File file1 = new File(path1); // 判断文件夹是否存在,如果不存在则创建文件夹
    if (!file1.exists()&&!file1.isDirectory()){
      file1.mkdir();
    }
    String path = ServletActionContext.getServletContext().getRealPath("/upload/"+user.getUserName()+"/"+str+"/");
    File file = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
    if (!file.exists()&&!file.isDirectory()){
      file.mkdir();
    }
    try {
      if (this.file != null) {
        File f[] = this.getFile();
        filePath = new String[f.length];
        for (int i = 0; i < f.length; i++) {
          String fileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
          String name = fileName + fileFileName[i].substring(fileFileName[i].lastIndexOf(".")); //保存在硬盘中的文件名

          FileInputStream inputStream = new FileInputStream(f[i]);
          FileOutputStream outputStream = new FileOutputStream(path+ "\\" + name);
          byte[] buf = new byte[1024];
          int length = 0;
          while ((length = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, length);
          }
          inputStream.close();
          outputStream.flush();
          //文件保存的完整路径
          // 如：D:\tomcat6\webapps\struts_ajaxfileupload\\upload\a0be14a1-f99e-4239-b54c-b37c3083134a.png
          filePath[i] = path + "\\" + name;
            //==================================================================
        //将绝对路径变成访问路径
			//对保存的路径进行修改
          String allPath=changePath(filePath[i]);
          //将当前的文件路径变成服务器访问路径
          //HchhUtil hu=new HchhUtil();
          Properties prop=HchhUtil.loadProperty();
          String urlHead=HchhUtil.getUrlHead(prop);
          String projectName=HchhUtil.getProjectName(prop);
          //通过项目名对allPath截取
          String[] strs=allPath.split("/"+projectName);
          String allPath1=urlHead+""+strs[1];
          System.out.println(allPath1);
            //==================================================================
          //保存一个照片信息
          Photo photo=new Photo();
          photo.setInformationflow(informationflow);
          photo.setPhotoPath(allPath1);
          photo.setTime(new Date());
          photo.setUser(user);
          photoDao.savePhoto(photo);
          
          //photos.add(photo);
        }

      }
    
    //得到标签的选择
    listYX=labelDao.findByTypeAndTreeCodeAsc1(0);
  	try {
    listYX1=labelDao.findByTypeAndTreeCodeAsc2(0);
		} catch (Exception e) {
			e.printStackTrace();
		}  
      //得到当前工作流信息
    List<Photo> photos=photoDao.findByInformationId(informationflow.getId());
  	//fenleis=informationflowFenleiDao.findByInformationflowId(informationflow.getId());
  	fenleisAll=fenleiDao.findAll();
  	for(Photo photo:photos){
  		PhotoAllLabel pal=new PhotoAllLabel();
      	pal.setPhoto(photo);
  		//通过信息流id查询普通标签，地点标签及额外标签
  		// private List<LabelPhoto> lpsPutong;
        // private List<LabelPhoto> lpsDidian;
        //private List<LabelPhoto> lpsEwai;
        //private List<LabelPhoto> lpsKegou;
  		//
      	List<LabelPhoto> lpsPutong=lpDao.findByIdAndTypet1(photo.getId(), 0);
      	List<LabelPhoto> lpsDidian=lpDao.findByIdAndTypet(photo.getId(), 1);
      	List<LabelPhoto> lpsEwai=lpDao.findByIdAndTypet(photo.getId(), 3);
      	//通过信息流id查询可购标签 
      	List<LabelPhoto> lpsKegou=lpDao.findByIdAndTypet(photo.getId(), 2);
      	pal.setLpsPutong(lpsPutong);
      	pal.setLpsDidian(lpsDidian);
      	pal.setLpsEwai(lpsEwai);
      	pal.setLpsKegou(lpsKegou);
      	pals.add(pal); 
  	}
      
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
    
  }*/
    
    
    
    
    
    
    public String fileUpload() {
  	  //保存一个信息流
  	  Informationflow informationflow=new Informationflow();
  	  informationflow.setTheme(theme);
  	  informationflow.setDes(des);
  	  informationflow.setState(0);
  	  informationflow.setPhotoNum(file.length);
  	  informationflow.setTime(new Date());
  	  User user=userDao.findById(userId);
  	  informationflow.setUser(user);
  	  informationflowDao.saveInformationflow(informationflow);
  	  try{
  	  commService.saveInformationflowRecord("发布", userName,informationflow);
  	  }catch (Exception e) {
  		e.printStackTrace();
  	}
  	  //添加分类信息
  	  for(String fenlei:fl){
  		  FenLei fenlei1=fenleiDao.findById(Integer.parseInt(fenlei));
  		  InformationflowFenlei iffl=new InformationflowFenlei();
  		  iffl.setFenLei(fenlei1);
  		  iffl.setInformationflow(informationflow);
  		  informationflowFenleiDao.saveInformationflowFenlei(iffl);
  		  fenleis.add(iffl);
  	  }
  	//获取一个时间戳
  	  Date date = new Date();
  	  
      try {
        if (this.file != null) {
          File f[] = this.getFile();
          filePath = new String[f.length];
          for (int i = 0; i < f.length; i++) {
            //String fileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名
            String name =fileFileName[i].substring(fileFileName[i].lastIndexOf(".")); //保存在硬盘中的文件名
            //上传图片
            String[] strs=fileUtilService.uploadPhoto(user, f[i], name, date);
              //==================================================================
            if(strs!=null){
            //保存一个照片信息
            Photo photo=new Photo();
            photo.setInformationflow(informationflow);
            photo.setPhotoPath(strs[0]);
            photo.setRemark1(strs[1]);
            photo.setTime(new Date());
            photo.setUser(user);
            photoDao.savePhoto(photo);
            }
            //photos.add(photo);
          }

        }
      
      //得到标签的选择
      listYX=labelDao.findByTypeAndTreeCodeAsc1(0);
    	try {
      listYX1=labelDao.findByTypeAndTreeCodeAsc2(0);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}  
        //得到当前工作流信息
      List<Photo> photos=photoDao.findByInformationId(informationflow.getId());
    	//fenleis=informationflowFenleiDao.findByInformationflowId(informationflow.getId());
    	fenleisAll=fenleiDao.findAll();
    	for(Photo photo:photos){
    		PhotoAllLabel pal=new PhotoAllLabel();
        	pal.setPhoto(photo);
    		//通过信息流id查询普通标签，地点标签及额外标签
    		// private List<LabelPhoto> lpsPutong;
          // private List<LabelPhoto> lpsDidian;
          //private List<LabelPhoto> lpsEwai;
          //private List<LabelPhoto> lpsKegou;
    		//
        	List<LabelPhoto> lpsPutong=lpDao.findByIdAndTypet1(photo.getId(), 0);
        	List<LabelPhoto> lpsDidian=lpDao.findByIdAndTypet(photo.getId(), 1);
        	List<LabelPhoto> lpsEwai=lpDao.findByIdAndTypet(photo.getId(), 3);
        	//通过信息流id查询可购标签 
        	List<LabelPhoto> lpsKegou=lpDao.findByIdAndTypet(photo.getId(), 2);
        	pal.setLpsPutong(lpsPutong);
        	pal.setLpsDidian(lpsDidian);
        	pal.setLpsEwai(lpsEwai);
        	pal.setLpsKegou(lpsKegou);
        	pals.add(pal); 
    	}
        
        return "success";
      } catch (Exception e) {
        e.printStackTrace();
        return "error";
      }
      
    }
    
    
    
    
    
    
    
    
    
  /**
   * 文件下载
   * @return
   */
  /*public String downloadFile() {
    String path = downloadFilePath;
    HttpServletResponse response = ServletActionContext.getResponse();
    try {
      // path是指欲下载的文件的路径。
      File file = new File(path);
      // 取得文件名。
      String filename = file.getName();
      // 以流的形式下载文件。
      InputStream fis = new BufferedInputStream(new FileInputStream(path));
      byte[] buffer = new byte[fis.available()];
      fis.read(buffer);
      fis.close();
      // 清空response
      response.reset();
      // 设置response的Header
      String filenameString = new String(filename.getBytes("gbk"),"iso-8859-1");
      response.addHeader("Content-Disposition", "attachment;filename="+ filenameString);
      response.addHeader("Content-Length", "" + file.length());
      OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
      response.setContentType("application/octet-stream");
      toClient.write(buffer);
      toClient.flush();
      toClient.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }*/
  /**
   * 省略set get方法
   */
public File[] getFile() {
	return file;
}
public void setFile(File[] file) {
	this.file = file;
}
public String[] getFileFileName() {
	return fileFileName;
}
public void setFileFileName(String[] fileFileName) {
	this.fileFileName = fileFileName;
}
public String[] getFilePath() {
	return filePath;
}
public void setFilePath(String[] filePath) {
	this.filePath = filePath;
}
public String getDownloadFilePath() {
	return downloadFilePath;
}
public void setDownloadFilePath(String downloadFilePath) {
	this.downloadFilePath = downloadFilePath;
}
public InputStream getInputStream() {
	return inputStream;
}
public void setInputStream(InputStream inputStream) {
	this.inputStream = inputStream;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String[] getFl() {
	return fl;
}
public void setFl(String[] fl) {
	this.fl = fl;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String changePath(String path){
	String cpath=path.replace("\\", "/");
	return cpath;
}
public Informationflow getInformationflow() {
	return informationflow;
}
public void setInformationflow(Informationflow informationflow) {
	this.informationflow = informationflow;
}
public List<PhotoAllLabel> getPals() {
	return pals;
}
public void setPals(List<PhotoAllLabel> pals) {
	this.pals = pals;
}
public List<InformationflowFenlei> getFenleis() {
	return fenleis;
}
public void setFenleis(List<InformationflowFenlei> fenleis) {
	this.fenleis = fenleis;
}
public List<FenLei> getFenleisAll() {
	return fenleisAll;
}
public void setFenleisAll(List<FenLei> fenleisAll) {
	this.fenleisAll = fenleisAll;
}
public List<Label> getListYX() {
	return listYX;
}
public void setListYX(List<Label> listYX) {
	this.listYX = listYX;
}
public List<Label> getListYX1() {
	return listYX1;
}
public void setListYX1(List<Label> listYX1) {
	this.listYX1 = listYX1;
}

  
}