package com.ucuh.dao.impl;

import com.ucuh.dao.InformationflowFenleiDao;
import com.ucuh.entity.InformationflowFenlei;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class InformationflowFenleiDaoImpl implements InformationflowFenleiDao {
    @Resource SessionFactory factory;



	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<InformationflowFenlei> findByInformationflowId(
			int informationflowId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from InformationflowFenlei ff where ff.informationflow.id="+informationflowId;
		Query query=session.createQuery(hql);
		List<InformationflowFenlei> list=query.list();
		return list;
	}



	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<InformationflowFenlei> findByinformationflowIdAndfenleiId(
			int informationflowId, int fenleiId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from InformationflowFenlei ff where ff.informationflow.id="+informationflowId+" and ff.fenLei.id="+fenleiId;
		Query query=session.createQuery(hql);
		List<InformationflowFenlei> list=query.list();
		return list;
	}



	@Transactional(propagation=Propagation.REQUIRED)
	public void saveInformationflowFenlei(InformationflowFenlei ff) {
		factory.getCurrentSession().saveOrUpdate(ff);
		
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public void delInformationflowFenlei(InformationflowFenlei ff) {
		factory.getCurrentSession().delete(ff);
		
	}}
