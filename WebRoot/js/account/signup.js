$(document).ready(function() {
	
	$(".refresh img").click(function() {
		$("#authImg").attr("src", 'authImg?now' + new Date());
		$(".recaptchaBox #vercode").focus();
	});
	
	//密码强度
	$(".password_adv").passStrength({ 
		shortPass: "top_shortPass", 
		badPass: "top_badPass", 
		goodPass: "top_goodPass", 
		strongPass: "top_strongPass", 
		baseStyle: "top_testresult", 
		userid: "#user_id_adv", 
		messageloc: 0 
	});
	
	//注册提交
	$("input[name=nickname]").focus(function(){
		$("input[name=nickname]").removeClass("error");
	});
	$("#yearid").focus(function(){
		$("#yearid").removeClass("error");
	});
	$("#countryId").focus(function(){
		$("#countryId").removeClass("error");
	});
	$("input[name=password]").focus(function(){
		$("input[name=password]").removeClass("error");
	});
	$("input[name=confirmPassword]").focus(function(){
		$("input[name=confirmPassword]").removeClass("error");
	});
	$("input[name=email]").focus(function(){
		$("input[name=email]").removeClass("error");
	});
	$("input[name=vercode]").focus(function(){
		$("input[name=vercode]").removeClass("error");
	});
	$("#agreement").click(function(){
		$(".agreementBox").css("color","#333");
	});
	
	//确认密码失去焦点删除密码强度
	$("input[name=password]").blur(function(){
		$(".top_testresult").remove();
	});
	
	//确认密码失去焦点检测密码
	$("input[name=confirmPassword]").blur(function(){
		var password = $("input[name=password]").val(), confirmPassword = $("input[name=confirmPassword]").val();
		$(".passwordError").remove();
		if (password != confirmPassword) {
			$(".confirmPasswordBox").after("<div class='passwordError'>密码与确认密码不一致，请重新输入。</div>");
		}
	});
	
	$("input[name=email]").blur(function(){
		var email = $.trim($("input[name=email]").val());
		if (email.length != 0) {
			$(".emailError").remove();
			var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if (!filter.test(email)){
				$(".emailBox").after("<div class='emailError'>电子邮件地址格式不正确。</div>");
			}
		}
	});
	$("#joinId").click(function(){
		var via = true;
		var nickname = $("input[name=nickname]").val(), year = $("#yearid").val(), country = $("#countryId").val(),
			password = $("input[name=password]").val(), confirmPassword = $("input[name=confirmPassword]").val(),
			email = $("input[name=email]").val(), vercode = $("input[name=vercode]").val(),
			agreement = $("#agreement").is(":checked");
		
		if (nickname == null || nickname == ""){
			$("input[name=nickname]").addClass("error");
			via = false;
		}
		if (year == 0){
			$("#yearid").addClass("error");
			via = false;
		}
		if (country == 0){
			$("#countryId").addClass("error");
			via = false;
		}
		if (password == null || password == ""){
			$("input[name=password]").addClass("error");
			via = false;
		}
		if (confirmPassword == null || confirmPassword == ""){
			$("input[name=confirmPassword]").addClass("error");
			via = false;
		}
		if (password != confirmPassword) {
			via = false;
		}
		if (email == null || email == ""){
			$("input[name=email]").addClass("error");
			via = false;
		}
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email)){
			via = false;
		}
		if (vercode == null || vercode == ""){
			$("input[name=vercode]").addClass("error");
			via = false;
		}
		if (!agreement) {
			$(".agreementBox").css("color","red");
			via = false;
		}
		
		if (via == true) {
			var params = $.param({vercode:vercode}), callback = signup;
			jajax('vercode.html', params, callback);
		}
	});
	function signup(data){
		if (data.vercodeyn == "yes"){
			var nickname = $("input[name=nickname]").val(), 
				sex = $("#sex").val(),
				year = $("#yearid").val(), 
				month = $("#monthId").val(), 
				day = $("#dayId").val(), 
				country = $("#countryId").val(),
				town = $("#townId").val(),
				district = $("#districtId").val(),
				password = $("input[name=password]").val(), 
				confirmPassword = $("input[name=confirmPassword]").val(),
				email = $("input[name=email]").val();
				var params = $.param({nickname:nickname, sex:sex, year:year, month:month, day:day, country:country, town:town,  district:district, password:password, confirmPassword:confirmPassword, email:email}), callback = signupSuccess;
				jajax('signups.html', params, callback);
		}else if (data.vercodeyn == "no"){
			$("#authImg").attr("src", 'authImg?now' + new Date());
			$(".recaptchaBox #vercode").focus();
		}
	}
	function signupSuccess(data){
		location.href = "accountsInit.html";
	}
	//jquery ajax 
	function jajax(action, params, callback){
		$.ajax({url: action, type: "post", dataType: "json", data: params, success: callback, error: function(XMLHttpRequest, textStatus, errorThrown){alert(XMLHttpRequest);alert(textStatus);alert(errorThown);}});
	}
});
