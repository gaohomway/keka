package com.keekan.action;

import com.keekan.serve.AdorePhotoServe;
import com.keekan.serve.AdoreServe;
import com.keekan.serve.AlbumCoverServe;
import com.keekan.serve.AlbumGroupServe;
import com.keekan.serve.AlbumServe;
import com.keekan.serve.AttestInfoServe;
import com.keekan.serve.AvatarServe;
import com.keekan.serve.FriendGroupServe;
import com.keekan.serve.FriendServe;
import com.keekan.serve.IndexServe;
import com.keekan.serve.KeenoPoolServe;
import com.keekan.serve.LoginServe;
import com.keekan.serve.MessageBoardServe;
import com.keekan.serve.NavigateServe;
import com.keekan.serve.PhotoCommentReplyServe;
import com.keekan.serve.PhotoReviewServe;
import com.keekan.serve.PhotoServe;
import com.keekan.serve.SignupServe;
import com.keekan.serve.StatusServe;
import com.keekan.serve.TagServe;
import com.keekan.serve.UserServe;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: BaseAction<br>
 */
public class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	protected Integer keeno;
	protected UserServe userServe;
	protected IndexServe indexServe;
	protected SignupServe signupServe;
	protected KeenoPoolServe KeenoPoolServe;
	protected LoginServe loginServe;
	protected AlbumServe albumServe;
	protected AlbumGroupServe albumGroupServe;
	protected PhotoServe photoServe;
	protected MessageBoardServe messageBoardServe;
	protected FriendGroupServe friendGroupServe;
	protected FriendServe friendServe;
	protected AvatarServe avatarServe;
	protected NavigateServe navigateServe;
	protected PhotoReviewServe photoReviewServe;
	protected PhotoCommentReplyServe photoCommentReplyServe;
	protected StatusServe statusServe;
	protected AlbumCoverServe albumCoverServe;
	protected AttestInfoServe attestInfoServe;
	protected TagServe tagServe;
	protected AdoreServe adoreServe ;
	protected AdorePhotoServe adorePhotoServe ;
	
	public void setAdoreServe(AdoreServe adoreServe) {
		this.adoreServe = adoreServe;
	}
	public void setAdorePhotoServe(AdorePhotoServe adorePhotoServe) {
		this.adorePhotoServe = adorePhotoServe;
	}
	public void setTagServe(TagServe tagServe) {
		this.tagServe = tagServe;
	}
	public void setAttestInfoServe(AttestInfoServe attestInfoServe) {
		this.attestInfoServe = attestInfoServe;
	}
	public void setAlbumCoverServe(AlbumCoverServe albumCoverServe) {
		this.albumCoverServe = albumCoverServe;
	}
	public void setStatusServe(StatusServe statusServe) {
		this.statusServe = statusServe;
	}
	public void setPhotoCommentReplyServe(PhotoCommentReplyServe photoCommentReplyServe) {
		this.photoCommentReplyServe = photoCommentReplyServe;
	}
	public void setUserServe(UserServe userServe) {
		this.userServe = userServe;
	}
	public void setMessageBoardServe(MessageBoardServe messageBoardServe) {
		this.messageBoardServe = messageBoardServe;
	}
	public void setIndexServe(IndexServe indexServe) {
		this.indexServe = indexServe;
	}
	public void setSignupServe(SignupServe signupServe) {
		this.signupServe = signupServe;
	}
	public void setKeenoPoolServe(KeenoPoolServe keenoPoolServe) {
		KeenoPoolServe = keenoPoolServe;
	}
	public void setLoginServe(LoginServe loginServe) {
		this.loginServe = loginServe;
	}
	public void setAlbumServe(AlbumServe albumServe) {
		this.albumServe = albumServe;
	}
	public void setAlbumGroupServe(AlbumGroupServe albumGroupServe) {
		this.albumGroupServe = albumGroupServe;
	}
	public void setPhotoServe(PhotoServe photoServe) {
		this.photoServe = photoServe;
	}
	public void setFriendGroupServe(FriendGroupServe friendGroupServe) {
		this.friendGroupServe = friendGroupServe;
	}
	public void setFriendServe(FriendServe friendServe) {
		this.friendServe = friendServe;
	}
	public void setAvatarServe(AvatarServe avatarServe) {
		this.avatarServe = avatarServe;
	}
	public void setNavigateServe(NavigateServe navigateServe) {
		this.navigateServe = navigateServe;
	}
	public void setPhotoReviewServe(PhotoReviewServe photoReviewServe) {
		this.photoReviewServe = photoReviewServe;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
}