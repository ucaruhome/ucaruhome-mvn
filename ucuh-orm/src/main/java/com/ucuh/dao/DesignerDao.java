package com.ucuh.dao;

import com.ucuh.entity.Designer;

import java.util.List;

public interface DesignerDao {
   //保存一天设计师记录
   void saveDesigner(Designer designer);
   //查询设计师里除了取消认证以外的该用户下的所有设计师认证state!=4
   List<Designer> findByUserIdYQX(int userId);
   //根据用户id和状态查询
   List<Designer> findByUserIdAndState(int userId, int state);
	//通过userId查询
	Designer findByUserId(int userId);
}
