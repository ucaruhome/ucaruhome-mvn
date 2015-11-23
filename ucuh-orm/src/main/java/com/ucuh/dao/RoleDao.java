package com.ucuh.dao;

import com.ucuh.entity.Role;

import java.util.List;


public interface RoleDao {
        //通过用户的名称查询角色信息
		Role findRole(String roleName);
	    //获取所有的角色信息
		List<Role> findRoles();
	    //通过id查询角色
		Role findByID(int roleId);
}
