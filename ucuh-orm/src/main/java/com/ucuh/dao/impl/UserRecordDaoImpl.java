package com.ucuh.dao.impl;

import javax.annotation.Resource;

import com.ucuh.dao.UserRecordDao;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ucuh.entity.UserRecord;

public class UserRecordDaoImpl implements UserRecordDao {
     @Resource SessionFactory factory;
	
    @Transactional(propagation=Propagation.REQUIRED)
	public void delUserRecord(UserRecord ur) {
		factory.getCurrentSession().delete(ur);

	}
    
    @Transactional(propagation=Propagation.REQUIRED)
	public void saveUserRecord(UserRecord ur) {
		factory.getCurrentSession().saveOrUpdate(ur);

	}

}
