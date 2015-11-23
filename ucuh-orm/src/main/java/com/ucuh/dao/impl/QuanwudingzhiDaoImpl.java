package com.ucuh.dao.impl;

import com.ucuh.dao.QuanwudingzhiDao;
import com.ucuh.entity.Quanwudingzhi;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class QuanwudingzhiDaoImpl implements QuanwudingzhiDao {
	@Resource SessionFactory factory;
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Quanwudingzhi> findQuanwudingzhiAll(int count, int nowPage,
			int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Quanwudingzhi where 1=1 order by time desc";
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<Quanwudingzhi> qwdzs=query.list();
		return qwdzs;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findQuanwudingzhiAllCount() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from Quanwudingzhi where 1=1 order by time desc";
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

}
