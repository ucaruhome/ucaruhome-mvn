package com.ucuh.dao.impl;

import com.ucuh.dao.PhotoDao;
import com.ucuh.entity.Photo;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PhotoDaoImpl implements PhotoDao {
	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void savePhoto(Photo photo) {
		factory.getCurrentSession().saveOrUpdate(photo);

	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Photo> findByInformationId(int informationId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Photo p where p.informationflow.id="+informationId;
		Query query=session.createQuery(hql);
		List<Photo> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delPhoto(Photo photo) {
		factory.getCurrentSession().delete(photo);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Photo findById(int photoId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Photo p where p.id="+photoId;
		Query query=session.createQuery(hql);
		Photo photo=(Photo) query.uniqueResult();
		return photo;
	}

}
