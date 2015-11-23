package com.ucuh.dao.impl;

import com.ucuh.dao.LabelDao;
import com.ucuh.entity.Label;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LabelDaoImpl implements LabelDao {
    @Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByType(int type) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Label where (type="+type+" or type is null) and grade!=0";
		Query query=session.createQuery(hql);
		List<Label> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByGrade(int grade,int type) {
        Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where type="+type+" and grade="+grade;
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByParentId(int parentId,int type) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where type="+type+" and parentId="+parentId;
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}

	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByTypeAndTreeCodeAsc(int type) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where type="+type+" ORDER BY treeCode asc";
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByTypeAndTreeCodeAsc1(int type) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where type="+type+" and (typeT !=2 or typeT is null) ORDER BY treeCode asc";
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByTypeAndTreeCodeAsc2(int type) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where type="+type+" and typeT =2 ORDER BY treeCode asc";
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Label findByID(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Label where id="+id;
		Query query=session.createQuery(hql);
		Label label=(Label) query.uniqueResult();
		return label;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveLabel(Label label) {
		factory.getCurrentSession().saveOrUpdate(label);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findBySouSuo(String sousuo, int type) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where tagName like '%"+sousuo+"%'  and type="+type+" ORDER BY treeCode asc";
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteLabel(Label label) {
		factory.getCurrentSession().delete(label);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Label> findByParentId(int parentId) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where parentId="+parentId;
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
		return list;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Label findByTPG(int type, int parentId, int grade) {
		Session session=null;
        session=factory.getCurrentSession();
        String hql="from Label where type="+type+" and parentId="+parentId+" and grade="+grade;
        Query query=session.createQuery(hql);
        List<Label> list=query.list();
        Label label=new Label();
        if(list!=null&&list.size()!=0){
        	label=list.get(0);
        }
		return label;
	}
	
	 

}
