package com.keekan.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AttestInfoBean;
import com.keekan.dao.AttestInfoDao;
/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 验证信息的Dao接口实现 <br>
 */
public class AttestInfoDaoImpl extends HibernateDaoSupport implements AttestInfoDao {

	/**
	 * 添加验证信息
	 */
	public Integer addAlbumCover(AttestInfoBean attestInfoBean) {
		getHibernateTemplate().save(attestInfoBean);
		return null;
	}

}
