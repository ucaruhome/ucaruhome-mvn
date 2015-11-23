package com.ucuh.dao;

import com.ucuh.entity.Quanwudingzhi;

import java.util.List;

public interface QuanwudingzhiDao {
  //分页查询
  int findQuanwudingzhiAllCount();
	List<Quanwudingzhi> findQuanwudingzhiAll(int count, int nowPage, int maxPage, int maxPageCount);
}
