package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface UserServe {

	/**
	 * 查看用户信息相册
	 * @param keeno
	 */
	List viewUser(Integer keeno) throws Exception;
	
	/**
	 * 查看用户名片
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	List viewUserByCarte(Integer[] keeno) throws Exception;
	
	/**
	 * 搜索好友
	 * @return
	 * @throws Exception
	 */
	List searchFriend() throws Exception;
}
