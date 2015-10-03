package com.keekan.serve.impl;

import java.util.List;
import com.keekan.bean.AlbumGroupBean;
import com.keekan.dao.AlbumGroupDao;
import com.keekan.serve.AlbumGroupServe;

@SuppressWarnings("unchecked")
public class AlbumGroupServeImpl implements AlbumGroupServe{
	
	private AlbumGroupDao albumGroupDao;

	/**
	 * 添加相册分类
	 * @param keeNumber
	 * @param albumGroupName
	 */
	public Integer addAlbumGroup(Integer keeno, String albumGroupName) throws Exception {
		try {
			AlbumGroupBean a = new AlbumGroupBean();
			a.setKeeno(keeno);
			a.setAlbumGroupName(albumGroupName);
			albumGroupDao.addAlbumGroup(a);
			return a.getAlbumGroupId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加相册分类时出现异常");
		}
	}
	
	/**
	 * 查看全部相册
	 * @param keeNumber
	 */
	public List viewAllAlbumGroup(Integer keeno) throws Exception {
		try {
			List albumGroupList = albumGroupDao.viewAllAlbumGroup(keeno);
			if (albumGroupList != null) {
				return albumGroupList;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看全部相册分类时出现异常");
		}
	}

	/**
	 * 删除相册分类
	 */
	public Integer deleteAlbumGroup(Integer keeno, Integer albumGroupId) throws Exception {
		try {
			AlbumGroupBean a = new AlbumGroupBean();
			a.setKeeno(keeno);
			a.setAlbumGroupId(albumGroupId);
			albumGroupDao.deleteAlbumGroup(a);
			return a.getAlbumGroupId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("删除相册分类时出现异常");
		}
	}
	
	/**
	 * 编辑相册分类
	 */
	public Integer editAlbumGroup(Integer keeno, Integer albumGroupId, String albumGroupName) throws Exception {
		try {
			AlbumGroupBean a = new AlbumGroupBean();
			a.setKeeno(keeno);
			a.setAlbumGroupId(albumGroupId);
			a.setAlbumGroupName(albumGroupName);
			albumGroupDao.editAlbumGroup(a);
			return a.getAlbumGroupId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("编辑相册分类时出现异常");
		}
	}
	
	public void setAlbumGroupDao(AlbumGroupDao albumGroupDao) {
		this.albumGroupDao = albumGroupDao;
	}
}
