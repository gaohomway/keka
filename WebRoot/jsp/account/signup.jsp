<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
	<head>
		<title>Keekan 注册</title>
		<base href="<s:text name="basePath"/>">
		<link rel="stylesheet" href="css/account/signup.css" type="text/css" />
		<link rel="stylesheet" href="css/account/passwordStrength.css" type="text/css" />
		<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/account/datepicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/account/localpicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/account/localData.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/account/passwordStrength.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/account/signup.js" type="text/javascript" charset="utf-8"></script>
	</head>

<body>
	<div class="kanHeadBar">
		<div class="kanLogo">
			<img src="img/logo/keekan_logo_blue.png"></img>
		</div>
	</div>
	<div class="joinMainBox">
		<div class="">
			<s:actionerror cssClass="checkError"/>
		</div>
		<div class="signupBox">
			<div class="nicknameBox">
				<label for="nickname">昵称</label><br />
				<s:textfield name="nickname"></s:textfield>
			</div>
			<div class="sexBox">
				<label>性别</label>
				<s:select list="{'男','女'}" name="sex" cssStyle="width: 300px"></s:select>
			</div>
			<div class="birthdayBox">
				<label>生日</label><br />
				<select  name="year" id="yearid" >
					<option value="0">年</option>
				</select>
				<select  name="month" id="monthId" >
					<option value="0">月</option>
				</select>
				<select  name="day" id="dayId" >
					<option value="0">日</option>
				</select>
			</div>
			<div class="locationBox">
				<label>所在地</label><br />
				<select  name="nation" id="countryId" >
					<option value="0">国家</option>
				</select>
				<select name="city" id="townId" ></select>
				<select name="area" id="districtId" ></select>
			</div>
			<div class="passwordBox">
					<label for="password">设置密码</label><br />
					<s:password name="password" cssClass="password_adv"></s:password>
			</div>
			<div class="confirmPasswordBox">
				<label for="confirmPassword">确认密码</label><br />
				<s:password name="confirmPassword" ></s:password>
			</div>
			<div class="emailBox">
				<label for="email">邮件地址</label><br />
				<s:textfield name="email" ></s:textfield>
			</div>
			<div class="recaptchaBox">
				<label for="vercode">验证码</label><br />
				<img src="authImg" id="authImg" />
				<s:textfield name="vercode"></s:textfield>
				<div class="refresh">
					<img src="img/recaptcha-sprite.png" title="获取新的验证码" ></img>
				</div>
			</div>
			<div class="agreementBox">
				<input type="checkbox" name="agreement" id="agreement" style="clip: rect(6 15 15 6)"/>
				<label for="agreement">同意接受&nbsp;Keekan&nbsp;<a href="#">服务条款</a></label>
			</div>
			<div class="operateBox">
				<input type="button" value="注册" id="joinId"/>
			</div>
		</div>
	</div>
	<div class="copyrightBox"> 
	
	</div>
</body>
</html>
