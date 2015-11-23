package com.ucuh.web.action.comment;

import com.ucuh.util.HchhCommonUtil;
import com.ucuh.util.HchhUtil;
import com.ucuh.dao.CommentDao;
import com.ucuh.entity.Comment;
import com.ucuh.web.action.HchhAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class CommentAction extends HchhAction{
    @Resource CommentDao commentDao;
    //==========================================分页查询=====================================
    //分页
	private int nowPage=1;
	private int maxPage;
	private int count;
	private int maxPageCount=20;
	//输出
	private List<Comment> list=new ArrayList<Comment>();
	  //output 分页显示的页数
	private String[] pages;
	//========================================删除一个评论=============================================
	private int commentId;
	private Comment comment;
	//output
	private int ok=0;
	//========================================批量删除评论=================================================
	private String ids;
    //ok
	public String Commentslist(){
		//通过roleId查询users
		count=commentDao.findCommentAllCount();
		//从设置参数的.properties中获取分页的每页显示个数
		   //maxPageCount
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String maxPageCount1=HchhUtil.getMaxPageCount(prop);
		maxPageCount=Integer.valueOf(maxPageCount1);
		//通过count的值获取maxPage
		if(count%maxPageCount==0){
			maxPage=count/maxPageCount;
		}else{
			maxPage=count/maxPageCount+1;
		}
		list=commentDao.findCommentAll(count, nowPage, maxPage, maxPageCount);
		pages=HchhCommonUtil.pageShow(maxPage, 5, nowPage);
		return "success";
	}

	public String delComment(){
		try{
		comment=commentDao.findById(commentId);
		commentDao.delComment(comment);
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=2;
		}
		return "success";
	}
	
	public String delManyComment(){
		String[] idss=ids.split(",");
		try{
		for(int i=0;i<idss.length;i++){
			Integer id=Integer.parseInt(idss[i]);
			Comment c=commentDao.findById(id);
			commentDao.delComment(c);
		}
		ok=1;
		}catch (Exception e) {
			e.printStackTrace();
			ok=2;
		}
		return "success";
	}
	
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMaxPageCount() {
		return maxPageCount;
	}

	public void setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
	}

	public List<Comment> getList() {
		return list;
	}

	public void setList(List<Comment> list) {
		this.list = list;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String[] getPages() {
		return pages;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
	}
	
	
}
