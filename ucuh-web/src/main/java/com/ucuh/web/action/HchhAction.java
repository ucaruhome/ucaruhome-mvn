package com.ucuh.web.action;

import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

@Entity
public class HchhAction implements SessionAware,ServletRequestAware,ServletResponseAware{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String,Object> session;
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	
}
