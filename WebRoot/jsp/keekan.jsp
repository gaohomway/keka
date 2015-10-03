<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<title>KEEKAN首页</title>
		<link rel="stylesheet" href="keekan/css/keekan.css" type="text/css"></link>
		<script src="keekan/js/select/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/select/datePicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/select/locationPicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/select/locationData.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/recaptcha.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<s:div cssClass="logo-bar">
			<s:div cssClass="kk-bar"></s:div>
			<font class="kk-font">KK</font>
			<font class="keekan-font">KEEKAN</font>
		</s:div>
		<div class="login-regist-back">
			<div class="loginregist-back-fixed">
			<form action="LoginAction.html" method="post">
				<dl class="login-dl">
					<dt class="login-tit-dt">
						<font class="login-title">登 录</font>
					</dt>
					<dt>
						<label for="keeNumber">帐号： </label><s:actionerror/>
						<s:textfield name="keeNumber" id="keeNumber" value="11855" cssClass="input-box"></s:textfield>
					</dt>
					<dt>
						<label for="password">密码：</label>
						<s:password name="password" id="password" value="99" cssClass="input-box"></s:password>
					</dt>
					<dt>
						<label>保持登录状态：<s:checkbox name="keepLogin"></s:checkbox></label>
						<label><a href="#" class="account-help-a">无法登录您的帐号？</a></label>
					</dt>
					<dd style="text-align: right; padding-top: 5px">
						<s:submit cssClass="login-butt" value="登录"></s:submit>
					</dd>
				</dl>
			</form>
			 
			<form action="RegisterAction!registerProcess.html" method="post" >
				<dl class="regist-dl">
					<dt class="regist-tit-dt">
						<font class="regist-title">注  册</font>
					</dt>
					<dt>
						<label for="nickname">昵称：</label>
						<s:textfield name="nickname" id="nickname" value="keekan" cssClass="input-box"></s:textfield>
					</dt>
					<dt>
						<label>性别：</label>
					</dt>
					<dd>
						<s:select list="{'男','女'}" name="sex" cssClass="default" tabindex="1" cssStyle="width: 70px"></s:select>
					</dd>
					<dt>
						<label>生日：</label>
					</dt>
					<dd>
						<s:select list="{'年'}" name="year" id="yearid" cssStyle="width:70px"></s:select>
						<s:select list="{'月'}" name="month" id="monthId" cssStyle="width:70px"></s:select>
						<s:select list="{'日'}" name="day" id="dayId" cssStyle="width:70px"></s:select>
					</dd>
					<dt>
						<label>所在地：</label>
					</dt>
					<dd>
						<s:select list="{'国家'}" name="country" id="countryId" cssStyle="width:70px"></s:select>
						<s:select list="{'省'}" name="town" id="townId"  cssStyle="width:70px"></s:select>
						<s:select list="{'市'}" name="district" id="districtId"  cssStyle="width:70px"></s:select>
					</dd>
					<dt>
						<label for="password">设置密码：</label>
						<s:password cssClass="input-box" name="password" value="979899"></s:password>
					</dt>
					<dt>
						<label for="confirmPassword">确认密码：</label>
						<s:password cssClass="input-box" name="confirmPassword" value="979899"></s:password>
					</dt>
					<dt>
						<label for="email">邮件地址：</label>
						<s:textfield cssClass="input-box" name="email" value="duanhaisi@gmail.com"></s:textfield>
					</dt>
					<dt>
						<label for="vercode">验证码：</label>
						<s:textfield cssClass="input-box-rec" name="vercode"></s:textfield>
						<img src="authImg" id="authImg" style="vertical-align: bottom;" />
						<a class="recaptcha" title="获取新的验证码" onclick="refresh()"></a>
					</dt>
					<dt>
						<label for="agreement">同意：</label>
						<a href="#" class="kk-agreement-a">可可卡诺用户使用协议</a>
						<s:checkbox name="agreement"></s:checkbox>
					</dt>
					<dd style="text-align: right; padding-top: 5px">
						<s:submit cssClass="regist-butt" value="注册"></s:submit>
					</dd>
				</dl>
			</form>
			</div>
		</div>
	</body>
</html>
