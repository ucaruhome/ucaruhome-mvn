package com.ucuh.dao;

import com.ucuh.entity.InformationflowRecord;

import java.util.List;

public interface InformationflowRecordDao {
 //保存一条操作记录
 void saveInformationflowRecord(InformationflowRecord ifr);
 //根据信息流的id查询
 List<InformationflowRecord> findByInformationflowId(int informationflowId);
 //删除
 void delInformationflowRecord(InformationflowRecord ifr);
}
