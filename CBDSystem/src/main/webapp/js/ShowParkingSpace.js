//获取当前页数
function getCurrentPage() {
	var currentPage = $("#currentPage").html();
	return currentPage;
}

//展示抢租客车位页面（page当前页数）
function upCurrentPage(page) {
	$.ajax({
		type : "post",
		url : "/CBDSystem/showall.do",
		data : {
			"page" : page,
		},
		dataType : "html",
		success : function(data) {
			
			$("#show").html(data);
		}

	})
};

