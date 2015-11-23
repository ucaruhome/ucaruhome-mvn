package com.ucuh.dao;

import com.ucuh.entity.User;

import java.util.List;

public interface UserDao {
       //通过用户名和密码查询用户
	   User findUser(String userName, String password, String password1);
	//查询所有的管理员用户的条数
	int findUsersCount(int roleId);
	   //查询所有的管理员用户
	   List<User> findUsers(int roleId, int count, int nowPage, int maxPage, int maxPageCount);
	
	//保存一个user
	void savaOrUpdateUser(User user);
	//通过userId查询user
	User findById(int userId);
	//删除一个user
	void delUser(User user);
	//查询所有待认证的用户
	int findUsersAllCount(int headPhotoRZ);
	List<User> findUsersAll(int headPhotoRZ, int count, int nowPage, int maxPage, int maxPageCount);
	//通过用户名查询
	List<User>  findByUserName(String userName);
	//通过designer查询
	int findUserAllCountByDesigner(int designer);
	List<User> findUsersAllByDesigner(int designer, int count, int nowPage, int maxPage, int maxPageCount);
	
	//审核有结果的designer
	int findUserAllCountByDesignerOver();
	List<User> findUsersAllByDesignerOver(int count, int nowPage, int maxPage, int maxPageCount);
	
	//通过supplier查询
	int findUserAllCountBySupplier(int supplier);
	List<User> findUsersAllBySupplier(int supplier, int count, int nowPage, int maxPage, int maxPageCount);
	
	//审核有结果的supplier
	int findUserAllCountBySupplierOver();
	List<User> findUsersAllBySupplierOver(int count, int nowPage, int maxPage, int maxPageCount);
	//通过手机号码查询用户
	List<User> findByPhone(String phone);
	//通过手机号码和密码查询
	User findUserByPhoneAndPassword(String phone, String password, String password1);
}
