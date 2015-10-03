package com.keekan.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.keekan.tool.BaseTools;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 首页Action <br>
 */
public class IndexAction extends  BaseAction{
	
	private static final long serialVersionUID = 1L;
	private String password;				//密码
	
	/**
	 * 验证首页
	 * @return
	 * @throws Exception
	 */
	public String checkIndex() throws Exception {
		HttpServletRequest request = BaseTools.getRequest();
		//session验证
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		password = (String) BaseTools.getSessionAttribute("password");
		if (keeno != null) {
			if (password != null) {
				//查询数据库
				int userId = indexServe.checkKeeno(keeno, password);
				if (userId > 0 ) {
					//登录成功
					return SUCCESS;
				}else {
					return "login";
				}
			}
		}else {
			//cookies验证
			if (request.getCookies() != null) {
				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals("keeNumber")) {
						keeno = cookie.getVersion();
						BaseTools.getSession().setAttribute("keeno", keeno);
					}
					if (cookie.getName().equals("password")) {
						password = cookie.getValue();
						BaseTools.getSession().setAttribute("password", password);
					}
				}
				if (keeno != null) {
					if (password != null) {
						//查询数据库
						int userId = indexServe.checkKeeno(keeno, password);
						if (userId > 0 ) {
							//登录成功
							return SUCCESS;
						}else {
							return "login";
						}
					}
				}else {
					return "login";
				}
			}else {
				return "login";
			}
		}
		return "login";
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
