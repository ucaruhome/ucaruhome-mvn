package com.ucuh.dao;

import com.ucuh.entity.LabelPhoto;

import java.util.List;

public interface LabelPhotoDao {
	 //通过图片id,标签类型来查询标签
	 List<LabelPhoto> findByIdAndTypet(int photoId, int labelTypet);
	//通过图片id，标签类型来查询--一个图片的所有普通标签labelTypet=0
	List<LabelPhoto> findByIdAndTypet1(int photoId, int labelTypet);
	//保存
	void saveLabelPhoto(LabelPhoto lp);
	//根据photoId,labelId查询
	List<LabelPhoto> findByPhotoIdAndLabelId(int photoId, int labelId);
	//通过id查询
	LabelPhoto findById(int id);
	//删除
	void delLabelPhoto(LabelPhoto lp);
	//通过photoId查询
	List<LabelPhoto> findByPhotoId(int photoId);
	//通过标签查询所有的photo个数
	int findPhotosCountByLabelId(int labelId);
	//通过标签对photo分页查询
	List<LabelPhoto> findPhotosByLabelId(int labelId, int count, int nowPage, int maxPage, int maxPageCount);
	
}
