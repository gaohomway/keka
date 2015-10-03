package com.keekan.serve;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: KEE号码池Service接口 <br>
 */
public interface KeenoPoolServe {
 
	/**
	 * 根据基本信息ID，查询号码
	 * @param id 基本信息ID
	 * @return 
	 * @throws Exception
	 */
    Integer findKeenoById(Integer id) throws Exception;
}
