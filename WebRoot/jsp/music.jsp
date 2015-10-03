<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>音乐</title>
		<base href="<s:text name="basePath"/>">
		<link rel="stylesheet" href="css/music.css" />
		<script src="js/jquery/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    	<script src="js/carte.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="musicCard">
			<div class="musicListBox" >
				<div class="musicTabHead">
					<ul class="tabMenu">
						<li class="songSingle">
							歌单
						</li>
						<li class="trySongSingle">
							试听歌单
						</li>
					</ul>
				</div>
				<div class="friendTabBody">
					<div class="friendListBox">
						<s:iterator value="friendGroupList">
						<div class="friendGroup" id="group<s:property value="friendGroupId"/>" onselectstart="return false">
							<div class="groupName"><s:property value="friendGroupName"/></div>
						</div>
						<div class="friendBox" id="friendgroup<s:property value="friendGroupId"/>">
							<s:iterator value="friendList">
							<s:if test="ownFriendGroupId == friendGroupId">
							<div class="friend" id="<s:property value="friendKeeno"/>" onselectstart="return false">
								<div class="avatar">
									<s:iterator value="avatarList">
									<s:if test="friendKeeno == keeno">
										<img src="<s:text name="kanPath"/><s:property value="keeno"/>/avatar/<s:property value="midAvatar"/>" id="<s:property value="keeno"/>"></img>
									</s:if>
									</s:iterator>
								</div>
							<div class="nickname" id="<s:property value="friendId"/>">
								<s:property value="friendKeeno"/>
							</div>
						</div>
						</s:if>
						</s:iterator>
					</div>
					</s:iterator>
				</div>
				<div class="chatListBox">
					 
				</div>
			</div>
			<div class="friendMenu">
				<p class="addFriend">添加好友</p>
			</div>
		</div>
			</div>
		</div>
	</body>
</html>
