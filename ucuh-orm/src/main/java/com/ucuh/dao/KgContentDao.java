package com.ucuh.dao;

import com.ucuh.entity.KgContent;

import java.util.List;

public interface KgContentDao {
    //保存一天记录
	void saveKgContent(KgContent kgc);
	//通过labelId,photoId查询
	List<KgContent> findByLabelIdAndPhotoId(int labelId, int photoId);
	//删除一条记录
	void delKgContent(KgContent kgc);
	//通过id查询
	KgContent findById(int id);
	//通过photoId查询
	List<KgContent> findByPhotoId(int photoId);
}
