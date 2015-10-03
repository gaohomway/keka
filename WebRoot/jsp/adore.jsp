<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
	<head>
		<title>倾心</title>
		<base href="<s:text name="basePath"/>">
		<link href="css/adore.css" rel="stylesheet" type="text/css"/>
		<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/adore.js" type="text/javascript" charset="utf-8"></script>
		
	</head>
  
  <body>
  	<input type="hidden" value="<s:property value="#session.keeno"/>" id="keeno"/>
    <div class="adoreMainBox">
    	<div class="adorePublishBox">
    		<div class="contentBox">
	    		<textarea class="content" id="content" ></textarea>
    		</div>
    		<div class="joinElementBox">
    			<div class="insertPicture">图片</div>
    		</div>
    		<div class="publish">
    			<input type="button" value="发布" id="publish"/>
    		</div>
    		<div class="pictureDialog">
    			
    		</div>
    		<div class="AlreadyJoin">
    			
    			
    		</div>
    	</div>
    	<div class="adoreShowBox">
    		<s:iterator value="adoreList">
    			<div class="adoreBox">
    				<div class="avatar">
    					<img src="http://localhost/../kan/15253/avatar/20130418203511_100.jpg">
    				</div>
    				<div class="nickname">
    					<p>一米阳光</p>
    				</div>
	    		 	<div class="content">
	    		 		<p><s:property value="content"/></p>
	    		 	</div>
	    		 	<div class="photo">
	    		 		<s:iterator value="adorePhotoList">
							<s:if test="adoreId == ownAdoreId">
								<img src="<s:text name="kanPath"/><s:property value="#session.keeno"/>/adore_thum/<s:property value="photoName"/>" alt="" />
							</s:if>
						</s:iterator>
	    		 	</div>
	    		 	<div class="operate">
	    		 		<p>2013-04-16 09:49:10</p>
	    		 	</div>
	    		 </div>
			</s:iterator>
    	</div>
    </div>
  </body>
</html>
