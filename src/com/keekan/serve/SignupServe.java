package com.keekan.serve;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 注册接口 <br>
 */
public interface SignupServe {

	/**
	 * 保存用户信息
	 * @param nickname
	 * @param password
	 * @param email
	 * @param sex
	 * @param birthday
	 * @param nation
	 * @param city
	 * @param area
	 * @param signupIp
	 * @param signupDate
	 * @return
	 * @throws Exception
	 */
	Integer saveUser(String nickname, String sex, String birthday, String nation, String city, String area, String email, String signupIp, String signupDate) throws Exception;
	
	/**
	 * 保存号码
	 * @param userId
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
    Integer saveKeeno(Integer userId, Integer keeno) throws Exception;
}
