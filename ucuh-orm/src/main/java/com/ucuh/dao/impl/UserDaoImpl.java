package com.ucuh.dao.impl;

import com.ucuh.dao.UserDao;
import com.ucuh.entity.User;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao{
	@Resource SessionFactory factory;
	
	//@Transactional(propagation=Propagation.REQUIRED)添加事务处理
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User findUser(String userName, String password, String password1) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.userName like '"+userName+"' and (password like '"+password+"' or password like '"+password1+"')";
		Query query=session.createQuery(hql);
//		query.setString(0, userName);
//		query.setString(1, password);
		User user=(User) query.uniqueResult();
		return user;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findUsers(int roleId,int count,int nowPage,int maxPage,int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.role.id="+roleId;
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<User> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findUsersCount(int roleId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from User u where u.role.id="+roleId;
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void savaOrUpdateUser(User user) {
		factory.getCurrentSession().saveOrUpdate(user);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User findById(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.id="+userId;
		Query query=session.createQuery(hql);
		User user=(User) query.uniqueResult();
		return user;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delUser(User user) {
		factory.getCurrentSession().delete(user);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findUsersAll(int headPhotoRZ, int count, int nowPage,
			int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.headPhotoRZ="+headPhotoRZ;
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<User> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findUsersAllCount(int headPhotoRZ) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from User u where u.headPhotoRZ="+headPhotoRZ;
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findByUserName(String userName) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.userName like '"+userName+"'";
		Query query=session.createQuery(hql);
		List<User> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findUserAllCountByDesigner(int designer) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from User u where u.designer="+designer;
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findUsersAllByDesigner(int designer, int count,
			int nowPage, int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.designer="+designer;
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<User> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findUserAllCountByDesignerOver() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from User u where u.designer=2 or u.designer=3 or u.designer=4";
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findUsersAllByDesignerOver(int count, int nowPage,
			int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.designer=2 or u.designer=3 or u.designer=4";
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<User> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findUserAllCountBySupplier(int supplier) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from User u where u.supplier="+supplier;
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findUsersAllBySupplier(int supplier, int count,
			int nowPage, int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.supplier="+supplier;
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<User> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findUserAllCountBySupplierOver() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from User u where u.supplier=2 or u.supplier=3 or u.supplier=4";
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findUsersAllBySupplierOver(int count, int nowPage,
			int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.supplier=2 or u.supplier=3 or u.supplier=4";
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<User> list=query.list();
		
		return list;
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<User> findByPhone(String phone) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.phone like '"+phone+"'";
		Query query=session.createQuery(hql);
		List<User> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User findUserByPhoneAndPassword(String phone, String password,
			String password1) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from User u where u.phone like '"+phone+"' and (password like '"+password+"' or password like '"+password1+"')";
		Query query=session.createQuery(hql);
//		query.setString(0, userName);
//		query.setString(1, password);
		User user=(User) query.uniqueResult();
		return user;
	}

}
