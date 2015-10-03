package com.keekan.dao;

import java.util.List;

import com.keekan.bean.AdorePhotoBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AdorePhotoDao {

	/**
	 * 添加倾心照片
	 * @param adorePhotoBean
	 */
	void addAdorePhoto(AdorePhotoBean adorePhotoBean);
	
	
	/**
	 * 插入照片缩略图
	 * @param keeno
	 * @param createDate
	 * @return
	 */
	List insertPhotoThum(Integer keeno, String createDate);
	
	/**
	 * 查看倾心照片
	 * @param adoreId
	 * @return
	 */
	List viewAdorePhoto(Integer[] adoreId);
}
