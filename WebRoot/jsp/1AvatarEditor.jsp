<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>头像切割</title>
		<script src="keekan/js/avatar/jquery.min.js"></script>
		<script src="keekan/js/avatar/jquery.Jcrop.js"></script>
 		<link rel="stylesheet" href="keekan/css/avatar/jquery.Jcrop.css" type="text/css" />
		<script type="text/javascript">
			jQuery(function($) {
				var jcrop_api, boundx, boundy;
				initJcrop();
				function initJcrop() {
					$('#imgCrop').Jcrop({
						bgOpacity: 0.7, 
						bgColor: 'white',
				        addClass: 'jcrop-light',
				        onChange : updatePreview}, 
							function() {
								var bounds = this.getBounds();
								boundx = bounds[0];
								boundy = bounds[1];
								jcrop_api = this;
								jcrop_api.animateTo( [0, 0, 100, 100 ]);
							});
				};
				function updatePreview(c) {
					$('#x1').val(c.x);
					$('#y1').val(c.y);
					$('#x2').val(c.x2);
					$('#y2').val(c.y2);
					$('#w').val(c.w);
					$('#h').val(c.h);
					if (parseInt(c.w) > 0) {
						var rx = 100 / c.w;
						var ry = 100 / c.h;
						$('#preview').css( {
							width : Math.round(rx * boundx) + 'px',
							height : Math.round(ry * boundy) + 'px',
							marginLeft : '-' + Math.round(rx * c.x) + 'px',
							marginTop : '-' + Math.round(ry * c.y) + 'px'
						});
					}
				};
			});
		</script>
</head>
<body>
	 <form name=form1 method=post action="AvatarEditorAction.html">
		<img src="upload/<s:property value="uploadFileName"/>" id="imgCrop" name="imgCrop" />
		<div class="" style="width: 100px; height: 100px; overflow: hidden;">
			<img src="upload/<s:property value="uploadFileName"/>" id="preview" />
		</div>
    	<div>
    		<input type="hidden" id="x1" name="x" />
			<input type="hidden" id="y1" name="y" />
			<input type="hidden" id="x2" name="x2" />
			<input type="hidden" id="y2" name="y2" />
			<input type="hidden" id="w" name="w" />
			<input type="hidden" id="h" name="h" />
			<input type="hidden" id="width" name="width" value="<s:property value="imgWidth"/>"/>  
			<input type="hidden" id="height" name="height" value="<s:property value="imgHeight"/>"/>
			<input type="hidden" id="oldImgPath" name="oldImgPath" value="upload/<s:property value="uploadFileName"/>"/>  
			<input type="hidden" id="imgRoot" name="imgRoot" value="upload/"/>	
			<input type="hidden" id="imgFileExt" name="imgFileExt" value="jpg"/>	
			<input type="submit" value="保存">
    	</div>
	</form>
	</body>
</html>
