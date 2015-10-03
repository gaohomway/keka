<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>主页</title>
		<link id="ikeekan-main-css" href="keekan/css/home.css" rel="stylesheet" type="text/css"/>
		<script src="keekan/js/select/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/home.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="home-title-box">
			<h6>主页</h6>
		</div>
		<div class="home-main-box">
			<div class="home-left-box">
				<div class="avatar-main-box">
					<img src="keekan/img/avatar.jpg" alt="头像" />
				</div>
				<div class="friend-list-box">
					<s:iterator value="friendGroupList">
						<div class="group-board-box" id="<s:property value="friendGroupId"/>">
							<div class="arrow"></div>
							<div class="group-name">
								<s:property value="friendGroupName"/>
								<input type="hidden" value="<s:property value="keeNumber"/>"/>
								<input type="hidden" value="<s:property value="groupSorting"/>"/>
							</div>
						</div>
						<div class="friend-main-box" id="friendBoxId<s:property value="friendGroupId"/>">
							<s:iterator value="friendList">
								<s:if test="friendGroupId == belongFriendGroupId">
									<div class="friend-box">
										<div class="avatar-box">
											<img src="keekan/img/avatar.jpg" alt="好友头像" />
										</div>
										<input type="hidden" value="<s:property value="friendKeeNumber"/>"/>
									</div>
								</s:if>
							</s:iterator>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
	</body>
</html>
