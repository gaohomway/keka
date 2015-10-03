package com.keekan.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.keekan.test.Encrypt;
import com.keekan.tool.BaseTools;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 登陆Action <br>
 */
@SuppressWarnings("unchecked")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String password;
	private boolean keepLogin;
	private Integer via;			//0:账号不存在, 1:密码错误, 2:登录成功
	private List avatarList;
	private List userList;
	private String error;			//错误信息
	
	/**
	 * 登录初始化
	 * @return
	 * @throws Exception
	 */
	public String loginInit() throws Exception {
		HttpServletRequest request = BaseTools.getRequest();
		keeno = (Integer) request.getSession().getAttribute("keeno");
		if (keeno != null) {
			avatarList = avatarServe.viewAvatar(keeno);
			userList = userServe.viewUser(keeno);
			return "login";
		}else if (keeno == null) {
			if (getCookieByName("keeno") != null) {
				keeno = Integer.valueOf(getCookieByName("keeno").getValue());
			}
			if (getCookieByName("password") != null) {
				password = getCookieByName("password").getValue();
			}
			if (keeno != null && password != null) {
				BaseTools.getSession().setAttribute("keeno", keeno);
				via = loginServe.login(keeno, password);
				avatarList = avatarServe.viewAvatar(keeno);
				userList = userServe.viewUser(keeno);
				return "login";
			}
		}
		return "login";
	}

	/**
	 * 登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		password = Encrypt.MD5Encode(password);
		via = loginServe.login(keeno, password);
		
		if (via == 0) {
			error = "账号不存在，请重新输入。";
			return "fails";
		}else if (via == 1) {
			error = "账号或密码错误，请重新输入。";
			return "fails";
		}else if (via == 2) {
			BaseTools.getSession().setAttribute("keeno", keeno);
			if (keepLogin == true) {
				addCookie("keeno", String.valueOf(keeno), 864000);
				addCookie("password", password, 864000);
			}
		}
		return "success";
	}

	/**
	 * 登出
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception { 
		BaseTools.getSession().removeAttribute("keeno");
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		deleteCookie("keeno", "", 0);
		deleteCookie("password", "", 0);
		return "success";
	}

	
	/**
	 * 设置cookie
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期 以秒为单位[86400=一天]
	 */
	public void addCookie(String name,String value,int maxAge){
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		if(maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		BaseTools.getResponse().addCookie(cookie);
	}
	
	
	/**
	 * 根据名字获取cookie
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(String name){
								
	    Map<String,Cookie> cookieMap = ReadCookieMap(BaseTools.getRequest());
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	
	/**
	 * 设置cookie
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期 以秒为单位[86400=一天]
	 */
	public void deleteCookie(String name,String value,int maxAge){
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		BaseTools.getResponse().addCookie(cookie);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setKeepLogin(boolean keepLogin) {
		this.keepLogin = keepLogin;
	}

	public boolean isKeepLogin() {
		return keepLogin;
	}

	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}

	public List getAvatarList() {
		return avatarList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public List getUserList() {
		return userList;
	}

	public void setVia(Integer via) {
		this.via = via;
	}

	public Integer getVia() {
		return via;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
}