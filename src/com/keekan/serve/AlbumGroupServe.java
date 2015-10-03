package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 相册分类的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface AlbumGroupServe {
	
	
	/**
	 * 添加相册分类
	 * @param keeno
	 * @param albumGroupName
	 */
	Integer addAlbumGroup(Integer keeno, String albumGroupName) throws Exception;
	
	/**
	 * 删除相册分类
	 * @param keeno
	 * @param albumGroupId
	 * @return
	 * @throws Exception
	 */
	Integer deleteAlbumGroup(Integer keeno, Integer albumGroupId) throws Exception;
	
	/**
	 * 编辑相册分类
	 * @return
	 * @throws Exception
	 */
	Integer editAlbumGroup(Integer keeno, Integer  albumGroupId, String albumGroupName) throws Exception;
	
	/**
	 * 查看全部相册
	 * @param keeno
	 */
	List viewAllAlbumGroup(Integer keeno) throws Exception;
}
