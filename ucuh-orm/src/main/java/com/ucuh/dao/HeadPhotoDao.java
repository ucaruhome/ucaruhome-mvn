package com.ucuh.dao;

import com.ucuh.entity.Headphoto;

import java.util.List;

public interface HeadPhotoDao {
        //保存一个上传的图片信息
		void saveOrUpdateHeadPhoto(Headphoto hp);
	    //通过id查询Headphoto
		Headphoto findByID(int photoId);
	    //通过userId，headPhotoState查询
		List<Headphoto> findByUseridAndHeadphotostate(int userId, int headPhotoState);
	  //通过userId查询
	  List<Headphoto> findByUserid(int userId);
}
