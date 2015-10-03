<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<link href="css/album/album.css" rel="stylesheet" type="text/css" />
		<link href="css/jquery.scroll.css" rel="stylesheet" type="text/css" />
		
		<script src="js/jquery/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery.scroll.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/album/album.js" type="text/javascript" charset="utf-8"></script>
		
	</head>

<body>
	<input type="hidden" value="<s:property value="#session.keeno"/>" id="keeno"/>
	<input type="hidden" value="<s:property value="#session.keeno"/>" id="avatar"/>
	<div class="albumCard">
		<!-- Album group box. -->
		<div class="albumGroupBox">
			<s:iterator value="albumGroupList">
			<div class="albumGroup" id="group<s:property value="albumGroupId"/>">
				<div class="groupName">
					<s:property value="albumGroupName"/> [ <s:property value="albumNumber"/> ]
				</div>
			</div>
			</s:iterator>
			<ul class="albumMenuBox">
				<li class="albumMenu">
					<ul>
						<li id="uploadPhoto"><a>上传照片</a></li>
							
						<li id="addAlbumGroup"><a>创建分类</a></li>
						<li id="deleteAlbumGroup"><a>删除分类</a></li>
						<li id="editAlbumGroup"><a>编辑分类</a></li>
						<li id="groupEdit"><a>排序分类</a></li>
						
						<li id="addAlbum"><a>创建相册</a></li>
						<li id="deleteAlbum"><a>删除相册</a></li>
						<li id="editAlbum"><a>编辑相册</a></li>
					</ul>
				</li>
			</ul>
		</div>
		
		<!-- Album box. -->
		<div class="albumMainBox">
			<s:iterator value="albumGroupList">
			<div class="albumBox" id="albumgroup<s:property value="albumGroupId"/>">
				<s:iterator value="albumList">
				<s:if test="ownAlbumGroupId == albumGroupId">
					<div class="album" id="<s:property value="albumId"/>">
						<div class="albumCover">
							<s:iterator value="albumCoverList">
							<s:if test="albumId == ownAlbumId">
								<img src="<s:text name="kanPath"/><s:property value="#session.keeno"/>/photo_thum/<s:property value="photoName"/>" alt="无法显示时的替代文字" />		
							</s:if>
							</s:iterator>
						</div>
						<div class="albumName">
							<s:property value="albumName"/> [ <s:property value="photoNumber"/> ]
						</div>
					</div>
				</s:if>
				</s:iterator>
			</div>
			</s:iterator>
		</div>
		
		<!-- Photo main box.-->
		<div class="photoMainBox">
			<div class="photoThumMainBox">
				
			</div>
			<div class="photoReviewMainBox">
				
			</div>
		</div>
	</div>
</body>
</html>
