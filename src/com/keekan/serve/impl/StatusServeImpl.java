package com.keekan.serve.impl;

import com.keekan.bean.StatusBean;
import com.keekan.dao.StatusDao;
import com.keekan.serve.StatusServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户状态的Service接口实现 <br>
 */
public class StatusServeImpl implements StatusServe {

	private StatusDao statusDao;
	
	/**
	 * 初始化添加状态 
	 */
	public Integer initAddStatus(Integer keeno, String status, String statusInfo, String statusDate) throws Exception {
		try {
			StatusBean s = new StatusBean();
			s.setKeeno(keeno);
			s.setStatus(status);
			s.setStatusInfo(statusInfo);
			s.setStatusDate(statusDate);
			statusDao.initAddStatus(s);
			return s.getStatusId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("初始化添加状态时出现异常");
		}
		
	}
	
	/**
	 * 登录后更新状态
	 */
	public Integer updateStatus(Integer keeno, String status, String statusInfo, String statusDate) throws Exception {
		try {
			StatusBean s = new StatusBean();
			s.setKeeno(keeno);
			s.setStatus(status);
			s.setStatusInfo(statusInfo);
			s.setStatusDate(statusDate);
			statusDao.updateStatus(s);
			return s.getStatusId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("登录后更新状态时出现异常");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public StatusDao getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}
}
