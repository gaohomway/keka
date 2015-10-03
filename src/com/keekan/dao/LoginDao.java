package com.keekan.dao;

import com.keekan.bean.LoginBean;


public interface LoginDao {
	
	/**
	 * 登录
	 * @param keeno
	 * @param password
	 * @return
	 */
    Integer login(Integer keeno, String password);

   /**
    * 保存号码
    * @param loginBean
    * @return
    */
    Integer saveKeeno(LoginBean loginBean);
}
