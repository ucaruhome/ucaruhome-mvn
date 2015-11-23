package com.ucuh.web.action.fabu;

import com.ucuh.dao.FenLeiDao;
import com.ucuh.entity.FenLei;
import com.ucuh.entity.User;
import com.ucuh.web.action.HchhAction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
@Controller
public class PhotosFabuAdmin extends HchhAction{
        @Resource FenLeiDao fenleiDao;
        
        //得到所有的分类list
        private List<FenLei> fenleis;
        private User user=new User();
        
        public String fabuPage(){
        	//查询所有的分类
        	user=(User) session.get("user");
        	fenleis=fenleiDao.findAll();
        	return "success";
        }
		public List<FenLei> getFenleis() {
			return fenleis;
		}
		public void setFenleis(List<FenLei> fenleis) {
			this.fenleis = fenleis;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
        
        
}
