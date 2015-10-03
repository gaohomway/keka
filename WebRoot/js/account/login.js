
function check(form) {
	var k = $("input[name=keeno]").val(),
		p = $("input[name=password]").val();
	if (k == "" || k == null) {
		$("input[name=keeno]").focus();
		return false;
	}else if (p == "" || p == null) {
		$("input[name=password]").focus();
		return false;
	}else {
		return true;
	}
}
