package com.ucuh.dao;

import com.ucuh.entity.Supplier;

import java.util.List;

public interface SupplierDao {
   //保存一天供应商记录
   void saveSupplier(Supplier supplier);
   //查询供应商里除了取消认证以外的该用户下的所有供应商认证state!=4
   List<Supplier> findByUserIdYQX(int userId);
   //根据用户id和状态查询
   List<Supplier> findByUserIdAndState(int userId, int state);
	//通过userId查询
	Supplier findByUserId(int userId);
}
