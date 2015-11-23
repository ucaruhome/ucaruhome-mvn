package com.ucuh.dao;

import com.ucuh.entity.FenLei;

import java.util.List;

public interface FenLeiDao {

	//读取大的分类list
	List<FenLei> findAll();
	//通过id查询
	FenLei findById(int id);
}
