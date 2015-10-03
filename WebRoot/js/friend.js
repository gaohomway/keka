$(document).ready(function() {
	PL.keeNumber = $("#keeno").val();
	PL._init();
	PL.joinListen('loginTopics'); 
	PL.setDebug(false);
});

function onData(event) {
    var keeno = event.get("keeno");
    var replyMessage = event.get("sendMessage");
    receivesReply(keeno, replyMessage);
}
//接收回复
function receivesReply(keeno, replyMessage){
	$(".chatMainBox #am"+keeno).append(
			"<div class='fReplyBox'>" +
				"<div class='avatar'>" +
					"<img src='keekan/img/avatar_50_50.jpg'></img>" +
				"</div>" +
				"<div class='replyMessage'>" +
					"<pre>"+replyMessage+"</pre>" +
				"</div>" +
				"<div style='clear:both;'></div>" +
			"</div>");
}














/*
joinListen();			//开始与服务器通信
PL.setDebug(false);		//取消debug模式
var onlines = new Array();//封装所以在线用户在数组中


//与服务器建立连接 建立session  并监听事件
//   /pushlet/ping  是为了与服务器保持心跳  知道服务器没死
//   /user/login  登陆信息  /user/login  聊天信息
function joinListen() {												//登录完 第一个执行的
	
	PL.joinListen("/pushlet/ping,/user/login,/user/chat");
}


function onJoinListenAck(event) {	//上线后马上发布我的上线信息 		//登录完 第二个执行的
	
	publish();
}



function publish() {				//发布上线信息					//登录完 第三个执行的
	
	var name = $("#name").val() ;
	PL.publish("/user/login", "name=" + name);
}



//借助一定周期的RefreshAck事件  发送我的在线信息
//是为了提供给刚上线的user 并监控在线用户的时间戳是否较新  否则判断为掉线 踢掉
//Refresh是为了让服务器知道client没死
function onRefreshAck(event) {											//登录完 第四个执行的
	
	$("#cw").html("");
	for (var i = 0, online; online = onlines[i]; i++) {
		//当前时间戳-上次更新的时间戳 如果间隔较大 说明没更新  掉了
		if ((event.get("p_time") - online.aliveTS) > 30 ) {
			alert(online.text + "\u79bb\u5f00\u4e86");
			del(i + 1, onlines);  //从数组中删除
		} else {
			var div = $("#cw");
			div.html(online.html);
		}
	}
	publish();
}




function onEvent(event) {// 服务器回调事件 登录之后回调 				//登录完 第五个执行的
	
	
	//取得这个人是否加入到页面中代码
	var divId = $("#cw" + event.get("p_from")).html();
	var div = $("#cw");
	var divInfo = div.html();
	
    //如果是登陆的消息 并且不是自己发出的 页面中没有这个人显示
	if (event.getSubject() == "/user/login" && PL.sessionId != event.get("p_from") && divId == null) {
		alert(PL.sessionId);alert(event.get("p_from"));
		//写html代码， 进行用户的添加
		var htmlInfo = "<DIV id=cw" + event.get("p_from") + " onclick=\"showChat('" + event.get("p_from") + "','" + event.get("name") + "')\">" + event.get("name") + " </DIV>" + divInfo;
		
     	//封装数据
		var json = {id:event.get("p_from"), text:event.get("name"), aliveTS:event.get("p_time"), html:htmlInfo};
		
		//将封装好的json数据添加到页面 用于显示
		div.html(json.html);
		
		//将json加入到数组中 用于循环
		onlines.push(json);
	} else {
		
		//这里判断是否为更新时间戳的请求
		if (event.getSubject() == "/user/login" && PL.sessionId != event.get("p_from") && divId != null) {
			//进行循环 得到当前用户 并更新本次的时间戳
			for (var i = 0, online; online = onlines[i]; i++) {
		        //更新当前的时间戳
				if (online.id == event.get("p_from")) {
					//将json数据进行更新
					online.aliveTS = event.get("p_time");
				}
			}
		}
	}
	//这里拦截的是是聊天的信息   
	if (event.getSubject() == "/user/chat") {
		
		var now = new Date();									//得到当前时间
		var time = " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds() + "";
        
		var smessage = event.get("message");					//解码回车符  消息在发送的时候对回车符进行了替换 现在替换回来 否则在经过服务器的时候回车符会丢失
		
		var reg = new RegExp(PL.sessionId, "g"); 				// 创建正则RegExp对象
		
		smessage = smessage.replace(reg, "\n");					//解码回车
		
		for (var i = 0, online; online = onlines[i]; i++) {		//进行循环 判断发送给谁
		    //取得ID 发送信息
			alert(online.id);alert(event.get("p_from"));
			if (online.id == event.get("p_from")) {
				showChat(online.id, online.text);
				var printInfo = document.getElementById("info" + online.id);
				//将信息全部加入到对应的消息框
				printInfo.value = printInfo.value + online.text + "  " + time + "  \n" + smessage + "\n\n";
				printInfo.scrollTop = printInfo.scrollHeight;
				//一切搞定 跳出循环
				break ;
			}
		}
	}
}








//根据索引值删除数组中指定的数据
function del(index, dataArray) {
	alert(del);
	var len = dataArray.length;
	for (var i = 0; i < len; i = i + 1) {
		if (i == (index - 1)) {
			for (var j = i + 1; j < len; j = j + 1) {

                //当前索引值后的数据都向前移
				dataArray[j - 1] = dataArray[j];
			}

            //移完之后,自身长度减1
			dataArray.length--;
		}
	}
}






function showChat(from, name) {	//打开聊天窗口
	var idName = "chat" + from;
	var chatDiv = $("#" + idName);
	var chats = $("#chat").html();
	//动态div的添加
	if (null == chatDiv.html()) {
		var idInfo = "info" + from;
		var idPrint = "print" + from;
		$("#infoDiv").html("<textarea rows=\"20\" cols=\"60\" id=\"" + idInfo + "\" style=\"color: blue; font-weight: bold; font-size: 15\" readonly=\"true\"></textarea>");
		$("#printDiv").html("<textarea rows=\"5\" cols=\"60\" id=\"" + idPrint + "\" style=\"color: blue; font-weight: bold; font-size: 15\"></textarea>");
		$("#closeDIV").html("<a href=\"javascript:closeChat('" + idName + "')\" style=\"cursor: pointer\">\u5173\u95ed</a>");
		$("#infoName").html("\u4e0e" + name + "\u804a\u5929\u4e2d");
		$("#sendDiv").html("<button onclick=\"send('" + from + "','" + name + "')\">\u53d1\u9001</button>");
		var chat = $("#chat").html();
		var objdiv = document.createElement("DIV");
		var objname = idName;
		objdiv.id = objname;
		objdiv.style.display = "none";
		objdiv.innerHTML = chat;
		document.body.appendChild(objdiv);
		//这句表示把模版html代码给封装成原样  第一：方便下次好取 第二：防止一个页面中有重复ID 这个错误改了我一天
		$("#chat").html(chats);
	}
	chatDiv = $("#" + idName);
	chatDiv.show();
}

function closeChat(idName) {	//关闭聊天窗口
	var chatDiv = $("#" + idName);
	chatDiv.hide();
}

function send(fromId, uName) {	//发送信息
	
	var smessage = document.getElementById("print" + fromId).value;		//得到要发送信息的内容
	
	var print = document.getElementById("print" + fromId);				//输入框
	var printInfo = document.getElementById("info" + fromId);
	
	smessage = smessage.replace(/\r\n/ig, fromId);						//替换回车符
	PL.publish("/user/chat", "p_to=" + fromId + "&message=" + smessage);
	
	var now = new Date();												 //得到当前时间
	var time = " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds() + "";
	var name = $("#name").val() ;
	printInfo.value += name + "  " + time + "  \n" + print.value + "\n\n";
	print.value = "";
	printInfo.scrollTop = printInfo.scrollHeight;
}

*/