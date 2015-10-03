package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AlbumServe {

	/**
	 * 添加相册
	 * @param albumName 相册的名字
	 * @param albumDescribe 相册描述
	 * @param albumGroup 相册所属分类
	 * @param albumPurview 相册可见
	 */
	Integer addAlbum(Integer keeno, String albumName, String albumDescribe, Integer ownAlbumGroupId, String  createDate,String updateDate) throws Exception;

	/**
	 * 查看全部相册
	 * @param albumGroupIds
	 */
	List viewAllAlbum(Integer[] albumGroupIds) throws Exception;

	/**
	 * 根据KEE号码查询所有相册
	 * @param keeno
	 * @return
	 */
	List viewAllAlbumByKeeno(Integer keeno) throws Exception;
	
	/**
	 * 根据相册ID查询相册
	 * @param albumId
	 * @return
	 */
	List viewAlbumByAlbumId(Integer albumId) throws Exception;
	
	/**
	 * 获取相册ID
	 * @param keeno
	 * @param albumName
	 * @return
	 * @throws Exception
	 */
	Integer getAlbumId(Integer keeno, String albumName) throws Exception;
}
