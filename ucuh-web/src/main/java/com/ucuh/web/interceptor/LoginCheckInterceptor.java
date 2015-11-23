package com.ucuh.web.interceptor;

/**自定义的拦截器*/

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginCheckInterceptor extends AbstractInterceptor {

	/**
	 * 用户登录的拦截器
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String ,Object> session=invocation.getInvocationContext().getSession();
		String resultCode="";
		//System.out.println(invocation.getAction().toString());
		if(session.get("user")!=null){
			//System.out.println(invocation.getAction().toString());
			resultCode=invocation.invoke();//执行后续拦截器或Action业务方法
		}else{
			resultCode="nologin";
		}
		return resultCode;
	}

}
