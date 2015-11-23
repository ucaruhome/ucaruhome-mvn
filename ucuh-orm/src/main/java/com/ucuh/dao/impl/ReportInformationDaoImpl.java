package com.ucuh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ucuh.dao.ReportInformationDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ucuh.entity.ReportInformation;

public class ReportInformationDaoImpl implements ReportInformationDao {

	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<ReportInformation> findReportInformationAll(int count,
			int nowPage, int maxPage, int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from ReportInformation where 1=1 order by time desc";
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<ReportInformation> ris=query.list();
		return ris;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findReportInformationAllCount() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from ReportInformation where 1=1 order by time desc";
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delReportInformationflow(ReportInformation rif) {
		factory.getCurrentSession().delete(rif);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public ReportInformation findById(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from ReportInformation where id="+id;
		Query query=session.createQuery(hql);
		ReportInformation rif=(ReportInformation) query.uniqueResult();
		return rif;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveReportInformation(ReportInformation rif) {
		factory.getCurrentSession().saveOrUpdate(rif);
		
	}

}
