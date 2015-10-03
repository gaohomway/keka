package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.LoginBean;
import com.keekan.dao.LoginDao;

@SuppressWarnings("unchecked")
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {

	/**
	 * 根据用户名，密码查找用户
	 * @param keeno
	 * @param password
	 * @return 
	 */
	public Integer login(Integer keeno, String password) {
		
		List count = getHibernateTemplate().find("from LoginBean au where au.keeno = ?", keeno);
		if (count.size() == 1) {
			Object[] params = {keeno, password};
			List u = getHibernateTemplate().find("from LoginBean au where au.keeno = ? and au.password = ?", params);
			if (u.size() == 1) {
				return 2;
			}else {
				return 1;
			}
		}else {
			return 0;
		}
	}

	/**
	 * 保存号码
	 */
	public Integer saveKeeno(LoginBean loginBean) {
		getHibernateTemplate().save(loginBean);
		return null;
	}

}
