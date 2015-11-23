package com.ucuh.dao.impl;

import com.ucuh.dao.KgContentDao;
import com.ucuh.entity.KgContent;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class KgContentDaoImpl implements KgContentDao {
	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveKgContent(KgContent kgc) {
		factory.getCurrentSession().saveOrUpdate(kgc);

	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<KgContent> findByLabelIdAndPhotoId(int labelId, int photoId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from KgContent kg where kg.photo.id="+photoId+" and kg.label.id="+labelId;
		Query query=session.createQuery(hql);
		List<KgContent> kgs=query.list();
		return kgs;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delKgContent(KgContent kgc) {
		factory.getCurrentSession().delete(kgc);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public KgContent findById(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from KgContent kg where kg.id="+id;
		Query query=session.createQuery(hql);
		KgContent kgc=(KgContent) query.uniqueResult();
		return kgc;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<KgContent> findByPhotoId(int photoId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from KgContent kg where kg.photo.id="+photoId;
		Query query=session.createQuery(hql);
		List<KgContent> kgs=query.list();
		return kgs;
	}

}
