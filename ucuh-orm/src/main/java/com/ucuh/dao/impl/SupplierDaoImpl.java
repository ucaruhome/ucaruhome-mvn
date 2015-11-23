package com.ucuh.dao.impl;

import com.ucuh.dao.SupplierDao;
import com.ucuh.entity.Supplier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class SupplierDaoImpl implements SupplierDao {
	@Resource SessionFactory factory;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveSupplier(Supplier supplier) {
		factory.getCurrentSession().saveOrUpdate(supplier);

	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Supplier> findByUserIdAndState(int userId, int state) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Supplier s where s.user.id="+userId+" and s.state="+state;
		Query query=session.createQuery(hql);
		List<Supplier> ds=new ArrayList<Supplier>();
		ds=query.list();
		
		return ds;
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Supplier> findByUserIdYQX(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Supplier s where s.user.id="+userId+" and s.state !=4 and d.state is not null";
		Query query=session.createQuery(hql);
		List<Supplier> ds=new ArrayList<Supplier>();
		ds=query.list();
		
		return ds;
		
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Supplier findByUserId(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Supplier s where s.user.id="+userId;
		Query query=session.createQuery(hql);
		List<Supplier> ds=new ArrayList<Supplier>();
		ds=query.list();
		Supplier d=new Supplier();
		if(ds.size()!=0){
			d=ds.get(0);
		}
		return d;
	}

}
