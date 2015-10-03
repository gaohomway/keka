$(document).ready(function() {
	
	/**---------------------选项卡头添加样式-----------------------**/
	$(".tabMenu .accurateFindLi").addClass("current");
	$(".findTabBody .termFind").hide();

	$(".tabMenu .accurateFindLi").click(function() {
		$(".findTabBody .accurateFind, .findTabBody .termFind").hide();
		$(".findTabBody .accurateFind").show();
		$(".tabMenu .accurateFindLi").addClass("current")
		$(".tabMenu .termFindLi").removeClass("current");
	});
	
	$(".tabMenu .termFindLi").click(function() {
		$(".findTabBody .accurateFind, .findTabBody .termFind").hide();
		$(".findTabBody .termFind").show();
		$(".tabMenu .termFindLi").addClass("current")
		$(".tabMenu .accurateFindLi").removeClass("current");
	});
	
	/**---------------------搜索好友-----------------------**/
	$(".accurateFind #findFriend").live('click', function() {
		var keeno = $(".accurateFind #keeno").val();
		var params = $.param({keeno:keeno}), callback = friendResult;
		jajax('friendFind.html', params, callback);
	});
	
	$(".accurateFind #keeno").keyup(function(){
        if(event.keyCode == 13){
        	
        }
    });
	
	//好友查找结果
	function friendResult(data){
		var user = data.userList;
		if(user != null){
			for ( var i = 0; i < data.userList.length; i++) {
				var u = data.userList[i], a = data.avatarList[i];
				var keeno = u.keeno, nickname = u.nickname, sex = u.sex, birthday = u.birthday;
				var avatar = a.midAvatar;
				$('.accurateFind .friendList').empty().append("<div class='friendBox'>" +
						"<div class='avatar'>" +
						"<img class='avatar' src='http://localhost/kan/"+keeno+"/avatar/"+avatar+"' id='avatar'/>" +
						"</div>" +
						"<div class='nickname' id='"+keeno+"'><a>"+nickname+"("+keeno+")</a></div>" +
						"<div class='sex'>"+sex+"</div>" +
						"<div class='operate'><a>加为好友</a></div>" +
						"</div>");
			}
		}
	}
	
	//查看资料卡[点击昵称]
	$(".accurateFind .nickname").live('click', function() {
		$(".friendFindCard").animate({left:"-400px"}, 500);
		$(".friendAddCard").animate({left:"0px"}, 500);
		var keeno = $(this).attr("id");
		var params = $.param({keeno:keeno}), callback = friendInfoCard;
		jajax('friendInfoCard.html', params, callback);
	});
	
	//添加好友[点击添加]
	$('.accurateFind .operate a').live('click', function() {
		$(".friendFindCard").animate({left:"-400px"}, 500);
		$(".friendAddCard").animate({left:"0px"}, 500);
		var keeno = $(".accurateFind .nickname").attr("id");
		var params = $.param({keeno:keeno}), callback = addAttestInfoInit;
		jajax('addAttestInfoInit.html', params, callback);
	});
	
	//显示好友信息卡
	function friendInfoCard(data){
		var user = data.userList;
		if(user != null){
			var u = data.userList[0], a = data.avatarList[0];
			var keeno = u.keeno, nickname = u.nickname, sex = u.sex, birthday = u.birthday;
			var avatar = a.bigAvatar;
			$('.friendAddCard').empty().append("<div class='userInfoCard'>" +
				"<div class='infoHead'>" +
					"<div class='avatarBox'>" +
						"<img class='avatar' src='http://localhost/../kan/"+keeno+"/avatar/"+avatar+"' id='avatar'>" +
					"</div>" +
				"</div>" +
				"<div class='infoBody'>" +
					"<div class='keeno'><p>账号："+keeno+"</p></div>" +
					"<div class='addFriend'><a>添加好友</a></div>" +
				"</div>" +
				"<div class='addFriendBox'></div>" +
			"</div>");
		}
	}
	
	//添加验证信息初始化
	function addAttestInfoInit(data){
		friendInfoCard(data);
		var str = "";
		for ( var i = 0; i < data.friendGroupList.length; i++) {
			var fg = data.friendGroupList[i];
			str += "<option value ='"+fg.friendGroupId+"'>"+fg.friendGroupName+"</option>";
		}
		$('.friendAddCard .addFriendBox').append("<div class='remark'>备注姓名：<input type='text' name='remark' /></div>" +
								"<div class='group'>分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;组：<select id='groupId'>"+str+"</select></div>" +
								"<div class='attestInfoBox'>验证信息：<div class='textPos'><textarea class='attestInfo' id='attestInfo' name='attestInfo'></textarea></div></div>" +
								"<div class='operate'><input type='button' value='添加' id='addAttestInfo'><input type='button' value='取消' id=''><input type='button' value='查看资料' id=''></div>");
		$(".friendAddCard .addFriendBox").animate({left:"0px"}, 500);
	}
	
	//添加好友操作
	$(".friendAddCard .addFriend a").live('click', function() {
		var keeno = $(".accurateFind .nickname").attr("id");
		var params = $.param({keeno:keeno}), callback = addAttestInfoInit;
		jajax('addAttestInfoInit.html', params, callback);
	});
	
	//查看资料[按钮]
	
	
	
	//添加验证信息
	$(".friendAddCard #addAttestInfo").live('click', function() {
		$(".friendAddCard input[name='remark']").attr({"disabled":"disabled"});
		$(".friendAddCard #groupId").attr({"disabled":"disabled"});
		$(".friendAddCard #attestInfo").attr({"disabled":"disabled"});
		var friendKeeno = $(".accurateFind .nickname").attr("id"),
			remarkInfo = $(".friendAddCard input[name='remark']").val(),
			groupId = $(".friendAddCard #groupId").val(),
			attestInfo = $(".friendAddCard #attestInfo").val();
		
		var params = $.param({friendKeeno:friendKeeno, remarkInfo:remarkInfo, groupId:groupId, attestInfo:attestInfo}), 
			callback = addAttestInfoFinish;
		jajax('addAttestInfo.html', params, callback);
	});
	
	function addAttestInfoFinish(){
		$('.friendAddCard .addFriendBox').empty().append("<div class='addFinish'>" +
					"<div class='correctSign'><img src='img/correct.png'/></div>" +
					"<div class='pointInfo'>您已成功发送好友添加信息，正等待好友确认。</div>" +
					"<div class='operate'><input type='button' value='查看资料' id=''><input type='button' value='关闭' id=''></div>" +
				"</div>");
	}
	/**---------------------jquery ajax -----------------------**/
	function jajax(action, params, callback){
		$.ajax({url: action, type: "post", dataType: "json", data: params, success: callback, error: function(XMLHttpRequest, textStatus, errorThrown){alert(XMLHttpRequest);alert(textStatus);alert(errorThown);}});
	}
});