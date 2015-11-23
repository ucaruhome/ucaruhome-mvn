package com.ucuh.dao;

import com.ucuh.entity.Photo;

import java.util.List;

public interface PhotoDao {
  //保存一个图片信息
  void savePhoto(Photo photo);
  //通过信息流Id查询所有图片
  List<Photo> findByInformationId(int informationId);
  //删除一个照片信息
  void delPhoto(Photo photo);
  //通过id查询Photo
  Photo findById(int photoId);
}
