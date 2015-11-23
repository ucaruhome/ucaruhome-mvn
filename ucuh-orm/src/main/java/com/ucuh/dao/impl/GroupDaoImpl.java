package com.ucuh.dao.impl;

import com.ucuh.dao.GroupDao;
import com.ucuh.entity.Group;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class GroupDaoImpl implements GroupDao {
	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Group> findGroups() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Group";
		List<Group> groups=session.createQuery(hql).list();
		return groups;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Group findByID(int id) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Group where id="+id;
		Group group=(Group) session.createQuery(hql).uniqueResult();
		return group;
	}
	

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Group findByGroupName(String groupName) {
		Session session=null;
	      session=factory.getCurrentSession();
	      String hql="from Group r where r.groupName like '"+groupName+"'";
	      List<Group> roles=session.createQuery(hql).list();
	      if(roles==null||roles.size()==0){
	    	  return null; 
	      }else{
	    	  return roles.get(0);
	      }
	}

}
