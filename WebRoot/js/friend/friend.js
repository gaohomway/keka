$(document).ready(function() {
	
	/**---------------------选项卡头添加样式-----------------------**/
	$(".tabMenu .friendListLi").addClass("current");

	$(".friendTabBody .chatListBox").hide();

	$(".tabMenu .friendListLi").click(function() {
		$(".friendTabBody .friendListBox").hide();
		$(".friendTabBody .chatListBox").hide();
		$(".friendTabBody .friendListBox").show();
		$(".tabMenu .friendListLi").addClass("current")
		$(".tabMenu .chatListLi").removeClass("current");
	});
	
	$(".tabMenu .chatListLi").click(function() {
		$(".friendTabBody .friendListBox").hide();
		$(".friendTabBody .chatListBox").hide();
		$(".friendTabBody .chatListBox").show();
		$(".tabMenu .chatListLi").addClass("current")
		$(".tabMenu .friendListLi").removeClass("current");
	});
	
	
	/**---------------------好友管理菜单-----------------------**/
	$(".friendMenu .friendManage").click(function() {
		var menuId = $(this).attr("id");
		
		if (menuId == "noEdit") {
			if ($(".friendMenu .friendManageBox").is(":visible")) {
				$(this).removeClass("focus");
				$(".friendMenu .friendManageBox").css("display","none");
			}else {
				$(this).addClass("focus");
				$(".friendMenu .friendManageBox").css("display","block");
			}
		}else {
			if (menuId == "addGroup") {
				$(".friendListBox .addGroup").remove();
			}else if (menuId == "deleteGroup") {
				$(".friendListBox .deleteGroupBox").remove();
			}else if (menuId == "editGroup") {
				$(".friendListBox .editGroupBox").remove();
			}
			var friendManage = $(".friendMenu .friendManage");
				friendManage.empty();
				friendManage.removeClass("finish");
				friendManage.attr("id", "noEdit");
		}
		
	});
	/**------------------------------分组管理-------------------------------**/
	//菜单分配
	$(".friendMenu .friendManageBox .menu").click(function(){
		var menuId = $(this).attr("id");
		var friendMenu = $(".friendMenu .friendManage");
		
		friendMenu.removeClass("focus");
		friendMenu.addClass("finish");
		friendMenu.append("完成");
		friendMenu.attr("id", menuId);
		$(".friendMenu .friendManageBox").css("display","none");
		
		if (menuId == "addGroup") {
			$('.friendListBox').append("<div class='addGroup' title='添加分组'>添加分组</div>");
		}else if(menuId == "deleteGroup"){
			$('.friendGroup').after("<div class='deleteGroupBox' ><div class='deleteGroup' title='删除此分类'></div></div>");
		}else if(menuId == "editGroup"){
			$('.friendGroup').after("<div class='editGroupBox' ><div class='editGroup' title='编辑此分类'></div></div>");
		}else if (menuId == "friendFind") {
			$('.friendFindBox').css('display','inline');
			$('.friendFindBox').append("<iframe id='' frameborder='0' scrolling='no' class='friendIframe' src='friendFindInit.html'></iframe>");
		}
	});
	
	//添加分组
	$(".friendListBox .addGroup").live("click",function(){
		$(this).before("<div class='friendGroup' id='groupN' onselectstart='return false'>" +
				"<div class='sign' id='OFF'></div><div class='groupName'><input type='text' name='friendGroupName' value='未命名'/></div>" +
				"</div>");
		$('input[name=friendGroupName]').focus();
		$('input[name=friendGroupName]')[0].select();
	});
	
	//添加分组-失去焦点
	$('input[name=friendGroupName]').live("blur",function(){
		var keeno = $("#keeno").val();
		var friendGroupName = $('input[name=friendGroupName]').val();
		var params = {keeno:keeno,friendGroupName:friendGroupName};
		var param = $.param(params);
		$.ajax({url: "addFriendGroup.html", success: function(data) {friendGroupShow(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
	});
	
	//添加分组-确定显示
	function friendGroupShow(data){
		$('input[name=friendGroupName]').remove();
		$('.friendListBox #groupN').attr("id","group"+data.friendGroupNumber+1);
		$(".friendListBox #group"+data.friendGroupNumber+1+" .groupName").append(data.friendGroupName);
	}
	
	//删除分组
	$(".deleteGroupBox .deleteGroup").live("click",function(){
		var groupId = $(this).parent().prev().attr("id");
		var friendGroupId = groupId.substring(5, groupId.length);
		var keeno = $("#keeno").val();
		var params = {keeno:keeno, friendGroupId:friendGroupId};
		var param = $.param(params);
		$.ajax({url: "deleteFriendGroup.html", success: function(data) {deleteFriendGroup(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
	});
	//删除分组-删除成功
	function deleteFriendGroup(data){
		$('.friendListBox #group'+data.friendGroupId).next().remove();
		$('.friendListBox #group'+data.friendGroupId).remove();
		$('.friendListBox #friendgroup'+data.friendGroupId).remove();
		
	}
	
	//编辑分组
	$(".editGroupBox .editGroup").live("click",function(){
		$(this).hide();
		var keeno = $("#keeno").val(), groupId = $(this).parent().prev().attr("id"), friendGroupId = groupId.substring(5, groupId.length);
		var friendGroupName = $(".friendListBox #"+groupId+" .groupName").text();
		$(".friendListBox #"+groupId+" .groupName").empty();
		$(".friendListBox #"+groupId+" .groupName").append("<input class='editGroup' type='text' name='friendGroupName' value='"+$.trim(friendGroupName)+"' id='"+friendGroupId+"'/>");
		$(".friendListBox #"+groupId+" .groupName :text.editGroup").focus();
		
	});
	
	$(":text.editGroup").live("blur",function(){
		var keeno = $("#keeno").val(), friendGroupName = $(":text.editGroup").val(),
			friendGroupId = $(":text.editGroup").attr("id");
		var	params = $.param({keeno:keeno, friendGroupId:friendGroupId, friendGroupName:friendGroupName}), callback = editFriendGroupShow;
		jajax('editFriendGroup.html', params, callback);
	});
	
	function editFriendGroupShow(data){
		$(":text.editGroup").remove();
		$('.friendListBox #groupN').attr("id","group"+data.friendGroupId);
		$(".friendListBox #group"+data.friendGroupId+" .groupName").append(data.friendGroupName);
		$(".editGroupBox .editGroup").show();
	}
	/**----------------------------好友列表隐藏/显示-----------------------**/
	$(".friendListBox .friendBox").hide();
	$(".friendGroup").live("click", function(){
		var groupId = $(this).attr('id');
		if ($("#friend" + groupId).is(":visible")) {
			$(this).removeClass("focus");
			
			$("#friend" + groupId).hide();
		}else {
			$(this).addClass("focus");
			
			$("#friend" + groupId).show();
		}
	});
	
	
	/**----------------------------聊天所有操作------------------------------**/
	$(".friendBox .friend").dblclick(function(){
		var friendKeeno = $(this).attr("id");
		$('.chatMainBox').css("display","inline");
		$('.chatMainBox').attr("id","yes");
		$('.chatMainBox .nickname-ul').append("<li class='nickname' id='n"+friendKeeno+"'>一米阳光</li>");
		
		$(".chatMainBox .nickname").removeClass("current");
		$(".chatMainBox #n"+friendKeeno).addClass("current");
		$(".chatMainBox .chat-box").hide();
		
		$('.chatMainBox .chat-tab').append(""+
					"<div class='chat-box' id='cn"+friendKeeno+"'>"+
						"<div class='alreadyMessage-box'>"+
							"<div class='alreadyMessage' id='am"+friendKeeno+"'>" +
								"<div class='friendInfo-box'>" +
									"<div class='avatar'>" +
										"<img src='keekan/img/avatar_50_50.jpg'></img>" +
									"</div>" +
								"</div>" +
							"</div>"+
						"</div>"+
						"<div class='sendMessage-box'>"+
							"<textarea class='sendMessage' id='sm"+friendKeeno+"' rows='' cols=''></textarea>"+
						"</div>"+
						"<div class='messageOperate-box'>"+
							"<input type='submit' class='sendChat' value='发送' id='"+friendKeeno+"'/>"+
						"</div>"+
					"</div>");
	});
	
	/**--------------------------用户选项卡切换-------------------------------**/
	//
	$(".chatMainBox .nickname-ul li").live('click', function() {
		var friendKeeno = $(this).attr("id");
		$(".chatMainBox .nickname").removeClass("current");
		$(".chatMainBox #"+friendKeeno).addClass("current");
		$(".chatMainBox .chat-tab .chat-box").hide();
		$(".chatMainBox .chat-tab #c"+friendKeeno).show();
	});
	
	/**------------------------------发送聊天信息-------------------------------**/
	$(".chatMainBox .sendChat").live('click', function() {
		var friendKeeno = $(this).attr("id");
		var sendMessage = $(".chatMainBox #sm"+friendKeeno).val();
		var keeno = $("#keeno").val();
		$(".chatMainBox #am"+friendKeeno).append(
				"<div class='fIssuedBox'>" +
					"<div class='avatar'>" +
						"<img src='keekan/img/avatar_50_50.jpg'></img>" +
					"</div>" +
					"<div class='issuedMessage' id='issuedMessage'>" +
						"<pre>"+sendMessage+"</pre>" +
					"</div>" +
					"<div style='clear:both;'></div>" +
				"</div>");
		$(".chatMainBox #sm"+friendKeeno).val("");
		sendChat(keeno, friendKeeno, sendMessage);
	});
	
	function sendChat(keeno, friendKeeno, sendMessage){
		var params = {keeno:keeno, friendKeeno:friendKeeno, sendMessage:sendMessage};
		var jsonDate = $.param(params);
		$.ajax({url: "sendChat.html", success: function(data) {receiveReply(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
	}
	function receiveReply(data){
		//alert(data);
	}
	/**------------------------------添加好友-------------------------------**/
	$('#searchFriend').click(function(){
		var keeno = $("#keeno").val();
		var params = {keeno:keeno};
		var param = $.param(params);
		$.ajax({url: "searchFriend.html", success: function(data) {searchResult(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
	});
	//搜索结果显示
	function searchResult(data){
		var user = data.userList;
		if(user != null){
			for ( var i = 0; i < data.userList.length; i++) {
				var user = data.userList[i];
				var keeno = user.keeno;
				var nickname = user.nickname;
				var sex = user.sex;
				var birthday = user.birthday;
				$('.searchResult').append("<div class='friend'>" +
						"<p>"+ keeno +"</p>" +
						"<p>"+ nickname +"</p>" +
						"<p>"+ sex +"</p>" +
						"<p>"+ birthday +"</p>" +
						"</div>");
			}
		}
	}
	
	//jquery ajax 
	function jajax(action, params, callback){
		$.ajax({url: action, type: "post", dataType: "json", data: params, success: callback, error: function(XMLHttpRequest, textStatus, errorThrown){alert(XMLHttpRequest);alert(textStatus);alert(errorThown);}});
	}
});
