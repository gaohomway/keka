package com.keekan.dao;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 标签的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface TagDao {

	/**
	 * 标签
	 * @return
	 */
	List tag();
	
	/**
	 * 标签库
	 * @return
	 */
	List tags();
}
