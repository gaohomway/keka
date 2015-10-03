package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片Service接口 <br>
 */

@SuppressWarnings("unchecked")
public interface PhotoServe {

	/**
	 * 查看照片缩略图
	 * @param albumId
	 * @return
	 * @throws Exception
	 */
	List viewPhotoThumbnail(Integer albumId, Integer startPhoto,Integer perPagePhoto) throws Exception;
	
	/**
	 * 查看照片
	 * @param photoId
	 * @return
	 * @throws Exception
	 */
	List viewPhoto(Integer photoId) throws Exception;
	
	/**
	 * 照片上传
	 * @param photoName
	 * @param dataPhotoName
	 * @param photoDescription
	 * @param belongAlbumId
	 * @return
	 * @throws Exception
	 */
	Integer photoUpload(String rawPhotoName, String photoName, String photoDescription, Integer belongAlbumId, String uploadDate) throws Exception;
	
	/**
	 * 照片张数
	 * @param albumIds
	 * @return
	 * @throws Exception
	 */
	Integer[] photoNumber(Integer[] albumIds) throws Exception;
	
	/**
	 * 照片张数
	 * @param albumId
	 * @return
	 * @throws Exception
	 */
	Integer photoNumber(Integer albumId) throws Exception;
	
	/**
	 * 获取单次上传照片张数
	 * @param ownAlbumId
	 * @param uploadDate
	 * @return
	 */
	Integer uploadPhotoNumber(Integer ownAlbumId, String uploadDate) throws Exception ;
	
	/**
	 * 批量保存照片信息
	 * @param ownAlbumId
	 * @param uploadDate
	 * @return
	 * @throws Exception
	 */
	Integer savePhotoInfo(String rawPhotoName, String photoDescription, Integer ownAlbumId, String uploadDate) throws Exception;
	
	/**
	 * 照片总数[用于分页]
	 * @param ownAlbumId
	 * @return
	 * @throws Exception
	 */
	Integer photoSumCount(Integer ownAlbumId) throws Exception;
}
