<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
   <%--<base href="<s:text name="basePath"/>">
    --%><title>上传头像</title>
  </head>
  
  <body>
	<form action="avatarUpload.html" method="post" enctype="multipart/form-data">
	  	选择头像：<input type="file" name="upload" /><br>
		<input value="上传" type="submit" />
	</form>
  </body>
</html>
