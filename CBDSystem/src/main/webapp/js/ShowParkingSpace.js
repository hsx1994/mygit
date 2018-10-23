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
/*
 * 根据不同角色跳转到相应的个人空间
 */
function turn() {
	// 如果用户已经登录
	var role = $("#role").val();
	switch (role) {
	case "":
		window.location.href = "/CBDSystem/jsp/login.jsp";
		break;
	case "抢租客":
		window.location.href = "/CBDSystem/jsp/two.jsp";
		break;
	case "包租婆":
		window.location.href = "/CBDSystem/jsp/one.jsp";
		break;
	case "企业用户":
		window.location.href = "/CBDSystem/jsp/three.jsp";
		break;
	}
}
