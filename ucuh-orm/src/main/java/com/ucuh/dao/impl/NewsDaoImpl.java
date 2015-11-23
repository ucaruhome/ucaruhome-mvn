package com.ucuh.dao.impl;

import com.ucuh.dao.NewsDao;
import com.ucuh.entity.News;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class NewsDaoImpl implements NewsDao {

	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void delNews(News news) {
		factory.getCurrentSession().delete(news);

	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<News> findNewsAll() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from News";
		Query query=session.createQuery(hql);
		List<News> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveNews(News news) {
		factory.getCurrentSession().saveOrUpdate(news);

	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public News findById(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from News where id="+id;
		Query query=session.createQuery(hql);
		News news=(News) query.uniqueResult();
		return news;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findAllCount() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from News";
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<News> findAll(int count, int nowPage, int maxPage,
			int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from News";
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<News> list=query.list();
		
		return list;
	}

}
