package com.ucuh.dao.impl;

import com.ucuh.dao.CommentDao;
import com.ucuh.entity.Comment;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CommentDaoImpl implements CommentDao {
	@Resource SessionFactory factory;
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Comment> findCommentAll(int count, int nowPage, int maxPage,
			int maxPageCount) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Comment where 1=1 order by time desc";
		Query query=session.createQuery(hql);
		//分页
		if(nowPage==maxPage&count%maxPageCount!=0){
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(count%maxPageCount);
		}else{
			query.setFirstResult((nowPage-1)*maxPageCount+0);
			query.setMaxResults(maxPageCount);
		}
		List<Comment> comms=query.list();
		return comms;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findCommentAllCount() {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="select count(*) from Comment where 1=1 order by time desc";
		Query query=session.createQuery(hql);
		Long c=(Long) query.uniqueResult();
		int count=c.intValue();
		return count;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delComment(Comment comment) {
		factory.getCurrentSession().delete(comment);
		
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Comment findById(int commentId) {
		Session session=null;
		session=factory.getCurrentSession();
		String hql="from Comment c where c.id="+commentId;
		Query query=session.createQuery(hql);
		Comment comment=(Comment) query.uniqueResult();
		return comment;
	}

}
