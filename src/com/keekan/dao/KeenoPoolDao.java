package com.keekan.dao;

import java.util.List;

import com.keekan.bean.KeenoPoolBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: KEE号码池Dao接口 <br>
 */
public interface KeenoPoolDao {
	
	/**
	 * 根据基本信息ID,查找号码
	 * @param id 基本信息ID
	 * @return
	 */
	List<KeenoPoolBean> findKeenoById(Integer id);
}
