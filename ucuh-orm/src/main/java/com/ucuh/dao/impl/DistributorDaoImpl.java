package com.ucuh.dao.impl;

import com.ucuh.dao.DistributorDao;
import com.ucuh.entity.Distributor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DistributorDaoImpl implements DistributorDao {
	@Resource SessionFactory factory;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveDistributor(Distributor distributor) {
		factory.getCurrentSession().saveOrUpdate(distributor);

	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Distributor> findByUserIdAndState(int userId, int state) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Distributor d where d.user.id="+userId+" and d.state="+state;
		Query query=session.createQuery(hql);
		List<Distributor> ds=new ArrayList<Distributor>();
		ds=query.list();
		
		return ds;
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Distributor> findByUserIdYQX(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Distributor d where d.user.id="+userId+" and d.state !=4 and d.state is not null";
		Query query=session.createQuery(hql);
		List<Distributor> ds=new ArrayList<Distributor>();
		ds=query.list();
		
		return ds;
		
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Distributor findByUserId(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Distributor d where d.user.id="+userId;
		Query query=session.createQuery(hql);
		List<Distributor> ds=new ArrayList<Distributor>();
		ds=query.list();
		Distributor d=new Distributor();
		if(ds.size()!=0){
			d=ds.get(0);
		}
		return d;
	}

}
