package com.ucuh.dao;

import com.ucuh.entity.News;

import java.util.List;

public interface NewsDao {
    //查询所有的news
	List<News> findNewsAll();
	//保存更新一个news信息
	void saveNews(News news);
	//删除一个news信息
	void delNews(News news);
	//通过id查询
	News findById(int id);
	//分页查询
	int findAllCount();
	List<News> findAll(int count, int nowPage, int maxPage, int maxPageCount);
 }
