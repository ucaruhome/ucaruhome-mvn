package com.ucuh.dao.impl;

import com.ucuh.dao.RoleDao;
import com.ucuh.entity.Role;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RoleDaoImpl implements RoleDao {

	@Resource SessionFactory factory;

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Role findRole(String roleName) {
      Session session=null;
      session=factory.getCurrentSession();
      String hql="from Role r where r.roleName like '"+roleName+"'";
      List<Role> roles=session.createQuery(hql).list();
      if(roles==null||roles.size()==0){
    	  return null; 
      }else{
    	  return roles.get(0);
      }
	  
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Role> findRoles() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Role";
		List roles=session.createQuery(hql).list();
		return roles;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Role findByID(int roleId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Role where id = "+roleId;
		Role role=(Role) session.createQuery(hql).uniqueResult();
		return role;
	}
	
	

}
