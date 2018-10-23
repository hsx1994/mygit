//按条件搜索执行中外部合约信息
function queryOutBargain(pages){
	$.ajax({
		url:"/CBDSystem/queryOutUseingBargain.do",
		type: "post",
		data:{
			"condition":$("#condition").val(),
			"page":pages
		},
		dataType:"html",
		success:function(data){
			$("#aaa").html(data);
		}
	})
}

//按条件搜索历史外部合约信息
function queryOutHistoryBargain(pages){
	$.ajax({
		url:"/CBDSystem/queryOutHistoryBargain.do",
		type: "post",
		data:{
			"condition":$("#condition").val(),
			"page":pages
		},
		dataType:"html",
		success:function(data){
			$("#aaa").html(data);
		}
	})
}

//按条件搜索企业租户合约信息
function queryCompanyBargain(pages){
	$.ajax({
		url:"/CBDSystem/queryUseingBargain.do",
		type: "post",
		data:{
			"condition":$("#condition").val(),
			"page":pages
		},
		dataType:"html",
		success:function(data){
			$("#aaa").html(data);
		}
	})
}

//按条件搜索企业租户历史合约信息
function queryHistoryCompanyBargain(pages){
	$.ajax({
		url:"/CBDSystem/queryHistoryBargain.do",
		type: "post",
		data:{
			"condition":$("#condition").val(),
			"page":pages
		},
		dataType:"html",
		success:function(data){
			$("#aaa").html(data);
		}
	})
}
//显示外部合约详情
function showOutDetailsBargain(bid){
	$.ajax({
		url:"/CBDSystem/showOutDetailsBargain.do",
		type:"post",
		data:{
			"id":bid
		},
		dataType: "json",
		success:function(data){
			$("#number").html(data.bargin.number);
			$("#company").html(data.bargin.company);
			$("#address").html(data.bargin.address);
			$("#contact").html(data.bargin.contact);
			$("#tel").html(data.bargin.tel);
			$("#startTime").html(data.bargin.startTime);
			$("#endTime").html(data.bargin.endTime);
			$("#carNum").html(data.carNum);
			$("#image").attr("src",data.bargin.img);
		}
	
	});
}

//显示企业合约详情
function showCompanyBargainDetails(bid){
	$.ajax({
		url:"/CBDSystem/showCompanyBargainDetails.do",
		type:"post",
		data:{
			"id":bid
		},
		dataType:"html",
		success:function(data){
			$("#aaa").html(data);
		}
		
		
	});
}

