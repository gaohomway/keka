<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
  	<title>名片</title>
  	<base href="<s:text name="basePath"/>">
    <link rel="stylesheet" href="css/carte.css" />
    <script src="js/jquery/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/carte.js" type="text/javascript" charset="utf-8"></script>
  </head>
  
  <body>
  	<div class="carteCard">
  		<div class="carteMenu">
			<div class="button buttonFocus" id="baseInfo">基本信息</div>
			<div class="button" id="profile">形象展示</div>
			<div class="button buttonFocus" id="moreInfo">详细信息</div>
			<div class="button" id="hobby">兴趣爱好</div>
  		</div>
  		<div class="carteBox">
  			<s:iterator value="userList">
  			<div class="baseInfoBox">
				<div class="nameBox">
	  				<div class="nameTitle">
	  					<p>中/英文名</p>
	  				</div>
	  				<div class="name">
	  					<p><s:property value="name"/>&nbsp;&nbsp;<s:property value="englishName"/></p>
	  				</div>
	  			</div>
	  			<div class="sexBox">
	  				<div class="sexTitle">
	  					<p>性别</p>
	  				</div>
	  				<div class="sex">
	  					<p><s:property value="sex"/></p>
	  				</div>
	  			</div>
	  			
	  			<div class="birthdayBox">
	  				<div class="birthdayTitle">
	  					<p>生日/年龄</p>
	  				</div>
	  				<div class="birthday">
	  					<p><s:property value="birthday"/>&nbsp;&nbsp;<s:property value="age"/>岁</p>
	  				</div>
	  			</div>
	  			
	  			<div class="zodiacConstellationBox">
	  				<div class="zodiacConstellationTitle">
	  					<p>生肖/星座</p>
	  				</div>
	  				<div class="zodiacConstellation">
	  					<p><s:property value="zodiac"/>&nbsp;&nbsp;<s:property value="constellation"/></p>
	  				</div>
	  			</div>
	  			
	  			<div class="bloodTypeBox">
	  				<div class="bloodTypeTitle">
	  					<p>血型</p>
	  				</div>
	  				<div class="bloodType">
	  					<p><s:property value="bloodType"/></p>
	  				</div>
	  			</div>
	  			
	  			<div class="feelingBox">
	  				<div class="feelingTitle">
	  					<p>感情状态/宣言</p>
	  				</div>
	  				<div class="feeling">
	  					<p><s:property value="bloodType"/>&nbsp;&nbsp;<s:property value="feelinProclaim"/></p>
	  				</div>
	  			</div>
	  			
	  			<div class="habitBox">
	  				<div class="habitTitle">
	  					<p>习惯</p>
	  				</div>
	  				<div class="habit">
	  					<p><s:property value="smoke"/>&nbsp;&nbsp;<s:property value="drink"/>&nbsp;&nbsp;<s:property value="sleep"/></p>
	  				</div>
	  			</div>
	  			
	  			<div class="addressBox">
	  				<div class="addressTitle">
	  					<p>所在地</p>
	  				</div>
	  				<div class="address">
	  					<p><s:property value="nation"/>&nbsp;&nbsp;<s:property value="city"/>&nbsp;&nbsp;<s:property value="area"/></p>
	  				</div>
	  			</div>
	  			<div class="homelandBox">
	  				<div class="homelandTitle">
	  					<p>故乡</p>
	  				</div>
	  				<div class="homeland">
	  					<p><s:property value="homeNation"/>&nbsp;&nbsp;<s:property value="homeCity"/>&nbsp;&nbsp;<s:property value="homeArea"/></p>
	  				</div>
	  			</div>
	  			
	  			<div class="explainBox">
	  				<div class="explainTitle">
	  					<p>个人说明</p>
	  				</div>
	  				<div class="explain">
	  					<p><s:property value="explains"/></p>
	  				</div>
	  			</div>
	  			
  			</div>
  			<div class="profileBox">
  				<div>
	  				<img src="img/000.jpg"></img>
  				</div>
  			</div>
  			<div class="moreInfoBox">
  				<div class="telephoneBox">
  					<div class="telephoneTitle">
  						<p>电话</p>
  					</div>
  					<div class="telephone">
  						<p><s:property value="telephone"/></p>
  					</div>
  				</div>
  				<div class="mobileNumberBox">
  					<div class="mobileNumberTitle">
  						<p>手机</p>
  					</div>
  					<div class="mobileNumber">
  						<p><s:property value="mobileNumber"/></p>
  					</div>
  				</div>
  				
  				<div class="emailBox">
  					<div class="emailTitle">
  						<p>邮箱</p>
  					</div>
  					<div class="email">
  						<p><s:property value="email"/></p>
  					</div>
  				</div>
  				
  				<div class="homepageBox">
  					<div class="homepageTitle">
  						<p>主页</p>
  					</div>
  					<div class="homepage">
  						<p><s:property value="homepage"/></p>
  					</div>
  				</div>
  				
  				<div class="jobBox">
	  				<div class="jobTitle">
	  					<p>职业</p>
	  				</div>
	  				<div class="job">
	  					<p><s:property value="vocation"/></p>
	  				</div>
	  			</div>
	  			<div class="educationBox">
	  				<div class="educationTitle">
	  					<p>学历</p>
	  				</div>
	  				<div class="education">
	  					<p><s:property value="education"/></p>
	  				</div>
	  			</div>
	  			<div class="schoolBox">
	  				<div class="schoolTitle">
	  					<p>毕业院校</p>
	  				</div>
	  				<div class="school">
	  					<p><s:property value="school"/></p>
	  				</div>
	  			</div>
  				
  				<div class="languageBox">
	  				<div class="languageTitle">
	  					<p>语言</p>
	  				</div>
	  				<div class="language">
	  					<p><s:property value="language"/></p>
	  				</div>
	  			</div>
  			</div>
  			<div class="hobbyBox">
  				
  			</div>
  			</s:iterator> 
  		</div>
  	</div>
  </body>
</html>
