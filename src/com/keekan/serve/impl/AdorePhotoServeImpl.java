package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.AdorePhotoBean;
import com.keekan.dao.AdorePhotoDao;
import com.keekan.serve.AdorePhotoServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AdorePhotoServeImpl implements AdorePhotoServe {

	private AdorePhotoDao adorePhotoDao;
	
	/**
	 * 添加倾心照片
	 */
	public Integer addAdorePhoto(Integer keeno, String rawPhotoName, String photoName, String createDate) throws Exception {
		try {
			AdorePhotoBean a =  new AdorePhotoBean();
			a.setKeeno(keeno);
			a.setRawPhotoName(rawPhotoName);
			a.setPhotoName(photoName);
			a.setCreateDate(createDate);
			adorePhotoDao.addAdorePhoto(a);
			return a.getAdorePhotoId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加倾心照片时出现异常");
		}
	}

	public AdorePhotoDao getAdorePhotoDao() {
		return adorePhotoDao;
	}

	public void setAdorePhotoDao(AdorePhotoDao adorePhotoDao) {
		this.adorePhotoDao = adorePhotoDao;
	}

	/**
	 * 插入照片缩略图
	 */
	public List insertPhotoThum(Integer keeno, String createDate) throws Exception {
		try {
			List adorePhotoList = adorePhotoDao.insertPhotoThum(keeno, createDate);
			return adorePhotoList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询插入照片缩略图时出现异常");
		}
	}

	/**
	 * 查看倾心照片
	 */
	public List viewAdorePhoto(Integer[] adoreId) throws Exception {
		try {
			List adorePhotoList = adorePhotoDao.viewAdorePhoto(adoreId);
			return adorePhotoList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看倾心照片时出现异常");
		}
	}

}
