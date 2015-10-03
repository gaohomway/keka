package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 头像的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AvatarServe {

	/**
	 * 初始化添加头像
	 * @param keeno
	 * @param bigAvatar
	 * @param midAvatar
	 * @param smallAvatar
	 * @return
	 * @throws Exception
	 */
	Integer initAddAvatar(Integer keeno, String bigAvatar, String midAvatar, String smallAvatar, String updateDate, String inuse) throws Exception;
	
	/**
	 * 查看头像
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	List viewAvatar(Integer keeno) throws Exception;
	
	/**
	 * 根据号码查看头像
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	List viewAllAvatar(Integer[] keeno) throws Exception;
	
	/**
	 * 更新头像
	 * @param avatarBean
	 * @param keeno
	 * @return
	 */
	List renewAvatar(Integer keeno, String bigAvatar, String midAvatar, String smallAvatar, String updateDate, String inuse) throws Exception;
	
	/**
	 * 查看头像(正在使用的和历史的头像)
	 * @return
	 * @throws Exception
	 */
	List viewAllAvatar(Integer keeno) throws Exception;
}
