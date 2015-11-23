package com.ucuh.dao.impl;

import com.ucuh.dao.InformationflowRecordDao;
import com.ucuh.entity.InformationflowRecord;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class InformationflowRecordDaoImpl implements InformationflowRecordDao{
    @Resource SessionFactory factory;
    
    @Transactional(propagation=Propagation.REQUIRED)
	public void saveInformationflowRecord(InformationflowRecord ifr) {
		factory.getCurrentSession().saveOrUpdate(ifr);
		
	}

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<InformationflowRecord> findByInformationflowId(
			int informationflowId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from InformationflowRecord ifr where ifr.informationflow.id="+informationflowId;
		Query query=session.createQuery(hql);
		List<InformationflowRecord> list=query.list();
		return list;
	}

    @Transactional(propagation=Propagation.REQUIRED)
	public void delInformationflowRecord(InformationflowRecord ifr) {
		factory.getCurrentSession().delete(ifr);
		
	}

	

}
