package com.ucuh.dao.impl;

import com.ucuh.dao.CodeDao;
import com.ucuh.entity.Code;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CodeDaoImpl implements CodeDao{
	@Resource SessionFactory factory;
	
	

	@Transactional(propagation=Propagation.REQUIRED)
	public void delCode(Code code) {
		factory.getCurrentSession().delete(code);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Code findByUserKey(String userKey) {
		Session session=null;
		Code code=null;
		session=factory.getCurrentSession();
		String hql="from Code c where c.id.userKey like '"+userKey+"'";
		Query query=session.createQuery(hql);
		List<Code> codes=query.list();
		if(codes.size()!=0){
			code=codes.get(0);
		}
		return code;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCode(Code code) {
		factory.getCurrentSession().saveOrUpdate(code);
		
	}

}
