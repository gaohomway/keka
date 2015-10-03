<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>myka</title>
		<base href="<s:text name="basePath"/>">
		<link href="css/myka.css" rel="stylesheet" type="text/css"/>
		<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/myka.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<!-- My kan head box -->
		<div class="mykaHeadBox">
			<div class="mykaHead">
				<div class="avatarBox" id="<s:property value="#session.keeno"/>">
					<s:iterator value="avatarList">
						<img class="avatar" src="<s:text name="kanPath"/><s:property value="#session.keeno"/>/avatar/<s:property value="bigAvatar"/>" id="avatar" />
					</s:iterator>
				</div>
				<div class="navigateBox">
					<s:iterator value="navigateList">
						<div class="navigate-item" title="<s:property value="navigateName"/>" id="<s:property value="navigateURL"/>">
							 <s:property value="navigateName"/>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
		
		<div class="mykaBody">
		
		</div>
		
		
		
		
		
		
		
		
		
		
		
		<%--<div class="keeBox">
			<p><a href="#">关于可可卡诺</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">About Keekan</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">服务协议</a>&nbsp;&nbsp;|&nbsp;<a href="#">隐私权保护</a></p>
			<p>Copyright © 2012 - 2013&nbsp;&nbsp;Keekan. <a href="#">All Rights Reserved.</a></p>
			<p>可可卡诺公司&nbsp;&nbsp;<a href="#">版权所有</a></p>
		</div>--%>
	</body>
	 
</html>
