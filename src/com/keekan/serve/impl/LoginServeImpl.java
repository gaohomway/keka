package com.keekan.serve.impl;

import com.keekan.bean.LoginBean;
import com.keekan.dao.LoginDao;
import com.keekan.serve.LoginServe;

public class LoginServeImpl implements LoginServe{

	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/**
	 * 登录
	 */
	public Integer login(Integer keeno, String password) throws Exception {
		try {
			Integer via = loginDao.login(keeno, password);
			return via;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("验证用户登录时出现异常");
		}
	}

	/**
	 * 保存号码
	 */
	public Integer saveKeeno(Integer keeno, String password) throws Exception {
		try {
			LoginBean l = new LoginBean();
			l.setKeeno(keeno);
			l.setPassword(password);
			loginDao.saveKeeno(l);
			return l.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("保存号码时出现异常");
		}
	}

}
