<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <title>好友</title>
    <base href="<s:text name="basePath"/>">
    <link rel="stylesheet" href="css/friend/friend.css" />
    <script src="js/jquery/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    <%--
    <script src="js/friend/ajax-pushlet-client.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/friend/friend.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/jquery.scroll.js"  type="text/javascript" charset="utf-8"></script>--%>
    <script src="js/friend/friend.js" type="text/javascript" charset="utf-8"></script>
	
  </head>
  
  <body>
  	<input type="hidden" value="<s:property value="#session.keeno"/>" id="keeno"/>
	<div class="friendCard">
		<div class="friendList" >
			<div class="friendTabHead">
				<ul class="tabMenu">
					<li class="friendListLi">
						好友列表
					</li>
					<li class="chatListLi">
						正在交谈
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
				<div class="friendManage" id="noEdit"></div>
				<div class="friendManageBox">
					<div class="menu" id="friendFind">查找好友</div>
					<div class="menu" id="addGroup">添加分组</div>
					<div class="menu" id="deleteGroup">删除分组</div>
					<div class="menu" id="editGroup">编辑分组</div>
				</div>
			</div>
		</div>
		
		<div class="chatMainBox" id="no">
			<div class="nickname-tab">
				<ul class="nickname-ul">
					
				</ul>
			</div>
			<div class="chat-tab">
			
			</div>
		</div>
		<!-- 查找好友区域 -->
		<div class="friendFindBox">
			
		</div>
		
		<div class="taskbarBox">
			
		</div>
	</div>
	 <div id="friendGroupCM">
		<ul>
			<li id="rename">
				<a >添加分组</a>
			</li>
			<li id="rename">
				<a >删除该组</a>
			</li>
			<li id="rename">
				<a >重命名</a>
			</li>
		</ul>
	</div>
  </body>
</html>
