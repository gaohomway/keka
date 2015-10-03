package com.keekan.serve.impl;

import com.keekan.bean.UserBean;
import com.keekan.dao.IndexDao;
import com.keekan.serve.IndexServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: Index Service Impl<br>
 */
public class IndexServeImpl implements IndexServe {
	
	private IndexDao indexDao;
	
	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}

	/**
     * 验证是否存在此用户
     * @param keeNumber KEE号码
     * @param password 密码
	 * @return 是否存在此KEE号
     */
	public int checkKeeno(Integer keeno, String password) throws Exception {
		try {
			UserBean u = indexDao.checkKeeno(keeno, password);
			if (u != null) {
				return u.getUserId();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("验证是否存在此用户时出异常");
		}
		return -1;
	}
}
