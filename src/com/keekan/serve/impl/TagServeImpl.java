package com.keekan.serve.impl;

import java.util.List;

import com.keekan.dao.TagDao;
import com.keekan.serve.TagServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 标签的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class TagServeImpl implements TagServe{

	private TagDao tagDao;

	/**
	 * 标签
	 */
	public List tag() throws Exception {
		try {
			List tagList = tagDao.tag();
			return tagList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("标签时出现异常");
		}
	}
	
	/**
	 * 标签库
	 */
	public List tags() throws Exception {
		try {
			List tagsList = tagDao.tags();
			return tagsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("标签库时出现异常");
		}
	}
	
	public void setTagDao(TagDao tagDao) throws Exception {
		this.tagDao = tagDao;
	}
}
