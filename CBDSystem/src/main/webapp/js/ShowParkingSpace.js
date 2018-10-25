//获取当前页数
function getCurrentPage() {
	var currentPage = $("#currentPage").html();
	return currentPage;
}

// 展示抢租客车位页面（page当前页数）
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
			//刷新当前页面
			$("body").attr("onload", "upCurrentPage(1)");
			//首页
			$("#first").attr("onclick", "upCurrentPage(1)");
			//下一页
			$("#next").attr("onclick", "upCurrentPage("+$("#nexth").val()+")");
			//上一页
			$("#pre").attr("onclick", "upCurrentPage("+$("#preh").val()+")");
			//末页
			$("#last").attr("onclick", "upCurrentPage("+$("#lasth").val()+")");
		},
		
	})
};


//前台企业车位展示
function upConpany(page){
	$.ajax({
		type : "post",
		url : "/CBDSystem/showCompanyAll.do",
		data : {
			"page" : page,
		},
		dataType : "html",
		success : function(data) {

			$("#show").html(data);
		}

	})
}



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


//按时间区间查找车位
function upTime(page) {	
	$.ajax({
		type : "post",
		url : "/CBDSystem/findByTime.do",
		data : {
			"startTime":$("#time1").val(),
			"endTime":$("#time2").val(),
			"page" : page,
		},
		dataType : "html",
		success : function(data) {
			$("#show").html(data);
		}

	})
};



//按价格查询
function upPrice(page){
	$.ajax({
		
		url:"/CBDSystem/findByPrice.do",
		type:"post",
		data:{
			"price1":$("#price1").val(),
			"price2":$("#price2").val(),
			"page":page,
			
		},
		dataType:"html",
		success:function(data){
			$("#show").html(data);
			//刷新当前页面
			$("body").attr("onload", "upPrice(1)");
			//首页
			$("#first").attr("onclick", "upPrice(1)");
			//下一页
			$("#next").attr("onclick", "upPrice("+$("#nexth").val()+")");
			//上一页
			$("#pre").attr("onclick", "upPrice("+$("#preh").val()+")");
			//末页
			$("#last").attr("onclick", "upPrice(2)");
		}
		
	});
}


//按车位号模糊查看车位
function upNum(page) {
	$.ajax({
		type : "post",
		url : "/CBDSystem/findByNum.do",
		data : {
			"num":$("#num").val(),
			"page" : page,
		},
		dataType : "html",
		success : function(data) {
			$("#show").html(data);
		}

	})
};

