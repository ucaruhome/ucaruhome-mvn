package com.ucuh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ucuh.dao.InformationflowDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ucuh.entity.Informationflow;

public class InformationflowDaoImpl implements InformationflowDao {
	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveInformationflow(Informationflow inf) {
		factory.getCurrentSession().saveOrUpdate(inf);

	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Informationflow> findByState(int state,int count,int nowPage,int maxPage,int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Informationflow inff where inff.state="+state;
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<Informationflow> list=query.list();
		
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findByStateCount(int state) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from Informationflow inff where inff.state="+state;
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Informationflow findById(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Informationflow inff where inff.id="+id;
		Query query=session.createQuery(hql);
		Informationflow inff=(Informationflow) query.uniqueResult();
		return inff;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delInformationflow(Informationflow inff) {
		factory.getCurrentSession().delete(inff);
		
	}

}
