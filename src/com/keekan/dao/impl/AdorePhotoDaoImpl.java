package com.keekan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keekan.bean.AdorePhotoBean;
import com.keekan.dao.AdorePhotoDao;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 倾心的Dao接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AdorePhotoDaoImpl extends HibernateDaoSupport implements AdorePhotoDao {

	/**
	 * 添加倾心照片
	 */
	public void addAdorePhoto(AdorePhotoBean adorePhotoBean) {
		getHibernateTemplate().save(adorePhotoBean);
	}

	/**
	 * 插入照片缩略图
	 */
	public List insertPhotoThum(Integer keeno, String createDate) {
		List adorePhotoList = getHibernateTemplate().find("from AdorePhotoBean au where au.keeno = "+keeno+" and au.createDate = ?", createDate);
		if (adorePhotoList != null && adorePhotoList.size() >= 1) {
			return adorePhotoList;
		} else {
			return null;
		}
	}

	/**
	 * 查看倾心照片
	 */
	public List viewAdorePhoto(Integer[] adoreId) {
		List<AdorePhotoBean> adorePhotoList = new ArrayList<AdorePhotoBean>(adoreId.length);
		List<AdorePhotoBean> adorePhoto = new ArrayList<AdorePhotoBean>();
		for (int i = 0; i < adoreId.length; i++) {
			adorePhoto = getHibernateTemplate().find("from AdorePhotoBean au where au.ownAdoreId in(?)", adoreId[i]);
			adorePhotoList.addAll(adorePhoto);
		}
		if (adorePhotoList != null && adorePhotoList.size() >= 1) {
			return adorePhotoList;
		} else {
			return null;
		}
	}

}
