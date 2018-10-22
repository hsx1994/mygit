//获取当前页数
function getCurrentPage() {
	var currentPage = $("#currentPage").html();
	return currentPage;
}

// 上传当前页数
function upCurrentPage() {
	$.ajax({
		type : "post",
		url : "/CBDSystem/showall.do",
		data : {
			"currentPage" : getCurrentPage()
		}
	})
};


