package com.ucuh.web.action.fabu;

import com.ucuh.dao.FenLeiDao;
import com.ucuh.dao.InformationflowDao;
import com.ucuh.dao.InformationflowFenleiDao;
import com.ucuh.dao.InformationflowRecordDao;
import com.ucuh.dao.KgContentDao;
import com.ucuh.dao.LabelDao;
import com.ucuh.dao.LabelPhotoDao;
import com.ucuh.dao.PhotoDao;
import com.ucuh.entity.FenLei;
import com.ucuh.entity.Informationflow;
import com.ucuh.entity.InformationflowFenlei;
import com.ucuh.entity.InformationflowRecord;
import com.ucuh.entity.KgContent;
import com.ucuh.entity.Label;
import com.ucuh.entity.LabelPhoto;
import com.ucuh.entity.Photo;
import com.ucuh.entity.PhotoAllLabel;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;
import com.ucuh.service.CommService;
import com.ucuh.service.FileUtilService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
@Controller
public class InformationflowAction extends HchhAction{
	@Resource FileUtilService fileUtilService;
	@Resource(name="commService")
	private CommService commService;
	
        @Resource InformationflowDao informationflowDao;
        @Resource PhotoDao photoDao;
        @Resource LabelPhotoDao lpDao;
        @Resource InformationflowFenleiDao informationflowFenleiDao;
        @Resource FenLeiDao fenleiDao;
        @Resource LabelDao labelDao;
        @Resource KgContentDao kgcDao;
        @Resource InformationflowRecordDao ifrDao;
        
        //信息流id
        private int id;
        private boolean ok=false;
        private int informationflowState;
        
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
        public String delInformationflow(){
        	//通过id查询当前信息流
        	Informationflow inff=informationflowDao.findById(id);
        	//同过信息流id查询photo的集合
        	List<Photo> photos=photoDao.findByInformationId(inff.getId());
        	for(Photo photo:photos){
        		//删除当前图片下的所有标签
        		List<LabelPhoto> lps=lpDao.findByPhotoId(photo.getId());
        		for(LabelPhoto lp1:lps){
        			lpDao.delLabelPhoto(lp1);
        		}
        		List<KgContent> kgs=kgcDao.findByPhotoId(photo.getId());
        		for(KgContent kg:kgs){
        			kgcDao.delKgContent(kg);
        		}
        		//String path1=photo.getPhotoPath();
		        //得到文件名称
		        /*if(path1!=null&&!"".equals(path1)){
		        	String[] paths=path1.split("/");
			        String fileName=paths[paths.length-1];
			        String wjj=paths[paths.length-2];
			        String userName=paths[paths.length-3];
			        String path = ServletActionContext.getServletContext().getRealPath("/upload/"+userName+"/"+wjj);
		            	String path2=path+"\\"+fileName;
		            	File file = new File(path2);
		            	if(file.exists()&&file.isFile()){
		            	file.delete();        
		            	//file.deleteOnExit();
		            	}
		            	File filewj=new File(path);
		            	if(filewj.exists()){
		            		filewj.delete();        
			            	//file.deleteOnExit();
			            }
		        }*/
        		//FileUtil.delPhoto(path1);
        		fileUtilService.delPhoto(photo);
        		photoDao.delPhoto(photo);
        	}
        	List<InformationflowFenlei> fls=informationflowFenleiDao.findByInformationflowId(inff.getId());
        	for(InformationflowFenlei fl:fls){
        		informationflowFenleiDao.delInformationflowFenlei(fl);
        	}
        	List<InformationflowRecord> ifrs=ifrDao.findByInformationflowId(inff.getId());
        	for(InformationflowRecord ifr:ifrs){
        		ifrDao.delInformationflowRecord(ifr);
        	}
        	informationflowDao.delInformationflow(inff);
        	ok=true;
        	return "success";
        }

        public String queryInformationflow(){
        	listYX=labelDao.findByTypeAndTreeCodeAsc1(0);
        	try {
        		listYX1=labelDao.findByTypeAndTreeCodeAsc2(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	//通过id来读取信息流信息
        	informationflow=informationflowDao.findById(id);
        	List<Photo> photos=photoDao.findByInformationId(informationflow.getId());
        	fenleis=informationflowFenleiDao.findByInformationflowId(id);
        	fenleisAll=fenleiDao.findAll();
        	for(Photo photo:photos){
        		PhotoAllLabel pal=new PhotoAllLabel();
            	pal.setPhoto(photo);
        		//通过信息流id查询普通标签，地点标签及额外标签
        		/**
        		 * private List<LabelPhoto> lpsPutong;
                 * private List<LabelPhoto> lpsDidian;
                 * private List<LabelPhoto> lpsEwai;
                 * private List<LabelPhoto> lpsKegou;
        		 */
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
        }
        
        //详细页面中对流程审核的操作
        public String shenheInformationflow(){
        	//通过id查询
        	Informationflow inff=informationflowDao.findById(id);
        	inff.setState(informationflowState);
        	informationflowDao.saveInformationflow(inff);
        	User user=(User) session.get("user");
        	String sh="审核通过";
        	if(informationflowState==1){
        		sh="审核通过";
        	}else{
        		sh="审核不通过";
        	}
        	commService.saveInformationflowRecord(sh, user.getUserName(),inff);
        	ok=true;
        	return "success";
        }
        
      //详细页面中对流程重新提交审核的操作
        public String chongxinShenheInformationflow(){
        	//通过id查询
        	Informationflow inff=informationflowDao.findById(id);
        	inff.setState(informationflowState);
        	informationflowDao.saveInformationflow(inff);
        	User user=(User) session.get("user");
        	
        	commService.saveInformationflowRecord("重新提交审核", user.getUserName(),inff);
        	ok=true;
        	return "success";
        }
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public boolean isOk() {
			return ok;
		}

		public void setOk(boolean ok) {
			this.ok = ok;
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

		public int getInformationflowState() {
			return informationflowState;
		}

		public void setInformationflowState(int informationflowState) {
			this.informationflowState = informationflowState;
		}

		
		
        
}
