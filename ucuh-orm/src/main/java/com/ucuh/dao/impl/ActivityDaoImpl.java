package com.ucuh.dao.impl;

import com.ucuh.dao.ActivityDao;
import com.ucuh.entity.Activity;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ActivityDaoImpl implements ActivityDao{
	@Resource SessionFactory factory;
	
	//@Transactional(propagation=Propagation.REQUIRED)添加事务处理
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveActivity(Activity activity) {
		factory.getCurrentSession().saveOrUpdate(activity);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Activity findById(int activityId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Activity where id="+activityId;
		Query query=session.createQuery(hql);
		Activity activity=(Activity) query.uniqueResult();
		return activity;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Activity findByDesignerId(int DesignerId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Activity a where a.designerId="+DesignerId;
		Query query=session.createQuery(hql);
		List<Activity> as=query.list();
		Activity activity=new Activity();
		if(as.size()!=0){
			activity=as.get(0);
		}
		
		return activity;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Activity findBySupplierId(int SupplierId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Activity a where a.supplierId="+SupplierId;
		Query query=session.createQuery(hql);
		List<Activity> as=query.list();
		Activity activity=new Activity();
		if(as.size()!=0){
			activity=as.get(0);
		}
		
		return activity;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Activity findByDistributorId(int DistributorId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Activity a where a.distributorId="+DistributorId;
		Query query=session.createQuery(hql);
		List<Activity> as=query.list();
		Activity activity=new Activity();
		if(as.size()!=0){
			activity=as.get(0);
		}
		
		return activity;
	}

}
