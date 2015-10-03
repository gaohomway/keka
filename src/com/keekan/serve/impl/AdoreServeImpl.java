package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.AdoreBean;
import com.keekan.dao.AdoreDao;
import com.keekan.serve.AdoreServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AdoreServeImpl implements AdoreServe {

	private AdoreDao adoreDao;
	
	/**
	 * 添加倾心
	 */
	public Integer addAdore(Integer keeno, String content, String createDate) throws Exception {
		try {
			AdoreBean a =  new AdoreBean();
			a.setKeeno(keeno);
			a.setContent(content);
			a.setCreateDate(createDate);
			adoreDao.addAdore(a);
			return a.getAdoreId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加倾心时出现异常");
		}
	}

	public AdoreDao getAdoreDao() {
		return adoreDao;
	}
	public void setAdoreDao(AdoreDao adoreDao) {
		this.adoreDao = adoreDao;
	}

	/**
	 * 更新倾心
	 */
	public Integer renewAdore(Integer adoreId, Integer keeno, String createDate) throws Exception {
		try {
			AdoreBean a = new AdoreBean();
			a.setAdoreId(adoreId);
			a.setKeeno(keeno);
			a.setCreateDate(createDate);
			adoreDao.renewAdore(a);
			return a.getAdoreId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("更新倾心时出现异常");
		}
	}

	/**
	 * 查询倾心内容根据ID
	 */
	public List viewAdore(Integer keeno) throws Exception {
		try {
			List adoreList = adoreDao.viewAdore(keeno);
			return adoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看倾心内容时出现异常");
		}
	}

	/**
	 * 查看倾心内容
	 */
	public List viewAdoreById(Integer adoreId) throws Exception {
		try {
			List adoreList = adoreDao.viewAdore(adoreId);
			return adoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看倾心内容时出现异常");
		}
	}
}
