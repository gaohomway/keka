package com.keekan.serve;

import java.util.List;


/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AdoreServe {

	/**
	 * 添加倾心
	 * @param keeno
	 * @param content
	 * @param createDate
	 * @return
	 * @throws Exception
	 */
	Integer addAdore(Integer keeno, String content, String createDate) throws Exception;
	
	/**
	 * 更新倾心
	 * @param adoreId
	 * @param keeno
	 * @param createDate
	 * @return
	 * @throws Exception
	 */
	Integer renewAdore(Integer adoreId, Integer keeno, String createDate) throws Exception;
	
	/**
	 * 查询倾心内容
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	List viewAdore(Integer keeno) throws Exception;
	
	/**
	 * 查询倾心内容根据ID
	 * @param adoreId
	 * @return
	 * @throws Exception
	 */
	List viewAdoreById(Integer adoreId) throws Exception;
}
