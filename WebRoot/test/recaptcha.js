$(document).ready(function() {
	$("#mysubmit").click(function() {
		var params = $('#myForm').serialize();// 序列化表单的值
		alert(params);
			$.ajax( {
				url : "loginJquery.html", 	// 请求的url
				type : "post", 				// 发送方式
				dataType : "json", 			// 接受数据格式
				data : params, 				// 要传递的数据
				//contentType : "application/json;charset=utf-8",
				success : function(data) {
					if(data != ""){
						for(var i = 0, l = data.albumGroupList.length; i < l; i++){
							var album = data.albumGroupList[i];
							var str = album.albumGroupId + album.albumGroupName + album.keeNumber;
							alert(str);
						}
					}
            	},   						// 回传函数
            	error: function(XMLHttpRequest, textStatus, errorThrown){
            		alert(errorThown);
            	}
			});
	});
	
	function querydata(data) {
		var json = eval("(" + data + ")");
		var str = "姓名:" + json.name + "<br />";
		str += "年龄:" + json.age + "<br />";
		alert(str);
		$("#result").html(str);
	}

	
	
	
});
function processResponse(request) {
	$("show").innerHTML = request.responseText;
}

