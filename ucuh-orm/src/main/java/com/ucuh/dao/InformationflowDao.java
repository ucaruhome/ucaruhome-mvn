package com.ucuh.dao;

import com.ucuh.entity.Informationflow;

import java.util.List;

public interface InformationflowDao {
     //保存一个信息流
	 void saveInformationflow(Informationflow inf);
	//通过审核状态查询信息流
	List<Informationflow> findByState(int state, int count, int nowPage, int maxPage, int maxPageCount);
	int findByStateCount(int state);
	//通过id查询当前信息流
	Informationflow findById(int id);
	//删除一个信息流信息
	void delInformationflow(Informationflow inff);
}
