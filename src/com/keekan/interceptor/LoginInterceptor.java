package com.keekan.interceptor;

import com.keekan.tool.BaseTools;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts2.ServletActionContext;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = BaseTools.getRequest();
		HttpServletResponse response = BaseTools.getResponse();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();	//请求的URL
		String keeno = (String) session.getAttribute("keeno");				//获取session中的keeno
		String password = (String) session.getAttribute("password");				//获取session中的password
		if (keeno != null ) {
			if (password != null) {
				//查询数据库
			}else {
				//返回登录页面并传递keeNumber
			}
		} else {
			//查询cookie
			if (request.getCookies() != null) {
				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals("keeno")) {
						keeno = cookie.getValue();
					}
					if (cookie.getName().equals("password")) {
						password = cookie.getValue();
					}
				}
			}
			return invocation.invoke();
		}
		return password;
	}
}