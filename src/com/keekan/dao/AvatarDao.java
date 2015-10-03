package com.keekan.dao;

import java.util.List;

import com.keekan.bean.AvatarBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 头像的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AvatarDao {

	/**
	 * 初始化添加头像
	 * @param albumBean 要增加的相册Bean
	 */
	Integer initAddAvatar(AvatarBean avatarBean);
	
	/**
	 * 根据号码查看头像
	 * @param keeno
	 * @return
	 */
	List viewAllAvatar(Integer[] keeno);
	
	/**
	 * 查看头像
	 * @param keeno
	 * @return
	 */
	List viewAvatar(Integer keeno);
	
	/**
	 * 更新头像
	 * @param avatarBean
	 * @return
	 */
	List renewAvatar(AvatarBean avatarBean, Integer keeno);
	
	/**
	 * 查看头像(正在使用的和历史头像)
	 * @param keeno
	 * @return
	 */
	List viewAllAvatar(Integer keeno);
}
