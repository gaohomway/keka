<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="keekan/test/jquery-1.7.2.min.js"></script>
		<style type="text/css">
			.img {
				width: 136px;
				height: 102px;
			}
			.imgError {
				border: 3px solid red;
			}
		</style>
		<script type="text/javascript">
			var MAXSIZE = 100 * 1024; 						//限制上传图片大小100K 
			var ERROR_IMGSIZE = "图片大小不能超过100K"; 		//图片大小限制信息 
			var NOPHOTO = "keekan/test/30.jpg"; 				//默认图片 
			var isImg = true; 								//图片是否合格 
			/** 
			 * Input file onchange事件 
			 * @params obj file对象 
			 * @return void 
			 **/
			function checkFileChange(obj) {
				$(".imgTable").removeClass("imgError");	//初始化设置 
				updateTips("");
				var img = $(".img").get(0);
				var file = obj.value;
				var exp = /.\.jpg|.\.gif|.\.png|.\.bmp/i;
				if (exp.test(file)) { //验证格式 
					if ($.browser.msie) { //判断是否是IE 
						img.src = file;
					} else {
						img.src = obj.files[0].getAsDataURL();
						sizeCheck(img);
					}
				} else {
					img.src = NOPHOTO;
					$(".imgTable").addClass("imgError");
					updateTips("图片格式不正确");
					isImg = false;
				}
			}
			/** 
			 * sizeCheck 检查图片大小 
			 * @params img 图片对象 
			 * @return void 
			 **/
			function sizeCheck(img) {
				//初始化设置 
				$(".imgTable").removeClass("imgError");
				updateTips("");
				if ($.browser.msie) {//查看是否是IE 
					if (img.readyState == "complete") {
						if (img.fileSize > MAXSIZE) {
							$(".imgTable").addClass("imgError");
							updateTips(ERROR_IMGSIZE);
							isImg = false;
						} else {
							isImg = true;
						}
		
					} else {
						$(".imgTable").addClass("imgError");
						updateTips(ERROR_IMGSIZE);
						isImg = false;
					}
		
				} else {
					var file = $("input:file[name='uploadImg']")[0];
		
					if (file.files[0].fileSize > MAXSIZE) {
						$(".imgTable").addClass("imgError");
						updateTips(ERROR_IMGSIZE);
						isImg = false;
					} else {
						isImg = true;
					}
		
				}
			}

			/** 
			 * updateTips 注册错误信息显示 
			 * @params str 显示内容 
			 * @return void 
			 **/
			function updateTips(str) {
				$("p#errorTips").text(str);
			}
			/** 
			 * commit 注册提交 
			 * @return void 
			 **/
			function commit() {
				var isCommit = true;
				var usrname = $("input:text[name='usrname']"), email = $("input:text[name='email']"), img = $(".img"), file = $("input:file[name='uploadImg']"), frm = document.frm;
		
				isCommit = isCommit && isImg;
		
				if (isCommit) {
					frm.action = "about:blank";
					frm.submit();
				}
			}
			/** 
			 * errorImg 图片错误显示 
			 * @params img 图片对象 
			 * @return void 
			 **/
			function errorImg(img) {
				img.src = NOPHOTO;
			}
		</script>
		</head>
			<body>
				<form name="frm" method="post">
					<p id="errorTips"> </p>
					<table cellpadding="1" cellspacing="0" width="350px" border="1">
						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" class="imgTable">
									<tr>
										<td>
											<img src="imgs/nophoto.gif" class="img" alt="头像" onerror="Javascript:errorImg(this);" onreadystatechange="Javascript:sizeCheck(this);" />
										</td>
									</tr>
									<tr>
										<td>
											<input type="file" name="uploadImg" onchange="Javascript:checkFileChange(this);" size="12" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="Javascript:commit();" href="Javascript:commit();">注册</a>
							</td>
						</tr>
					</table>
				</form>
			</body>
		</html>