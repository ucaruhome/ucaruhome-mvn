package com.ucuh.dao;

import com.ucuh.entity.Comment;

import java.util.List;

public interface CommentDao {
   //查询所有的comment并分页
   int findCommentAllCount();
	List<Comment> findCommentAll(int count, int nowPage, int maxPage, int maxPageCount);
   //删除一条记录
   void delComment(Comment comment);
   //通过id查询
   Comment findById(int commentId);
	
}
