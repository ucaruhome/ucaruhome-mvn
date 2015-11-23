package com.ucuh.dao;

import com.ucuh.entity.ReportInformation;

import java.util.List;

public interface ReportInformationDao {
    //分页
	int findReportInformationAllCount();
	List<ReportInformation> findReportInformationAll(int count, int nowPage, int maxPage, int maxPageCount);
	//删除
	void delReportInformationflow(ReportInformation rif);
	//通过id查询
	ReportInformation findById(int id);
	//保存
	void saveReportInformation(ReportInformation rif);
}
