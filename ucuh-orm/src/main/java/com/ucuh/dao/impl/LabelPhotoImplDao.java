package com.ucuh.dao.impl;

import com.ucuh.dao.LabelPhotoDao;
import com.ucuh.entity.LabelPhoto;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LabelPhotoImplDao implements LabelPhotoDao {
	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked") 
	public List<LabelPhoto> findByIdAndTypet(int photoId, int labelTypet) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from LabelPhoto lp where lp.hchhPhoto.id="+photoId+" and lp.hchhLabel.typeT="+labelTypet;
		Query query=session.createQuery(hql);
		List<LabelPhoto> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked") 
	public List<LabelPhoto> findByIdAndTypet1(int photoId, int labelTypet) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from LabelPhoto lp where lp.hchhPhoto.id="+photoId+" and (lp.hchhLabel.typeT="+labelTypet+" or lp.hchhLabel.typeT is null)";
		Query query=session.createQuery(hql);
		List<LabelPhoto> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveLabelPhoto(LabelPhoto lp) {
		factory.getCurrentSession().saveOrUpdate(lp);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked") 
	public List<LabelPhoto> findByPhotoIdAndLabelId(int photoId, int labelId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from LabelPhoto lp where lp.hchhPhoto.id="+photoId+" and lp.hchhLabel.id="+labelId;
		Query query=session.createQuery(hql);
		List<LabelPhoto> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delLabelPhoto(LabelPhoto lp) {
		factory.getCurrentSession().delete(lp);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public LabelPhoto findById(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from LabelPhoto lp where lp.id="+id;
		Query query=session.createQuery(hql);
		LabelPhoto lp=(LabelPhoto) query.uniqueResult();
		return lp;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked") 
	public List<LabelPhoto> findByPhotoId(int photoId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from LabelPhoto lp where lp.hchhPhoto.id="+photoId;
		Query query=session.createQuery(hql);
		List<LabelPhoto> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked") 
	public List<LabelPhoto> findPhotosByLabelId(int labelId, int count,
			int nowPage, int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from LabelPhoto lp where lp.hchhLabel.id="+labelId;
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<LabelPhoto> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findPhotosCountByLabelId(int labelId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from LabelPhoto lp where lp.hchhLabel.id="+labelId;
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

}
