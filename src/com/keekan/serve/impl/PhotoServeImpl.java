package com.keekan.serve.impl;

import java.util.List;

import com.keekan.bean.PhotoBean;
import com.keekan.dao.PhotoDao;
import com.keekan.serve.PhotoServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 照片Service接口实现 <br>
 */
@SuppressWarnings("unchecked")
public class PhotoServeImpl implements PhotoServe {

	private PhotoDao photoDao;
	
	/**
	 * 查看照片缩略图
	 */
	public List viewPhotoThumbnail(Integer albumId, Integer startPhoto,Integer perPagePhoto) throws Exception {
		try {
			List photoList = photoDao.viewPhotoThumbnail(albumId, startPhoto, perPagePhoto);
			return photoList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看照片缩略图时出现异常！");
		}
	}

	/**
	 * 查看照片
	 */
	public List viewPhoto(Integer photoId) throws Exception {
		try {
			List photoList = photoDao.viewPhoto(photoId);
			return photoList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看照片时出现异常！");
		}
	}

	/**
	 * 照片上传
	 */
	public Integer photoUpload(String rawPhotoName, String photoName, String photoDescription, Integer ownAlbumId, String uploadDate) throws Exception {
		try {
			PhotoBean p = new PhotoBean();
			p.setRawPhotoName(rawPhotoName);
			p.setPhotoName(photoName);
			p.setPhotoDescription(photoDescription);
			p.setOwnAlbumId(ownAlbumId);
			p.setUploadDate(uploadDate);
			photoDao.photoUpload(p);
			return p.getPhotoId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("上传照片时出现异常！");
		}
	}
	/**
	 * 照片张数
	 */
	public Integer[] photoNumber(Integer[] albumIds) throws Exception {
		try {
			Integer[] photoNumber = photoDao.photoNumber(albumIds);
			return photoNumber;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("照片张数时出现异常！");
		}
	}
	
	
	/**
	 * 获取单次上传照片张数
	 */
	public Integer uploadPhotoNumber(Integer ownAlbumId, String uploadDate) throws Exception {
		try {
			Integer photoNumber = photoDao.uploadPhotoNumber(ownAlbumId, uploadDate);
			return photoNumber;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取单次上传照片张数时出现异常！");
		}
	}
	

	/**
	 * 批量保存照片信息
	 */
	public Integer savePhotoInfo(String rawPhotoName, String photoDescription, Integer ownAlbumId, String uploadDate) throws Exception {
		try {
			PhotoBean p = new PhotoBean();
			p.setRawPhotoName(rawPhotoName);
			p.setPhotoDescription(photoDescription);
			p.setOwnAlbumId(ownAlbumId);
			p.setUploadDate(uploadDate);
			photoDao.savePhotoInfo(p);
			return p.getPhotoId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("批量保存照片信息时出现异常！");
		}
	}
	
	/**
	 * 照片总数[用于分页]
	 */
	public Integer photoSumCount(Integer ownAlbumId) throws Exception {
		try {
			Integer sumPhotoCount = photoDao.photoSumCount(ownAlbumId);
			return sumPhotoCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("照片总数时出现异常！");
		}
	}
	
	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	public PhotoDao getPhotoDao() {
		return photoDao;
	}

	/**
	 * 照片张数
	 */
	public Integer photoNumber(Integer albumId) throws Exception {
		try {
			Integer photoNumber = photoDao.photoNumber(albumId);
			return photoNumber;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("照片张数时出现异常！");
		}
	}
}
