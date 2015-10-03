<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<title><s:text name="loginTitle"/></title>
		<link rel="stylesheet" href="css/account/login.css" type="text/css" />
		<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/account/login.js" type="text/javascript" charset="utf-8"></script>
	</head>

<body>
	<img src="img/login_background2.jpg" width="100%" height="100%" style="z-index:-100;position:absolute;left:0;top:0">
	 <div class="kanLogo">
	 	 <img src="img/logo/keekan_logo_blue.png"></img>
	 </div>
	 <div class="loginBox">
	 	<%--<div class="avatar">
	 		<img src="img/logo/kan_avatar.png"></img>
	 	</div>--%>
	 	
	 	<div class="login">
	 		<s:if test="error != null  || keeno == null ">
	 			<form action="login.html" method="post" onsubmit="return check(this)">
			 		<div class="keenoPasswordBox">
			 			<input type="text" name="keeno" value="<s:property value="keeno"/>" class="keeno"/>
			 			<div></div>
			 			<input type="password" name="password" value="" onpaste="return false" oncopy="return false" class="password"/>
			 		</div>
			 		<div class="error">
			 			<s:property value="error"/>
			 		</div>
			 		<div class="operateK">
		 				<s:checkbox name="keepLogin" title="记住登录状态"></s:checkbox>&nbsp;<label for="keepLogin">记住密码</label>
		 				<input type="button" class="ask" title="无法访问账号"/>
		 				<input type="submit" value="登录"/>
		 			</div>
	 			</form>
	 		</s:if>
	 		<s:if test="(error == null ) && (keeno != null ) ">
	 			<div class="avatarBox">
 					<div class="avatar">
 						<s:iterator value="avatarList">
							<img src="<s:text name="kanPath"/><s:property value="#session.keeno"/>/avatar/<s:property value="midAvatar"/>" />
						</s:iterator>
					</div>
					<div class="nickname">
						<s:iterator value="userList">
							<p><s:property value="nickname"/></p>
							<p class="keeno"><s:property value="keeno"/></p>
						</s:iterator>
					</div>
		 		</div>
		 		<div class="operateA">
		 			<form action="myka.html" method="post">
						<a href="logout.html">其他账号登录</a><input type="submit" value="快速登录"/>
		 			</form>
				</div>
	 		</s:if>
	 		
	 	</div>
	 </div>
</body>
</html>
