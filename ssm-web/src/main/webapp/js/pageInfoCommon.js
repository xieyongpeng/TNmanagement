$(function() {
	var selected = GetQueryValue('size');
	$("#changePageSize").find("option").each(function() {
		if ($(this).text() == selected) {
			$(this).attr("selected", true);
		}
	});
});

function GetQueryValue(queryName) {
	var query = decodeURI(window.location.search.substring(1));
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == queryName) {
			return pair[1];
		}
	}
	return null;
}

function changePageSize(url) {
	//获取下拉框的值
	var pageSize = $("#changePageSize").val();

	//向服务器发送请求，改变没页显示条数
	location.href = url + "?page=1&size="
			+ pageSize;
}