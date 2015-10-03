package com.keekan.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

import com.keekan.dao.NavigateDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 导航的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class NavigateDaoImpl extends HibernateDaoSupport implements NavigateDao {

	/**
	 * 查看导航
	 * @return
	 */
	public List viewNavigate() {
		List navigateList = getHibernateTemplate().find("from NavigateBean");
		if (navigateList != null && navigateList.size() >= 1) {
			return navigateList;
		} else {
			return null;
		}
	}

}
