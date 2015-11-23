package com.ucuh.dao;

import com.ucuh.entity.InformationflowFenlei;

import java.util.List;

public interface InformationflowFenleiDao {

	//通过information查询
	List<InformationflowFenlei> findByInformationflowId(int informationflowId);
	//通过informationflowId,fenleiId查询InformationflowFenlei
	List<InformationflowFenlei> findByinformationflowIdAndfenleiId(int informationflowId, int fenleiId);
	//保存更新一条InformationflowFenlei信息
	void saveInformationflowFenlei(InformationflowFenlei ff);
	//通过informtionFlowId，fenleiId删除
	void delInformationflowFenlei(InformationflowFenlei ff);
	
}
