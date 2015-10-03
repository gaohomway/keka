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
		<div id="edui_fixedlayer" style="position: fixed; left: 0px; top: 0px; width: 0px; height: 0px; z-index: 1005;" class=" edui-default">
			<div id="edui10" class="edui-popup  edui-bubble edui-default" style="display: none;">
				<div id="edui10_body" class="edui-popup-body edui-default">
					<iframe style="position: absolute; z-index: -1; left: 0; top: 0; background-color: transparent;" frameborder="0" width="100%" height="100%" src="javascript:" class=" edui-default"></iframe>
					<div class="edui-shadow edui-default"></div>
					<div id="edui10_content" class="edui-popup-content edui-default">
					</div>
				</div>
			</div>
			<div id="edui3" class="edui-dialog edui-for-insertimage edui-default" style="left: 19px; top: 0px; z-index: 1009;">
				<div class="edui-dialog-wrap edui-default">
					<div id="edui3_body" class="edui-dialog-body edui-default"
						style="width: 640px; height: 457px;">
						<div class="edui-dialog-shadow edui-default"></div>
						<div id="edui3_titlebar" class="edui-dialog-titlebar edui-default">
							<div class="edui-dialog-draghandle edui-default" onmousedown="$EDITORUI[&quot;edui3&quot;]._onTitlebarMouseDown(event, this);">
								<span class="edui-dialog-caption edui-default">图片</span>
							</div>
							<div id="edui6" class="edui-box edui-button edui-dialog-closebutton edui-default">
								<div id="edui6_state" onmousedown="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseDown(event, this);" onmouseup="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseUp(event, this);"
									onmouseover="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseOver(event, this);" onmouseout="$EDITORUI[&quot;edui6&quot;].Stateful_onMouseOut(event, this);"
									class=" edui-default">
									<div class="edui-button-wrap edui-default">
										<div id="edui6_body" unselectable="on" title="关闭对话框"
											class="edui-button-body edui-default"
											onmousedown="return false;"
											onclick="return $EDITORUI[&quot;edui6&quot;]._onClick();">
											<div class="edui-box edui-icon edui-default"></div>
											<div class="edui-box edui-label edui-default"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="edui3_content" class="edui-dialog-content edui-default">
							<span id="edui3_contmask" class="dialogcontmask"
								style="visibility: hidden;"></span>
							<iframe id="edui3_iframe" class="%%-iframe" height="100%"
								width="100%" frameborder="0" src="/img/dialogs/image/image.jsp"></iframe>
						</div>
						<div class="edui-dialog-foot edui-default">
							<div id="edui3_buttons" class="edui-dialog-buttons edui-default">
								<div id="edui7"
									class="edui-box edui-button edui-okbutton edui-default">
									<div id="edui7_state"
										onmousedown="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseDown(event, this);"
										onmouseup="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseUp(event, this);"
										onmouseover="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseOver(event, this);"
										onmouseout="$EDITORUI[&quot;edui7&quot;].Stateful_onMouseOut(event, this);"
										class=" edui-default">
										<div class="edui-button-wrap edui-default">
											<div id="edui7_body" unselectable="on"
												class="edui-button-body edui-default"
												onmousedown="return false;"
												onclick="return $EDITORUI[&quot;edui7&quot;]._onClick();">
												<div class="edui-box edui-icon edui-default"></div>
												<div class="edui-box edui-label edui-default">
													确认
												</div>
											</div>
										</div>
									</div>
								</div>
								<div id="edui8"
									class="edui-box edui-button edui-cancelbutton edui-default">
									<div id="edui8_state"
										onmousedown="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseDown(event, this);"
										onmouseup="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseUp(event, this);"
										onmouseover="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseOver(event, this);"
										onmouseout="$EDITORUI[&quot;edui8&quot;].Stateful_onMouseOut(event, this);"
										class=" edui-default">
										<div class="edui-button-wrap edui-default">
											<div id="edui8_body" unselectable="on"
												class="edui-button-body edui-default"
												onmousedown="return false;"
												onclick="return $EDITORUI[&quot;edui8&quot;]._onClick();">
												<div class="edui-box edui-icon edui-default"></div>
												<div class="edui-box edui-label edui-default">
													取消
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="edui4" class="edui-mask  edui-dialog-modalmask edui-default"
				onmousedown="return $EDITORUI[&quot;edui4&quot;]._onMouseDown(event, this);"
				style="width: 667px; height: 649px; z-index: 1007;"></div>
			<div id="edui5" class="edui-mask  edui-dialog-dragmask edui-default"
				onmousedown="return $EDITORUI[&quot;edui5&quot;]._onMouseDown(event, this);"
				style="width: 1366px; height: 677px; display: none;"></div>
		</div>
	</body>
</html>