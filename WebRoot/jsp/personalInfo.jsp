<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <link rel="stylesheet" href="../css/personalInfo.css" />
    <script src="../js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/personalInfo.js" type="text/javascript" charset="utf-8"></script>
  </head>
  
  <body>
	<div class="personal-info-title-box">
		<h6>个人资料</h6>
	</div>
	<div class="personal-info-main-box">
		<div class="personal-info-left-navig-box">
			<div class="avatar-box">
				<a href="keekan/jsp/avatarUpload.jsp" id="avatar-editor-pop" title="修改头像">
					<img src="../img/640.jpg" title="修改头像"/>
				</a>
			</div>
			<div class="navig-options-box">
				<a href="">个人资料</a>
			</div>
		</div>
		<div class="personal-info-left-navig-box">
			<a href="#" id="dialog_link" >
			弹出
		</a>
		<div id="dialog" title="Dialog Title">
			<p>
				Lorem ipsum dolor sit amet,
			</p>
		</div>
		</div>
	</div>
  </body>
</html>
