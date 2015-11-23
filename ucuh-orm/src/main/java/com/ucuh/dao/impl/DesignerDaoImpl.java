package com.ucuh.dao.impl;

import com.ucuh.dao.DesignerDao;
import com.ucuh.entity.Designer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DesignerDaoImpl implements DesignerDao {
	@Resource SessionFactory factory;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveDesigner(Designer designer) {
		factory.getCurrentSession().saveOrUpdate(designer);

	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Designer> findByUserIdAndState(int userId, int state) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Designer d where d.user.id="+userId+" and d.state="+state;
		Query query=session.createQuery(hql);
		List<Designer> ds=new ArrayList<Designer>();
		ds=query.list();
		
		return ds;
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Designer> findByUserIdYQX(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Designer d where d.user.id="+userId+" and d.state !=4 and d.state is not null";
		Query query=session.createQuery(hql);
		List<Designer> ds=new ArrayList<Designer>();
		ds=query.list();
		
		return ds;
		
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Designer findByUserId(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Designer d where d.user.id="+userId;
		Query query=session.createQuery(hql);
		List<Designer> ds=new ArrayList<Designer>();
		ds=query.list();
		Designer d=new Designer();
		if(ds.size()!=0){
			d=ds.get(0);
		}
		return d;
	}

}
