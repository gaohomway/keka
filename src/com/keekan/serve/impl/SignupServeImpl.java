package com.keekan.serve.impl;

import com.keekan.bean.UserBean;
import com.keekan.dao.SignupDao;
import com.keekan.serve.SignupServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 注册Serve接口实现 <br>
 */
public class SignupServeImpl implements SignupServe {

	private SignupDao signupDao;
	
	/**
	 * 保存用户信息
	 */
	public Integer saveUser(String nickname, String sex, String birthday, String nation, String city, String area, String email, String signupIp, String signupDate) throws Exception {
		try {
			UserBean u = new UserBean();
			u.setNickname(nickname);
			u.setSex(sex);
			u.setBirthday(birthday);
			u.setNation(nation);
			u.setCity(city);
			u.setArea(area);
			u.setEmail(email);
			u.setSignupIp(signupIp);
			u.setSignupDate(signupDate);
			signupDao.saveUser(u);
			return u.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("新增用户时出现异常");
		}
	}
	
	/**
	 * 保存号码
	 */
	public Integer saveKeeno(Integer userId, Integer keeno) throws Exception {
		try {
			UserBean u = new UserBean();
			u.setUserId(userId);
			u.setKeeno(keeno);
			signupDao.saveKeeno(u);
			return u.getKeeno();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("保存号码时出现异常");
		}
	}

	public void setSignupDao(SignupDao signupDao) {
		this.signupDao = signupDao;
	}
}
