package com.keekan.dao;

import com.keekan.bean.AttestInfoBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 验证信息的Dao接口 <br>
 */
public interface AttestInfoDao {

	/**
	 * 添加验证信息
	 * @param attestInfoBean
	 * @return
	 */
	Integer addAlbumCover(AttestInfoBean attestInfoBean);
}
