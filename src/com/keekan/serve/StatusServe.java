package com.keekan.serve;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户状态的Service接口 <br>
 */
public interface StatusServe {

	/**
	 * 初始化添加状态
	 * @param keeno
	 * @param status
	 * @param statusInfo
	 * @param statusDate
	 * @return
	 * @throws Exception
	 */
	Integer initAddStatus(Integer keeno, String status, String statusInfo, String statusDate) throws Exception;
	
	/**
	 * 登录后更新状态
	 * @param keeno
	 * @param status
	 * @param statusInfo
	 * @param statusDate
	 * @return
	 * @throws Exception
	 */
	Integer updateStatus(Integer keeno, String status, String statusInfo, String statusDate) throws Exception;
}
