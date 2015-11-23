package com.ucuh.dao;

import com.ucuh.entity.Activity;

public interface ActivityDao {
  //保存一个活动信息信息
  void saveActivity(Activity activity);
  //通过id查询
  Activity findById(int activityId);
  //通过designerId查询
  Activity findByDesignerId(int DesignerId);
  //通过supplierId查询
  Activity findBySupplierId(int SupplierId);
  //通过DistributorId查询
  Activity findByDistributorId(int DistributorId);
  
}
