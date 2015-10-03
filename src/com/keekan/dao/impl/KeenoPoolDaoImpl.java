package com.keekan.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.KeenoPoolBean;
import com.keekan.dao.KeenoPoolDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: KEE号码池Dao接口实现 <br>
 */
public class KeenoPoolDaoImpl extends HibernateDaoSupport implements
		KeenoPoolDao {

	/**
	 * 根据基本信息ID,查找号码
	 * @param id 基本信息ID
	 * @return Number 号码
	 */
	@SuppressWarnings("unchecked")
	public List<KeenoPoolBean> findKeenoById(Integer id) {
		 List<KeenoPoolBean> poolKeeno = getHibernateTemplate().find("from KeenoPoolBean au where au.id = ?", new Integer[]{id}); 
		 if (poolKeeno != null && poolKeeno.size() >=1) {
				return  poolKeeno;
			}
			return poolKeeno;
	}
}
