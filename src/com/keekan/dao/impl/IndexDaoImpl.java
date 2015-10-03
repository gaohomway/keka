package com.keekan.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.keekan.bean.UserBean;
import com.keekan.dao.IndexDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: Index Dao Impl<br>
 */
public class IndexDaoImpl extends HibernateDaoSupport implements IndexDao {

	/**
     * 验证是否存在此用户
     * @param keeNumber KEE号码
     * @param password 密码
	 * @return 是否存在此KEE号
     */
	@SuppressWarnings("unchecked")
	public UserBean checkKeeno(Integer keeno, String password) {
		Object[] args = {keeno , password} ;
		List u = getHibernateTemplate().find("from LoginBean au where au.keeno = ? and au.password = ?", args);
		if (u != null && u.size() >= 1) {
			return (UserBean) u.get(0);
		}
		return null;
	}
}
