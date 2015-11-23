package com.ucuh.web.action.label;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.LabelDao;
import com.ucuh.dao.LabelPhotoDao;
import com.ucuh.dao.PhotoDao;
import com.ucuh.entity.Label;
import com.ucuh.entity.LabelPhoto;
import com.ucuh.entity.Photo;
import com.ucuh.web.action.HchhAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 *
 */
@Controller
public class LabelCommonAction extends HchhAction{
	@Resource LabelDao labelDao;
	@Resource PhotoDao photoDao;
	@Resource LabelPhotoDao lpDao;
	//输入数据
	private int id;
	//读取数据返回(系统标签的列表)
    private List<Label> listYX=new ArrayList<Label>();
    private Label label=new Label(); 
    //=============将自定义标签添加到系统标签=============================
    private int xuanzexiang;
    private boolean ok=false;
	//================发布管理中的新增标签页面============================
    private int photoId;
    
    private int labelPhotoId;
    private String tagName;
    private String tagType;
	public String xiTongLabelSelect() throws IOException{
		label=labelDao.findByID(id);
		listYX=labelDao.findByTypeAndTreeCodeAsc(0);
		return "success";
	}
	//此方法得到发布管理中的新增标签页面
	public String xiTongLabelSelect1() throws IOException{
		listYX=labelDao.findByTypeAndTreeCodeAsc1(0);
		return "success";
	}

	public String xiTongLabelSave(){
		label=labelDao.findByID(id);
		Label label1=labelDao.findByID(xuanzexiang);
		if(label1==null){
			ok=false;
		}else{
		//将自定义标签转变成当前选择的系统标签下的子标签
		//type=0,treeCode=treeCode1（系统标签）+treeCode2(自定义标签），grade=grade1(系统标签)+1,parentId=自定义标签id
		label.setType(0);
		label.setTreeCode(label1.getTreeCode()+"-"+label.getId());
		label.setGrade(label1.getGrade()+1);
		label.setParentId(label1.getId());
		labelDao.saveLabel(label);
		ok=true;
	}
		return "success";
	}
	//发布管理---标签新增
	public String xiTongLabelAdd(){
		//判断当前标签是否已经在改图片中
		List<LabelPhoto> list=lpDao.findByPhotoIdAndLabelId(photoId, xuanzexiang);
		if(list.size()==0){
			/**
			 * xuanzexiang,标签的id
			 * photoId,图片的id
			 */
			Label label=labelDao.findByID(xuanzexiang);//得到对应的标签
			Photo photo=photoDao.findById(photoId);
			//在备注中添加标签名称
			String bStr=""+photo.getRemark()+","+label.getTagName();
		    photo.setRemark(bStr);
		    photoDao.savePhoto(photo);
			LabelPhoto lp=new LabelPhoto();
			lp.setHchhLabel(label);
			lp.setHchhPhoto(photo);
			lp.setTime(new Date());
			lpDao.saveLabelPhoto(lp);
			labelPhotoId=lp.getId();
			tagName=lp.getHchhLabel().getTagName();
			Integer type=lp.getHchhLabel().getTypeT();
			if(type==null){
				tagType="普通标签";
			}else if(type==1){
				tagType="地点标签";
			}else if(type==2){
				tagType="可购标签";
			}else if(type==3){
				tagType="额外标签";
			}else{
				tagType="普通标签";
			}
			ok=true;
			int photoNum=0;
			if(label.getPhotoNum()!=null){
				photoNum=label.getPhotoNum();
			}
			label.setPhotoNum(photoNum+1);
			labelDao.saveLabel(label);
		}else{
		    ok=false;
		}
		return "success";
	}

	//删除一个标签
	public String xiTongLabelDel(){
		LabelPhoto lp=lpDao.findById(labelPhotoId);
		lpDao.delLabelPhoto(lp);
		//得到当前图片下的所有标签
		List<LabelPhoto> lps=lpDao.findByPhotoId(lp.getHchhPhoto().getId());
		//HchhUtil hu=new HchhUtil();
		String strs=HchhUtil.getLabelPhotos(lps);
		Photo ph=lp.getHchhPhoto();
		ph.setRemark(strs);
		photoDao.savePhoto(ph);
		Label label1=lp.getHchhLabel();
		int photoNum=1;
		photoNum=label1.getPhotoNum();
		label1.setPhotoNum(photoNum-1);
		labelDao.saveLabel(label1);
		ok=true;
		return "success";
	}
	public String xiTongLabelCommon(){
		listYX=labelDao.findByTypeAndTreeCodeAsc(0);
		return "success";
	}
	public List<Label> getListYX() {
		return listYX;
	}

	public void setListYX(List<Label> listYX) {
		this.listYX = listYX;
	}



	public Label getLabel() {
		return label;
	}



	public void setLabel(Label label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getXuanzexiang() {
		return xuanzexiang;
	}

	public void setXuanzexiang(int xuanzexiang) {
		this.xuanzexiang = xuanzexiang;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	public int getLabelPhotoId() {
		return labelPhotoId;
	}
	public void setLabelPhotoId(int labelPhotoId) {
		this.labelPhotoId = labelPhotoId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	

	
	
	
}
