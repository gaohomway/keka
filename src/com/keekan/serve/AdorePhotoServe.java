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
public interface AdorePhotoServe {

	/**
	 * 添加倾心照片
	 * @param keeno
	 * @param adoreId
	 * @param photo
	 * @param createDate
	 * @return
	 * @throws Exception
	 */
	Integer addAdorePhoto(Integer keeno, String rawPhotoName, String photoName, String createDate) throws Exception;
	
	/**
	 * 插入照片缩略图
	 * @param keeno
	 * @param createDate
	 * @return
	 */
	List insertPhotoThum(Integer keeno, String createDate) throws Exception;
	
	/**
	 * 查看倾心照片
	 * @param adoreId
	 * @return
	 * @throws Exception
	 */
	List viewAdorePhoto(Integer[] adoreId) throws Exception;
}
