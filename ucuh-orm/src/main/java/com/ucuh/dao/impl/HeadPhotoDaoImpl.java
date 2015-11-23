package com.ucuh.dao.impl;

import java.util.List;

import com.ucuh.dao.HeadPhotoDao;
import com.ucuh.entity.Headphoto;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class HeadPhotoDaoImpl implements HeadPhotoDao {

	@Resource SessionFactory factory;
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveOrUpdateHeadPhoto(Headphoto hp) {
		factory.getCurrentSession().saveOrUpdate(hp);

	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Headphoto findByID(int photoId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Headphoto where id="+photoId;
		Query query=session.createQuery(hql);
		Headphoto hp=(Headphoto) query.uniqueResult();
		return hp;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Headphoto> findByUseridAndHeadphotostate(int userId,
			int headPhotoState) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Headphoto where userId="+userId+" and headPhotoState="+headPhotoState+" order by time desc";
		Query query=session.createQuery(hql);
		List<Headphoto> hps=query.list();
		return hps;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Headphoto> findByUserid(int userId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Headphoto where userId="+userId+" order by time desc";
		Query query=session.createQuery(hql);
		List<Headphoto> hps=query.list();
		return hps;
	}

	
}
