package com.keekan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.dao.TagDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 标签的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class TagDaoImpl extends HibernateDaoSupport implements TagDao {

	/**
	 * 标签
	 */
	public List tag() {
		List tagList = getHibernateTemplate().find("from TagBean");
		if (tagList != null && tagList.size() >= 1) {
			return tagList;
		}else {
			return null;
		}
	}

	/**
	 * 标签库
	 */
	public List tags() {
		List tagsList = getHibernateTemplate().find("from TagsBean");
		if (tagsList != null && tagsList.size() >= 1) {
			return tagsList;
		}else {
			return null;
		}
	}

}
