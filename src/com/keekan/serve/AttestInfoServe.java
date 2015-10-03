package com.keekan.serve;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 验证信息的Service接口 <br>
 */
public interface AttestInfoServe {

	/**
	 * 添加验证信息
	 * @param keeno
	 * @param groupId
	 * @param friendKeeno
	 * @param remarkInfo
	 * @param attestInfo
	 * @param infoStatus
	 * @param infoDate
	 * @return
	 * @throws Exception
	 */
	Integer addAlbumCover(Integer keeno, Integer groupId, Integer friendKeeno, String remarkInfo, String attestInfo, String infoStatus, String infoDate) throws Exception;
}
