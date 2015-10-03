package com.keekan.dao;

import java.util.List;

import com.keekan.bean.AdoreBean;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AdoreDao {

	/**
	 * 添加倾心
	 * @param adoreBean
	 * @return
	 */
	Integer addAdore(AdoreBean adoreBean);
	
	/**
	 * 更新倾心
	 * @param a
	 * @return
	 */
	Integer renewAdore(AdoreBean a);
	
	/**
	 * 查询倾心内容
	 * @param keeno
	 * @return
	 */
	List viewAdore(Integer keeno);
	
	/**
	 * 查询倾心内容根据ID
	 * @param adoreId
	 * @return
	 */
	List viewAdoreById(Integer adoreId);
}
