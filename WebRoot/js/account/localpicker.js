/*!
 * KEEKAN Local picker plug v1.0.0
 * http://keekan.com
 * 
 * Copyright 2012 jQuery Foundation and other contributors
 * keekan@keekan.com
 * 
 * Date: Thu Aug 09 2012 16:24:48 GMT-0400 (Eastern Daylight Time)
 */

$(function() {

	var country = $("#countryId");
	var townId = $("#townId");
	var districtId = $("#districtId");
	
	townId.data("city1", [ "请选择", "请选择" ]);
	districtId.data("city2", [ "请选择", "请选择" ]);

	// 默认省级下拉
	if (country.data("province")) {
		country.append("<option value='" + country.data("province")[1] + "'>" + country.data("province")[0] + "</option>");
	}
	$.each(ND, function(index, data) {
		country.append("<option value='" + data + "'>" + data + "</option>");
	});
	// 默认的1级城市下拉
	if (townId.data("city1")) {
		townId.append("<option value='" + townId.data("city1")[1] + "'>"
				+ townId.data("city1")[0] + "</option>");
	}
	// 默认的2级城市下拉
	if (districtId.data("city2")) {
		districtId.append("<option value='" + districtId.data("city2")[1] + "'>"
				+ districtId.data("city2")[0] + "</option>");
	}
	// 省级联动 控制
	var index1 = "";
	country.change(function() {
		// 清空其它2个下拉框
			townId[0].options.length = 0;
			districtId[0].options.length = 0;
			index1 = this.selectedIndex;
			if (index1 == 0) { // 当选择的为 “请选择” 时
				if (townId.data("city1")) {
					townId.append("<option value='" + townId.data("city1")[1]
							+ "'>" + townId.data("city1")[0] + "</option>");
				}
				if (districtId.data("city2")) {
					districtId.append("<option value='" + districtId.data("city2")[1]
							+ "'>" + districtId.data("city2")[0] + "</option>");
				}
			} else {
				$.each(PD[index1 - 1], function(index, data) {
					townId.append("<option value='" + data + "'>" + data
							+ "</option>");
				});
				$.each(MD[index1 - 1][0], function(index, data) {
					districtId.append("<option value='" + data + "'>" + data
							+ "</option>");
				})
			}
		}).change();
	// 1级城市联动 控制
	var index2 = "";
	townId.change(function() {
		districtId[0].options.length = 0;
		index2 = this.selectedIndex;
		$.each(MD[index1 - 1][index2], function(index, data) {
			districtId.append("<option value='" + data + "'>" + data + "</option>");
		})
	});
});