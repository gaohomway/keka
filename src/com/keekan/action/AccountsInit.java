package com.keekan.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.keekan.tool.BaseTools;
import com.keekan.tool.Configurats;
import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 首次使用初始化Action<br>
 */
public class AccountsInit extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer statusId;		// 状态ID
	private String status;			// 状态[a:在线, b:离开, c:忙碌, d:勿打扰, e:隐身, f:离线, g:添加]
	private String statusInfo;		// 添加的信息
	private String statusDate;		// 最新状态时间
	private String createDate;		// 创建日期
	private String updateDate;		// 更新时间
	private Integer albumGroupId;	// 相册分类ID
	private String keenoFilePath;	// kee文件路径
	private Integer albumId;		//相册ID
	
	/**
	 * 帐号初始化
	 * @return
	 * @throws Exception
	 */
	public String accountsInit() throws Exception {
		keeno = (Integer) BaseTools.getSessionAttribute("keeno");
		
		//初始化用户文件夹
		String userFilePath = Configurats.getFilePath("USER_FILE");
		
		File file=new File(userFilePath+keeno);
	    if (!file.exists()) {
	    
			String[] fileName = {"", "/avatar", "/photo", "/photo_thum", "/adore", "/adore_thum"};
			for (int i = 0; i < fileName.length; i++) {
				File files = new File(userFilePath+keeno+fileName[i]);
				files.mkdirs();
			}
			keenoFilePath = Configurats.getFilePath("KEE_NUMBER_FILE_PATH");
			//createKeenoFile(keeno);
			
			//头像初始化
			updateDate = DateTime.getDateTime();
			createDate = updateDate;
			avatarServe.initAddAvatar(keeno, "../../kan/avatar/avatar100.png", "../../kan/avatar/avatar50.png", "../../kan/avatar/avatar30.png", updateDate, "yes");
			
			//相册初始化
			albumGroupId = albumGroupServe.addAlbumGroup(keeno, "最爱");
			albumId = albumServe.addAlbum(keeno, "默认相册", "默认相册", albumGroupId, createDate, updateDate);
			
			//相册封面初始化
			albumCoverServe.addAlbumCover("../../kan/photo_thum/noPhoto.png", albumId, updateDate, "a");
			
			albumGroupServe.addAlbumGroup(keeno, "人物");
			albumGroupServe.addAlbumGroup(keeno, "风景");
			albumGroupId = albumGroupServe.addAlbumGroup(keeno, "其他");
			albumId = albumServe.addAlbum(keeno, "贴图相册", "贴图相册", albumGroupId, createDate, updateDate);
			
			//相册封面初始化
			albumCoverServe.addAlbumCover("../../kan/photo_thum/noPhoto.png", albumId, updateDate, "a");
			
			//初始化用户状态
			statusId = statusServe.initAddStatus(keeno, "a", statusInfo, updateDate);
			
			//好友初始化
			friendGroupServe.addFriendGroup(keeno, "我的好友", 1);
	    }
		return "initSuccess";
	}
	
	/**
	 * 创建用户文件夹
	 * @param keeno
	 * @return
	 * @throws Exception
	 */
	public String createKeenoFile(Integer keeno) throws Exception  {
		String keenoFilePathName = "keekan_" + keeno + ".txt";
		try {
			File f = new File(keenoFilePath + keenoFilePathName);
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("您注册的帐号为：" + keeno + "，请牢记，这是您登录KEEKAN的唯一帐号。");
			bw.close();
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("创建号码文件时出现异常！");
		}
		return null;
	}

	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getAlbumGroupId() {
		return albumGroupId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setAlbumGroupId(Integer albumGroupId) {
		this.albumGroupId = albumGroupId;
	}
	public String getKeenoFilePath() {
		return keenoFilePath;
	}
	public void setKeenoFilePath(String keenoFilePath) {
		this.keenoFilePath = keenoFilePath;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getAlbumId() {
		return albumId;
	}
}
