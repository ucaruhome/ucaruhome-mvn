package com.ucuh.dao.impl;

import com.ucuh.dao.FenLeiDao;
import com.ucuh.entity.FenLei;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class FenLeiDaoImpl implements FenLeiDao {
@Resource SessionFactory factory;
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<FenLei> findAll() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from FenLei";
		Query query=session.createQuery(hql);
		List<FenLei> list=query.list();
		return list;
	}


	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public FenLei findById(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from FenLei fl where fl.id="+id;
		Query query=session.createQuery(hql);
		FenLei fl=(FenLei) query.uniqueResult();
		return fl;
	}

}
