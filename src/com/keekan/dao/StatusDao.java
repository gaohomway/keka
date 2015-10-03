package com.keekan.dao;

import com.keekan.bean.StatusBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户状态的Dao接口 <br>
 */
public interface StatusDao {

	/**
	 * 初始化添加状态
	 * @param statusBean
	 * @return
	 */
	Integer initAddStatus(StatusBean statusBean);
	
	/**
	 * 登录后更新状态
	 * @param statusBean
	 * @return
	 */
	Integer updateStatus(StatusBean statusBean);
}
