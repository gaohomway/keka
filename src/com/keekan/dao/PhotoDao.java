package com.keekan.dao;

import java.util.List;

import com.keekan.bean.PhotoBean;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片的Dao接口 <br>
 */
@SuppressWarnings("unchecked")
public interface PhotoDao {
	
	/**
	 * 查看照片缩略图[分页]
	 * @param albumId
	 * @param startPhoto
	 * @param perPagePhoto
	 * @return
	 */
	List viewPhotoThumbnail(Integer albumId, Integer startPhoto, Integer perPagePhoto);
	
	/**
	 * 查看照片
	 * @param photoId
	 * @return
	 */
	List viewPhoto(Integer photoId);
	
	/**
	 * 上传照片
	 * @param photoBean
	 * @return
	 */
	void photoUpload(PhotoBean photoBean);
	
	/**
	 * 照片张数
	 * @param ownAlbumId
	 * @return
	 */
	Integer[] photoNumber(Integer[] albumIds);
	
	/**
	 * 照片张数
	 * @param ownAlbumId
	 * @return
	 */
	Integer photoNumber(Integer albumId);
	
	/**
	 * 获取单次上传照片张数
	 * @param ownAlbumId
	 * @param uploadDate
	 * @return
	 */
	Integer uploadPhotoNumber(Integer ownAlbumId, String uploadDate);
	
	/**
	 * 批量保存照片信息
	 * @param photoBean
	 * @return
	 */
	Integer savePhotoInfo(PhotoBean photoBean);

	/**
	 * 照片总数[用于分页]
	 * @param ownAlbumId
	 * @return
	 */
	Integer photoSumCount(Integer ownAlbumId);
}
