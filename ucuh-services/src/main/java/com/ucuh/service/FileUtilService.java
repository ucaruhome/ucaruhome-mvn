package com.ucuh.service;

import com.ucuh.entity.Label;
import com.ucuh.entity.News;
import com.ucuh.entity.Photo;
import com.ucuh.entity.User;

import java.io.File;
import java.util.Date;

public interface FileUtilService {
	//手机上传用户头像文件返回url和一个删除标记
	String[] uploadHeadPhoto(User user, String file, String photoType);
	//后台用户头像的上传
	String[] uploadHeadPhotoAdmin(User user, File f, String fileName);
	//上传图片
	String[] uploadPhoto(User user, File f, String fileName, Date date);
	//删除图片
	void delPhoto(Photo photo);
	//标签封面的上传
	String[] uploadLabelPhoto(File f, String fileName);
	//删除标签封面
	void delLabelPhoto(Label label);
	//上传消息发布页面的封面图片
	String[] uploadNewsFenMianPhoto(File f, String fileName);
	//删除消息的封面图片
	void delNewsFenMianPhoto(News news);

}
