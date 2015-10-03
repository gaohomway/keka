<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>完整demo</title>
		<script type="text/javascript" charset="utf-8" src="editor_config.js"></script>
		<script type="text/javascript" charset="utf-8" src="editor_all.js"></script>
		<script src="/img/lang/zh-cn/zh-cn.js" type="text/javascript" defer="defer"></script>
		<link href="/img/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
		<style type="text/css">
iframe.dealply-toast {
	right: -99999px !important;
}

iframe.dealply-toast.fastestext-revealed {
	right: 0px !important;
}
</style>
	</head>
	<body>
		<div>
			<div id="editor" class=" edui-default">
				<div id="edui1" class="edui-editor  edui-default"
					style="z-index: 999; width: 1000px;">
					<div id="edui1_toolbarbox"
						class="edui-editor-toolbarbox edui-default">
						<div id="edui1_toolbarboxouter"
							class="edui-editor-toolbarboxouter edui-default">
							<div class="edui-editor-toolbarboxinner edui-default">
								<div id="edui2" class="edui-toolbar   edui-default"
									onselectstart="return false;"
									onmousedown="return $EDITORUI[&quot;edui2&quot;]._onMouseDown(event, this);"
									style="-webkit-user-select: none;">
									<div id="edui9"
										class="edui-box edui-button edui-for-insertimage edui-default">
										<div id="edui9_state"
											onmousedown="$EDITORUI[&quot;edui9&quot;].Stateful_onMouseDown(event, this);"
											onmouseup="$EDITORUI[&quot;edui9&quot;].Stateful_onMouseUp(event, this);"
											onmouseover="$EDITORUI[&quot;edui9&quot;].Stateful_onMouseOver(event, this);"
											onmouseout="$EDITORUI[&quot;edui9&quot;].Stateful_onMouseOut(event, this);"
											class="edui-default">
											<div class="edui-button-wrap edui-default">
												<div id="edui9_body" unselectable="on" title="图片"
													class="edui-button-body edui-default"
													onmousedown="return false;"
													onclick="return $EDITORUI[&quot;edui9&quot;]._onClick();">
													<div class="edui-box edui-icon edui-default"></div>
													<div class="edui-box edui-label edui-default"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="edui1_toolbarmsg"
							class="edui-editor-toolbarmsg edui-default"
							style="display: none;">
							<div id="edui1_upload_dialog"
								class="edui-editor-toolbarmsg-upload edui-default"
								onclick="$EDITORUI[&quot;edui1&quot;].showWordImageDialog();">
								点击上传
							</div>
							<div class="edui-editor-toolbarmsg-close edui-default"
								onclick="$EDITORUI[&quot;edui1&quot;].hideToolbarMsg();">
								x
							</div>
							<div id="edui1_toolbarmsg_label"
								class="edui-editor-toolbarmsg-label edui-default"></div>
							<div style="height: 0; overflow: hidden; clear: both;"
								class=" edui-default"></div>
						</div>
					</div>
					<div id="edui1_iframeholder"
						class="edui-editor-iframeholder edui-default"
						style="height: 320px; overflow: hidden;">
						<iframe id="baidu_editor_0" width="100%" height="100%" scroll="no"
							frameborder="0"></iframe>
					</div>
					<div id="edui1_bottombar"
						class="edui-editor-bottomContainer edui-default">
						<table class=" edui-default">
							<tbody class=" edui-default">
								<tr class=" edui-default">
									<td id="edui1_elementpath"
										class="edui-editor-bottombar edui-default"
										style="display: none;"></td>
									<td id="edui1_wordcount"
										class="edui-editor-wordcount edui-default"
										style="display: none;"></td>
									<td id="edui1_scale" class="edui-editor-scale edui-default"
										style="display: none;">
										<div class="edui-editor-icon edui-default"></div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="edui1_scalelayer" class=" edui-default"></div>
				</div>
			</div>
		</div>

		<script type="text/javascript">
    	var ue = UE.getEditor('editor');
	</script>
		<div id="edui_fixedlayer" style="position: fixed; left: 0px; top: 0px; width: 0px; height: 0px;"
			class=" edui-default">
			<div id="edui10" class="edui-popup  edui-bubble edui-default" style="display: none;">
				<div id="edui10_body" class="edui-popup-body edui-default">
					<iframe style="position: absolute; z-index: -1; left: 0; top: 0; background-color: transparent;" frameborder="0" width="100%" height="100%" src="javascript:" class=" edui-default"></iframe>
					<div class="edui-shadow edui-default"></div>
					<div id="edui10_content" class="edui-popup-content edui-default">
					</div>
				</div>
			</div>
		</div>
	</body>
</html>