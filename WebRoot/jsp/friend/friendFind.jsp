<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>查找好友</title>
		<base href="<s:text name="basePath"/>">
		<link type="text/css" href="css/friend/friendFind.css" rel="stylesheet">
		<script src="js/jquery/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/friend/friendFind.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="friendFindCard">
			<div class="findTabHead">
				<ul class="tabMenu">
					<li class="accurateFindLi">
						精准查找
					</li>
					<li class="termFindLi">
						条件查找
					</li>
				</ul>
			</div>
			<div class="findTabBody">
				<div class="accurateFind">
					<div class="searchBox">
						<input type="text" name="keeno" id="keeno"/>&nbsp;<input type="button" value="查找" id="findFriend"/>
					</div>
					<div class="friendList">
						<div class="friendBox">
							<div class="avatar">
								<img src="http://localhost/kan/15253/avatar/20130418203511_50.jpg" >
							</div>
							<div class="baseInof">
								<div class="nickname" >
									<p>一米阳光(14638)</p>
								</div>
								<div class="sex">
									<p>男</p>
								</div>
								<div class="operate">
									<p>加为好友</p>
								</div>
							</div>
							<div class="firstImpression">
							
							</div>
						</div>
						<div class="friendBox">
							<div class="avatar">
								<img src="http://localhost/kan/15253/avatar/20130418203511_50.jpg" >
							</div>
							<div class="baseInof">
								<div class="nickname" >
									<p>一米阳光(14638)</p>
								</div>
								<div class="sex">
									<p>男</p>
								</div>
								<div class="operate">
									<p>加为好友</p>
								</div>
							</div>
							<div class="firstImpression">
							
							</div>
						</div>
						<div class="friendBox">
							<div class="avatar">
								<img src="http://localhost/kan/15253/avatar/20130418203511_50.jpg" >
							</div>
							<div class="baseInof">
								<div class="nickname" >
									<p>一米阳光(14638)</p>
								</div>
								<div class="sex">
									<p>男</p>
								</div>
								<div class="operate">
									<p>加为好友</p>
								</div>
							</div>
							<div class="firstImpression">
							
							</div>
						</div>
						<div class="friendBox">
							<div class="avatar">
								<img src="http://localhost/kan/15253/avatar/20130418203511_50.jpg" >
							</div>
							<div class="baseInof">
								<div class="nickname" >
									<p>一米阳光(14638)</p>
								</div>
								<div class="sex">
									<p>男</p>
								</div>
								<div class="operate">
									<p>加为好友</p>
								</div>
							</div>
							<div class="firstImpression">
							
							</div>
						</div>
					</div>
				</div>
				<div class="termFind">
					条件查找
				</div>
			</div>
		</div>
		<div class="friendAddCard">
			
		</div>
	</body>
</html>
