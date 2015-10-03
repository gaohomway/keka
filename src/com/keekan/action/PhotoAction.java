package com.keekan.action;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.keekan.bean.AlbumBean;
import com.keekan.bean.AlbumCoverBase;
import com.keekan.bean.AlbumGroupBean;
import com.keekan.bean.PhotoBean;
import com.keekan.bean.PhotoReviewBean;
import com.keekan.tool.BaseTools;
import com.keekan.tool.DateTime;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 照片Action<br>
 */
@SuppressWarnings("unchecked")
public class PhotoAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private Integer albumId;					//相册ID
	private Integer photoId;					//照片ID
	private List<PhotoBean> photoList;			//照片List
	private List albumList;						//相册名字List
	private List albumGroupList;				//相册分组List
	private List reviewList;					//评论List
	private List userList;						//评论者List
	private List userReview;					//评论这List
	
	private List avatar;						//头像
	private List avatarReview;					//评论者头像
	private List avatarList;					//头像List
	private List replyList;						//回复List
	private List<AlbumCoverBase> albumCoverList;//相册封面List
	private String uploadDate;					//上传日期
	private String uploadTime;					//上传时间
	private String photoCount;					//照片张数
	private String ownAlbumId;					//所属相册ID
	private Integer photoNumber;				//照片张数
	private String photoName;					//照片名字
	private String rawPhotoName;				//照片名字
	private String photoDescription;			//照片描述
	private String status;						//相册封面状态
	
	//分页变量
	private Integer sumPhoto;					//总条数
	private Integer sumPage;					//总页数
	private Integer startPhoto;					//开始照片数
	private Integer perPagePhoto = 21;			//每页数
	private String pageId;						//查看页数
	
	/**
	 * 照片上传初始化
	 * @return
	 * @throws Exception
	 */
	public String photoUpload() throws Exception {
		keeno = (Integer)BaseTools.getSessionAttribute("keeno");
		
		albumGroupList = albumGroupServe.viewAllAlbumGroup(keeno);
		Integer[] albumGroupIds = new Integer[albumGroupList.size()];
		int i = 0;
		for (AlbumGroupBean a : (List<AlbumGroupBean>)albumGroupList) {
			albumGroupIds[i] = a.getAlbumGroupId();
			i++;
		}
		albumList = albumServe.viewAllAlbum(albumGroupIds);

		Integer[] albumIds = new Integer[albumList.size()];
		int j = 0;
		for (AlbumBean a : (List<AlbumBean>)albumList) {
			albumIds[j] = a.getAlbumId();
			j++;
		}
		
		albumCoverList = albumCoverServe.viewAlbumCover(albumIds);
		
		uploadDate = DateTime.getYMD();
		uploadTime = DateTime.getHMS();
		if (albumList != null && albumList.size() >= 1 ) {
			return "success";
		}else {
			return "fails";
		}
	}
	
	/**
	 * 照片上传完成
	 * @return
	 * @throws Exception
	 */
	public String photoUpFinish() throws Exception{
		
		HttpServletRequest request = BaseTools.getRequest();
		ownAlbumId = request.getParameter("ownAlbumId");
		uploadDate = request.getParameter("uploadDate");
		uploadTime = request.getParameter("uploadTime");
		
		//更新相册封面
		albumCoverList = albumCoverServe.viewAlbumCover(Integer.valueOf(ownAlbumId));
		status = albumCoverList.get(0).getStatus();
		if (status.equals("a")) {			//a:初始化添加
			//随机相册封面
			photoList = albumCoverServe.randomAlbumCover(Integer.valueOf(ownAlbumId), uploadDate+" "+uploadTime);
			photoName = photoList.get(new Random().nextInt(photoList.size())).getPhotoName();
			albumCoverList.get(0).setStatus("b");
			albumCoverList.get(0).setPhotoName(photoName);
			albumCoverServe.editAlbumCover(albumCoverList);
		}else if (status.equals("b")) {		//b:随机生成
			
		}else if (status.equals("c")) {		//c:用户设置
			
		}
		//查询此次上传照片张数
		photoNumber = photoServe.uploadPhotoNumber(Integer.valueOf(ownAlbumId), uploadDate+" "+uploadTime);
		return "success";
	}
	
	/**
	 * 保存照片信息
	 * @return
	 * @throws Exception
	 */
	public String savePhotoInfo() throws Exception{
		
		photoServe.savePhotoInfo(rawPhotoName, photoDescription,Integer.valueOf(ownAlbumId), uploadDate+" "+uploadTime);
		return SUCCESS;
	}
	
	/**
	 * 查看照片缩略图
	 * @return
	 * @throws Exception
	 */
	public String viewPhotoThum() throws Exception {
		keeno = (Integer)BaseTools.getSessionAttribute("keeno");
		sumPhoto = photoServe.photoSumCount(albumId);
		if (sumPhoto <= perPagePhoto) {
			startPhoto = 0;
			perPagePhoto = sumPhoto;
		}
		albumList = albumServe.viewAlbumByAlbumId(albumId);
		albumCoverList = albumCoverServe.viewAlbumCover(albumId);
		photoList = photoServe.viewPhotoThumbnail(albumId, startPhoto, perPagePhoto);
		photoNumber = photoServe.photoNumber(albumId);
		sumPage =  Integer.valueOf((int) Math.ceil(Double.parseDouble(String.valueOf(sumPhoto)) / Double.parseDouble(String.valueOf(perPagePhoto)))) ; 
		return SUCCESS;
	}
	
	/**
	 * 查看照片缩略图
	 * @return
	 * @throws Exception
	 */
	public String viewPhotoPage() throws Exception {
		keeno = (Integer)BaseTools.getSessionAttribute("keeno");
		sumPhoto = photoServe.photoSumCount(albumId);
		startPhoto = (Integer.valueOf(pageId) - 1) * perPagePhoto; 
		photoList = photoServe.viewPhotoThumbnail(albumId, startPhoto, perPagePhoto);
		sumPage =  Integer.valueOf((int) Math.ceil(Double.parseDouble(String.valueOf(sumPhoto)) / Double.parseDouble(String.valueOf(perPagePhoto)))) ; 
		return SUCCESS;
	}
	
	
	/**
	 * 查看单张照片及评论
	 * @return
	 * @throws Exception
	 */
	public String viewPhotoAndReview() throws Exception {
		keeno = (Integer)BaseTools.getSessionAttribute("keeno");
		avatar = avatarServe.viewAvatar(keeno);
		userList = userServe.viewUser(keeno);
		
		photoList = photoServe.viewPhoto(photoId);
		reviewList = photoReviewServe.viewReview(photoId);
		
		if (reviewList != null) {
			Integer[] reviewKeeno = new Integer[reviewList.size()];
			int i = 0;
			for (PhotoReviewBean p : (List<PhotoReviewBean>)reviewList) {
				reviewKeeno[i] = p.getReviewKeeno();
				i++;
			}
			avatarReview = avatarServe.viewAllAvatar(reviewKeeno);
			userReview = userServe.viewUserByCarte(reviewKeeno);
		}
		
		
		
		//replyList = photoReviewServe.viewReview(photoId);
		
		/*if (replyList  != null) {
			Integer[] commentId = new Integer[replyList.size()];
			int i = 0;
			for (PhotoReviewBean p : (List<PhotoReviewBean>)replyList ) {
				commentId[i] = p.getReviewId();
				i++;
			}
			replyList = photoCommentReplyServe.viewCommentReply(commentId);
			Integer[] keeno = new Integer[replyList .size()];
			int j = 0;
			for (PhotoReviewBean p : (List<PhotoReviewBean>)replyList ) {
				keeno[j] = p.getReviewKeeno();
				j++;
			}
			for (PhotoCommentReplyBean p : (List<PhotoCommentReplyBean>)replyList) {
				keeno[j] = p.getReplyKeeno();
				j++;
			}
			userList = userServe.viewUserByCarte(keeno);
			avatarList = avatarServe.viewAllAvatar(keeno);
		}*/
		
		int id = 4;
		if (id > 0) {
			return SUCCESS;
		}else {
			return "failure";
		}
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public List<PhotoBean> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<PhotoBean> photoList) {
		this.photoList = photoList;
	}

	public List getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List albumList) {
		this.albumList = albumList;
	}

	public List getAlbumGroupList() {
		return albumGroupList;
	}

	public void setAlbumGroupList(List albumGroupList) {
		this.albumGroupList = albumGroupList;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public List getAvatarList() {
		return avatarList;
	}

	public void setAvatarList(List avatarList) {
		this.avatarList = avatarList;
	}

	public List getReplyList() {
		return replyList;
	}

	public void setReplyList(List replyList) {
		this.replyList = replyList;
	}

	public List<AlbumCoverBase> getAlbumCoverList() {
		return albumCoverList;
	}

	public void setAlbumCoverList(List<AlbumCoverBase> albumCoverList) {
		this.albumCoverList = albumCoverList;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(String photoCount) {
		this.photoCount = photoCount;
	}

	public String getOwnAlbumId() {
		return ownAlbumId;
	}

	public void setOwnAlbumId(String ownAlbumId) {
		this.ownAlbumId = ownAlbumId;
	}

	public Integer getPhotoNumber() {
		return photoNumber;
	}

	public void setPhotoNumber(Integer photoNumber) {
		this.photoNumber = photoNumber;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getRawPhotoName() {
		return rawPhotoName;
	}

	public void setRawPhotoName(String rawPhotoName) {
		this.rawPhotoName = rawPhotoName;
	}

	public String getPhotoDescription() {
		return photoDescription;
	}

	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSumPhoto() {
		return sumPhoto;
	}

	public void setSumPhoto(Integer sumPhoto) {
		this.sumPhoto = sumPhoto;
	}

	public Integer getSumPage() {
		return sumPage;
	}

	public void setSumPage(Integer sumPage) {
		this.sumPage = sumPage;
	}

	public Integer getStartPhoto() {
		return startPhoto;
	}

	public void setStartPhoto(Integer startPhoto) {
		this.startPhoto = startPhoto;
	}

	public Integer getPerPagePhoto() {
		return perPagePhoto;
	}

	public void setPerPagePhoto(Integer perPagePhoto) {
		this.perPagePhoto = perPagePhoto;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setAvatar(List avatar) {
		this.avatar = avatar;
	}

	public List getAvatar() {
		return avatar;
	}

	public void setReviewList(List reviewList) {
		this.reviewList = reviewList;
	}

	public List getReviewList() {
		return reviewList;
	}

	public void setAvatarReview(List avatarReview) {
		this.avatarReview = avatarReview;
	}

	public List getAvatarReview() {
		return avatarReview;
	}

	public void setUserReview(List userReview) {
		this.userReview = userReview;
	}

	public List getUserReview() {
		return userReview;
	}
}
