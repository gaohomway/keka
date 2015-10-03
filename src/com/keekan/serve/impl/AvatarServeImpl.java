package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.AvatarBean;
import com.keekan.dao.AvatarDao;
import com.keekan.serve.AvatarServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 头像的Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class AvatarServeImpl implements AvatarServe {

	private AvatarDao avatarDao;

	/**
	 * 初始化添加头像
	 * @param keeno
	 * @param bigAvatar
	 * @param midAvatar
	 * @param smallAvatar
	 * @return
	 * @throws Exception
	 */
	public Integer initAddAvatar(Integer keeno, String bigAvatar, String midAvatar, String smallAvatar, String updateDate, String inuse) throws Exception {
		try {
			AvatarBean a = new AvatarBean();
			a.setKeeno(keeno);
			a.setBigAvatar(bigAvatar);
			a.setMidAvatar(midAvatar);
			a.setSmallAvatar(smallAvatar);
			a.setUpdateDate(updateDate);
			a.setInuse(inuse);
			avatarDao.initAddAvatar(a);
			return a.getAvatarId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("初始化添加头像时出现异常！");
		}
	}

	/**
	 * 查看头像
	 */
	public List viewAvatar(Integer keeno) throws Exception {
		try {
			List avatarList = avatarDao.viewAvatar(keeno);
			return avatarList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看全部头像时出现异常！");
		}
	}
	
	/**
	 * 根据号码查看头像
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	public List viewAllAvatar(Integer[] keeno) throws Exception {
		try {
			List avatarList = avatarDao.viewAllAvatar(keeno);
			return avatarList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看头像时出现异常！");
		}
	}
	
	public void setAvatarDao(AvatarDao avatarDao) {
		this.avatarDao = avatarDao;
	}
	public AvatarDao getAvatarDao() {
		return avatarDao;
	}

	/**
	 * 更新头像
	 */
	public List renewAvatar(Integer keeno, String bigAvatar, String midAvatar, String smallAvatar, String updateDate, String inuse) throws Exception {
		try {
			AvatarBean a = new AvatarBean();
			a.setKeeno(keeno);
			a.setBigAvatar(bigAvatar);
			a.setMidAvatar(midAvatar);
			a.setSmallAvatar(smallAvatar);
			a.setUpdateDate(updateDate);
			a.setInuse(inuse);
			avatarDao.renewAvatar(a, keeno);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("更新头像时出现异常！");
		}
	}

	/**
	 * 查看头像(正在使用的和历史的)
	 */
	public List viewAllAvatar(Integer keeno) throws Exception {
		try {
			List avatarList = avatarDao.viewAllAvatar(keeno);
			return avatarList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看头像时出现异常！");
		}
	}
}
