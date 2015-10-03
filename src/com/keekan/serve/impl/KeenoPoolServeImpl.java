package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.KeenoPoolBean;
import com.keekan.dao.KeenoPoolDao;
import com.keekan.serve.KeenoPoolServe;

public class KeenoPoolServeImpl implements KeenoPoolServe{
	
	private KeenoPoolDao keenoPoolDao;
	
	public KeenoPoolDao getKeenoPoolDao() {
		return keenoPoolDao;
	}
	public void setKeenoPoolDao(KeenoPoolDao keenoPoolDao) {
		this.keenoPoolDao = keenoPoolDao;
	}

	/**
	 * 根据基本信息ID，查询号码
	 * @param id 基本信息ID
	 * @return 
	 * @throws Exception
	 */
	public Integer findKeenoById(Integer id) throws Exception {
		try {
			List<KeenoPoolBean> poolNum = keenoPoolDao.findKeenoById(id);
			if (poolNum != null) {
				Integer keeno = (Integer) poolNum.get(0).getKeeno();
				return keeno;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获得号码时异常");
		}
		return null;
	}
}
