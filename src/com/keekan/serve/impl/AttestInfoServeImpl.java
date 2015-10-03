package com.keekan.serve.impl;

import com.keekan.bean.AttestInfoBean;
import com.keekan.dao.AttestInfoDao;
import com.keekan.serve.AttestInfoServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 验证信息的Serve接口实现 <br>
 */
public class AttestInfoServeImpl implements AttestInfoServe {

	private AttestInfoDao attestInfoDao;

	/**
	 * 添加验证信息
	 */
	public Integer addAlbumCover(Integer keeno, Integer groupId, Integer friendKeeno, String remarkInfo, String attestInfo, String infoStatus, String infoDate) throws Exception {
		try {
			AttestInfoBean a = new AttestInfoBean();
			a.setKeeno(keeno);
			a.setGroupId(groupId);
			a.setFriendKeeno(friendKeeno);
			a.setRemarkInfo(remarkInfo);
			a.setAttestInfo(attestInfo);
			a.setInfoStatus(infoStatus);
			a.setInfoDate(infoDate);
			attestInfoDao.addAlbumCover(a);
			return a.getInfoId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加验证信息时出现异常");
		}
	}
	
	public void setAttestInfoDao(AttestInfoDao attestInfoDao) {
		this.attestInfoDao = attestInfoDao;
	}

	public AttestInfoDao getAttestInfoDao() {
		return attestInfoDao;
	}
}
