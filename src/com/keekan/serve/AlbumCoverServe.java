package com.keekan.serve;

import java.util.List;

import com.keekan.bean.AlbumCoverBase;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册封面的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AlbumCoverServe {
	
	/**
	 * 添加相册封面
	 * @param photoName
	 * @param ownAlbumId
	 * @param uploadDate
	 * @return
	 * @throws Exception
	 */
	Integer addAlbumCover(String photoName, Integer ownAlbumId, String uploadDate, String status) throws Exception;

	/**
	 * 查看相册封面
	 * @param albumIds
	 * @return
	 * @throws Exception
	 */
	List viewAlbumCover(Integer[] albumIds) throws Exception;
	
	/**
	 * 查看相册封面
	 * @param albumIds
	 * @return
	 * @throws Exception
	 */
	List viewAlbumCover(Integer albumId) throws Exception;
	
	/**
	 * 编辑相册封面
	 * @param coverId
	 * @param photoName
	 * @param ownAlbumId
	 * @param uploadDate
	 * @param status
	 * @return
	 * @throws Exception
	 */
	Integer editAlbumCover(List<AlbumCoverBase> albumCoverList) throws Exception;
	
	/**
	 * 随机相册封面
	 * @param ownAlbumId
	 * @param uploadDate
	 * @return
	 * @throws Exception
	 */
	List randomAlbumCover(Integer ownAlbumId,String uploadDate) throws Exception;
}
