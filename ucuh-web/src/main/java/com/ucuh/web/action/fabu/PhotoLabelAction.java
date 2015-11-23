package com.ucuh.web.action.fabu;

import com.ucuh.util.HchhUtil;
import com.ucuh.dao.KgContentDao;
import com.ucuh.dao.LabelDao;
import com.ucuh.dao.LabelPhotoDao;
import com.ucuh.dao.PhotoDao;
import com.ucuh.entity.KgContent;
import com.ucuh.entity.Label;
import com.ucuh.entity.LabelPhoto;
import com.ucuh.entity.Photo;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class PhotoLabelAction extends HchhAction{
	@Resource LabelDao labelDao;
	@Resource PhotoDao photoDao;
	@Resource LabelPhotoDao labelPhotoDao;
	@Resource KgContentDao kgcDao;
//==========================新增一个可购标签=======================================================
	//input
	private String photoId;
	private String labelId;
	private String labelTagName;
	private String kglx;
	private String kglxContent;
	//output
	private int ok=0;
	private int labelPhotoId;
//==============================删除一个可购标签=====================================================
	//output
	//private ok=0;
	//private int labelPhotoId;
//==============================编辑可购标签中的地址=================================================
	private Label kglabel=new Label();
	private List<KgContent> kgcs=new ArrayList<KgContent>();
//==============================保存可购标签中的地址======================================================
	private String kgcIds;
	private String strs;
	private String strContents;
	//增加一个可购标签
	public String addKGLabel(){
		try{
		if("".equals(labelTagName)){
			ok=1;
		}else{
			if("".equals(labelId)){
				//新增一个可购标签并将其添加到图片标签中去
				Label labelParent=labelDao.findByTPG(2, 0, 0);
				Label labelnew=new Label();
				labelnew.setDateTime(new Date());
				labelnew.setTagName(labelTagName);
				labelnew.setType(2);
				labelnew.setGrade(1);
				labelnew.setParentId(labelParent.getId());
				labelnew.setTypeT(2);
				labelDao.saveLabel(labelnew);
				//1.根据id来保存treeCode
				labelnew.setTreeCode(labelParent.getTreeCode()+"-"+labelnew.getId());
				//2.通过photoId得到图片，并将标签保存到图片中去
				Photo photo=photoDao.findById(Integer.parseInt(photoId));
				LabelPhoto lp=new LabelPhoto();
				lp.setHchhLabel(labelnew);
				lp.setHchhPhoto(photo);
				lp.setTime(new Date());
				labelPhotoDao.saveLabelPhoto(lp);
				//将标签中名称添加到photo的备注中去
				String bStr=""+photo.getRemark()+","+labelnew.getTagName();
			    photo.setRemark(bStr);
			    photoDao.savePhoto(photo);
				labelPhotoId=lp.getId();
				//3.将标签中照片数量改变
				int photoNum=0;
				if(labelnew.getPhotoNum()!=null){
					photoNum=labelnew.getPhotoNum();
				}
				labelnew.setPhotoNum(photoNum+1);
				labelDao.saveLabel(labelnew);
				//3.将标签的可购类型保存
				KgContent kgc=new KgContent();
				kgc.setLabel(labelnew);
				kgc.setPhoto(photo);
				kgc.setKgType(Integer.parseInt(kglx));
				kgc.setContent(kglxContent);
				kgc.setTime(new Date());
				kgcDao.saveKgContent(kgc);
			}else{
				//查询这个可购标签并将其添加到图片标签中去
				Label labelnew=labelDao.findByID(Integer.parseInt(labelId));
				//2.通过photoId得到图片，并将标签保存到图片中去
				Photo photo=photoDao.findById(Integer.parseInt(photoId));
				LabelPhoto lp=new LabelPhoto();
				lp.setHchhLabel(labelnew);
				lp.setHchhPhoto(photo);
				lp.setTime(new Date());
				labelPhotoDao.saveLabelPhoto(lp);
				//将标签中名称添加到photo的备注中去
				String bStr=""+photo.getRemark()+","+labelnew.getTagName();
			    photo.setRemark(bStr);
			    photoDao.savePhoto(photo);
				labelPhotoId=lp.getId();
				//3.将标签中照片数量改变
				int photoNum=0;
				if(labelnew.getPhotoNum()!=null){
					photoNum=labelnew.getPhotoNum();
				}
				labelnew.setPhotoNum(photoNum+1);
				labelDao.saveLabel(labelnew);
				//3.将标签的可购类型保存
				KgContent kgc=new KgContent();
				kgc.setLabel(labelnew);
				kgc.setPhoto(photo);
				kgc.setKgType(Integer.parseInt(kglx));
				kgc.setContent(kglxContent);
				kgc.setTime(new Date());
				kgcDao.saveKgContent(kgc);
			}
			ok=2;
		}
		}catch (Exception e) {
			e.printStackTrace();
			ok=0;
		}
		
		return "success";
	}
//删除可购标签
	public String delKGLabel(){
		/**
		 * 1.删除相关的地址
		 * 2.标签中的照片数量减去1
		 * 3.删除可购标签
		 */
		try{
		LabelPhoto lp=labelPhotoDao.findById(labelPhotoId);
		
		List<KgContent> kgs=kgcDao.findByLabelIdAndPhotoId(lp.getHchhLabel().getId(), lp.getHchhPhoto().getId());
		for(KgContent kgc:kgs){
			kgcDao.delKgContent(kgc);
		}
		Label label1=lp.getHchhLabel();
		int photoNum=1;
		photoNum=label1.getPhotoNum();
		label1.setPhotoNum(photoNum-1);
		labelDao.saveLabel(label1);
		labelPhotoDao.delLabelPhoto(lp);
		//得到当前图片下的所有标签
		List<LabelPhoto> lps=labelPhotoDao.findByPhotoId(lp.getHchhPhoto().getId());
		//HchhUtil hu=new HchhUtil();
		String strs=HchhUtil.getLabelPhotos(lps);
		Photo ph=lp.getHchhPhoto();
		ph.setRemark(strs);
		photoDao.savePhoto(ph);
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=0;
		}
		return "success";
	}
	
//编辑可购标签中的地址
	public String editAddress(){
		LabelPhoto lp=labelPhotoDao.findById(labelPhotoId);
		kgcs=kgcDao.findByLabelIdAndPhotoId(lp.getHchhLabel().getId(), lp.getHchhPhoto().getId());
		kglabel=lp.getHchhLabel();
		return "success";
	}
//保存可购标签中的地址信息
	public String saveAddress(){
		/**
		 * kgcIds;strs;strContents;
		 */
		try{
		String[] kgcIdss=kgcIds.split(",");
		String[] strss=strs.split(",");
		String[] strContentss=strContents.split(",");
		//System.out.println(kgcIdss.length);
		//System.out.println(strss.length);
		//System.out.println(strContentss.length);
		for(int i=0;i<kgcIdss.length;i++){
			//通过id查询
			KgContent kgc1=kgcDao.findById(Integer.parseInt(kgcIdss[i]));
			kgc1.setContent(strContentss[i]);
			kgc1.setKgType(Integer.parseInt(strss[i]));
			kgcDao.saveKgContent(kgc1);
		}
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=0;
		}
		return "success";
	}

	public String getPhotoId() {
		return photoId;
	}


	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}


	public String getLabelId() {
		return labelId;
	}


	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}


	public String getLabelTagName() {
		return labelTagName;
	}


	public void setLabelTagName(String labelTagName) {
		this.labelTagName = labelTagName;
	}


	public String getKglx() {
		return kglx;
	}


	public void setKglx(String kglx) {
		this.kglx = kglx;
	}


	public String getKglxContent() {
		return kglxContent;
	}


	public void setKglxContent(String kglxContent) {
		this.kglxContent = kglxContent;
	}


	public int getOk() {
		return ok;
	}


	public void setOk(int ok) {
		this.ok = ok;
	}


	public int getLabelPhotoId() {
		return labelPhotoId;
	}


	public void setLabelPhotoId(int labelPhotoId) {
		this.labelPhotoId = labelPhotoId;
	}
	public Label getKglabel() {
		return kglabel;
	}
	public void setKglabel(Label kglabel) {
		this.kglabel = kglabel;
	}
	public List<KgContent> getKgcs() {
		return kgcs;
	}
	public void setKgcs(List<KgContent> kgcs) {
		this.kgcs = kgcs;
	}
	public String getKgcIds() {
		return kgcIds;
	}
	public void setKgcIds(String kgcIds) {
		this.kgcIds = kgcIds;
	}
	public String getStrs() {
		return strs;
	}
	public void setStrs(String strs) {
		this.strs = strs;
	}
	public String getStrContents() {
		return strContents;
	}
	public void setStrContents(String strContents) {
		this.strContents = strContents;
	}
	
	
}
