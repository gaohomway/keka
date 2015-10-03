package com.keekan.dao;

import com.keekan.bean.UserBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: Index Dao<br>
 */
public interface IndexDao {
	
	/**
     * 验证是否存在此用户
     * @param keeno KEE号
     * @param password 密码
	 * @return 
     */
    UserBean checkKeeno(Integer keeno, String password);

}
