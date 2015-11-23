package com.ucuh.dao.impl;

import com.ucuh.dao.WordbookDao;
import com.ucuh.entity.Wordbook;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class WordbookDaoImpl implements WordbookDao {
      
	@Resource SessionFactory factory;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveWordbook(Wordbook wb) {
		factory.getCurrentSession().saveOrUpdate(wb);

	}


	@Transactional(propagation=Propagation.REQUIRED)
	@SuppressWarnings("unchecked")
	public Wordbook findByLNA(String leixing, String name, int activityId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Wordbook wb where wb.leixing='"+leixing+"' and wb.name='"+name+"' and wb.activityId="+activityId;
		Query query=session.createQuery(hql);
		List<Wordbook> wbs=query.list();
		Wordbook wb=new Wordbook();
		if(wbs.size()!=0){
			wb=wbs.get(0);
		}
		return wb;
	}


	@Transactional(propagation=Propagation.REQUIRED)
	@SuppressWarnings("unchecked")
	public List<Wordbook> findByActivityId(int activityId,String leixing) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Wordbook wb where wb.activityId="+activityId+" and wb.leixing like '"+leixing+"'";
		Query query=session.createQuery(hql);
		List<Wordbook> wbs=query.list();
		return wbs;
	}

}
