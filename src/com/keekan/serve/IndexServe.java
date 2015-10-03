package com.keekan.serve;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: Index Service<br>
 */
public interface IndexServe {
	
	/**
     * 验证是否存在此用户
     * @param keeNumber KEE号码
     * @param password 密码
	 * @return 是否存在此KEE号
     */
    int checkKeeno(Integer keeno, String password) throws Exception;

}
