package com.ucuh.dao;

import com.ucuh.entity.Group;

import java.util.List;


public interface GroupDao {
	    //获取所有的角色信息
		List<Group> findGroups();
	    //通过id查询Group
		Group findByID(int id);
	    //通过name查询
		Group findByGroupName(String groupName);
}
