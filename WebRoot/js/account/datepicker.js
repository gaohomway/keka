/*!
 * KEEKAN Date picker plug v1.0.0
 * http://keekan.com
 * 
 * Copyright 2012 jQuery Foundation and other contributors
 * keekan@keekan.com
 * 
 * Date: Thu Aug 09 2012 16:24:48 GMT-0400 (Eastern Daylight Time)
 */
$(function() {
	var yearId = $('#yearid');
	var monthId = $('#monthId');
	var dayId = $('#dayId');
	var myDate = new Date();
	var year = myDate.getFullYear();

	for ( var i = year; i >= 1980; i--) {
		yearId.append('<option value="' + i + '">' + i + '年</option>')
	}

	yearId.change(function() {
		monthId.html('')
		for ( var i = 1; i <= 12; i++) {
			monthId.append('<option value="' + i + '">' + i + '月</option>')
		}
		monthId.change()
	})

	monthId.change(function() {
		var yearValue = yearId.val()
		var monthValue = parseInt(monthId.val())
		var dayvalue;
		dayId.html('')

		if (monthValue == 1 || monthValue == 3 || monthValue == 5 || monthValue == 7 || monthValue == 8 || monthValue == 10 || monthValue == 12) {
			dayvalue = 31
		} else if (monthValue == 4 || monthValue == 6 || monthValue == 11 || monthValue == 9) {
			dayvalue = 30
		} else if (monthValue == 2) {
			if (yearValue % 4 == 0 && (yearValue % 4 != 0 || yearValue % 400 == 0)) { // 闰年
				dayvalue = 29
			} else {
				dayvalue = 28
			}
		}
		for ( var i = 1; i <= dayvalue; i++) {
			dayId.append('<option value="' + i + '">' + i + '日</option>')
		}
	})
});
