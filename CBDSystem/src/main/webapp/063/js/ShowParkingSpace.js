//获取当前页数
function getCurrentPage() {
	var currentPage = $("#currentPage").html();
	return currentPage;
}

// 上传当前页数
function upCurrentPage() {
	alert(getCurrentPage());
	$.ajax({
		type : "post",
		url : "/CBDSystem/showall.do",
		data : {
			"currentPage" : getCurrentPage()
		},
//		dataType : "json",
//		success : function(data) {
//			alert(6);
//			alert(data);
//		}
	})
};
//上传当前页数，刷新整个
页面
upCurrentPage();


