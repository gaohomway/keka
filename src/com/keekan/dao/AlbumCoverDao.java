package com.keekan.dao;

import java.util.List;

import com.keekan.bean.AlbumCoverBase;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册封面的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AlbumCoverDao {

	/**
	 * 添加相册封面
	 * @param albumCoverBase
	 * @return
	 */
	Integer addAlbumCover(AlbumCoverBase albumCoverBase);
	
	/**
	 * 查看相册封面
	 * @param albumIds
	 * @return
	 */
	List viewAlbumCover(Integer[] albumIds);
	
	/**
	 * 查看相册封面
	 * @param albumIds
	 * @return
	 */
	List viewAlbumCover(Integer albumIds);
	
	/**
	 * 编辑相册封面
	 * @param albumCoverBase
	 * @return
	 */
	Integer editAlbumCover(AlbumCoverBase albumCoverBase);
	
	/**
	 * 随机相册封面
	 * @param ownAlbumId
	 * @param uploadDate
	 * @return
	 */
	List randomAlbumCover(Integer ownAlbumId, String uploadDate);
}
