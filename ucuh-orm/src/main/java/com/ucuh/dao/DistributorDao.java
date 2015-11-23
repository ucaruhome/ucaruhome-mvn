package com.ucuh.dao;

import com.ucuh.entity.Distributor;

import java.util.List;

public interface DistributorDao {
   //保存一天设计师记录
   void saveDistributor(Distributor distributor);
   //查询设计师里除了取消认证以外的该用户下的所有设计师认证state!=4
   List<Distributor> findByUserIdYQX(int userId);
   //根据用户id和状态查询
   List<Distributor> findByUserIdAndState(int userId, int state);
	//通过userId查询
	Distributor findByUserId(int userId);
}
