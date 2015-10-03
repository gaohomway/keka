package com.keekan.dao;

import java.util.List;

import com.keekan.bean.AlbumBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AlbumDao {

	/**
	 * 添加相册
	 * @param albumBean 要增加的相册Bean
	 */
	Integer addAlbum(AlbumBean albumBean);

	/**
	 * 查看全部相册
	 * @param albumBean 要增加的相册Bean
	 */
	List viewAllAlbum(Integer[] albumGroupIds);
	
	/**
	 * 根据KEE号码查询所有相册
	 * @param keeno
	 * @return
	 */
	List viewAllAlbumByKeeno(Integer keeno);
	
	/**
	 * 获取相册ID
	 * @param keeno
	 * @return
	 */
	List getAlbumId(Integer keeno, String albumName);
	
	/**
	 * 根据相册ID查询相册
	 * @param albumId
	 * @return
	 */
	List viewAlbumByAlbumId(Integer albumId);
}
