package com.ucuh.entity;

import java.util.Date;

/**
 * 标签表
 */

public class Label implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tagName;
	private Integer parentId;
	private Integer grade;
	private String remark;
	/*private Set labelPhotos = new HashSet(0);*/
    //新增    2015-09-21
	private Integer type;
	private String treeCode;
	private Date dateTime;
	private String photoPath;
	private Integer photoNum;
	// Constructors

	//0:普通标签；1：地点标签；2：可购标签 ;3:额外添加标签
	private Integer typeT;
	
	
	//20151119  cck
	private String remark1;
	private String remark2;
	/** default constructor */
	public Label() {
	}

	/** full constructor */
	public Label(String tagName, Integer parentId, Integer grade,
			String remark,Integer type,String treeCode,Date dateTime,String photoPath,Integer photoNum,Integer typeT,String remark1,String remark2) {
		this.tagName = tagName;
		this.parentId = parentId;
		this.grade = grade;
		this.remark = remark;
		this.type=type;
		this.treeCode=treeCode;
		this.dateTime=dateTime;
		this.photoPath=photoPath;
		this.photoNum=photoNum;
		this.typeT=typeT;
		this.remark1=remark1;
		this.remark2=remark2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(Integer photoNum) {
		this.photoNum = photoNum;
	}

	public Integer getTypeT() {
		return typeT;
	}

	public void setTypeT(Integer typeT) {
		this.typeT = typeT;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/*public Set getLabelPhotos() {
		return this.labelPhotos;
	}

	public void setLabelPhotos(Set labelPhotos) {
		this.labelPhotos = labelPhotos;
	}*/

}