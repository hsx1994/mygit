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
			$("#nextPage").attr("onclick","queryOutBargain("+$("#next").val()+")");
			$("#prePage").attr("onclick","queryOutBargain("+$("#pre").val()+")");
			$("#firstPage").attr("onclick","queryOutBargain("+$("#first").val()+")");
			$("#lastPage").attr("onclick","queryOutBargain("+$("#last").val()+")");
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
			$("#nextPage").attr("onclick","queryOutHistoryBargain("+$("#next").val()+")");
			$("#prePage").attr("onclick","queryOutHistoryBargain("+$("#pre").val()+")");
			$("#firstPage").attr("onclick","queryOutHistoryBargain("+$("#first").val()+")");
			$("#lastPage").attr("onclick","queryOutHistoryBargain("+$("#last").val()+")");
			
		}
	})
}

//按条件搜索企业租户执行中合约信息
function queryCompanyBargain(pages){
	var a="queryCompanyBargain('${pageinfo.nextPage}')"
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
			$("#nextPage").attr("onclick","queryCompanyBargain("+$("#next").val()+")");
			$("#prePage").attr("onclick","queryCompanyBargain("+$("#pre").val()+")");
			$("#firstPage").attr("onclick","queryCompanyBargain("+$("#first").val()+")");
			$("#lastPage").attr("onclick","queryCompanyBargain("+$("#last").val()+")");
		}
	});
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
			$("#nextPage").attr("onclick","queryHistoryCompanyBargain("+$("#next").val()+")");
			$("#prePage").attr("onclick","queryHistoryCompanyBargain("+$("#pre").val()+")");
			$("#firstPage").attr("onclick","queryHistoryCompanyBargain("+$("#first").val()+")");
			$("#lastPage").attr("onclick","queryHistoryCompanyBargain("+$("#last").val()+")");
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

//企业用户续约界面
function companyContractEextension(bid){
	$.ajax({
		url:"/CBDSystem/tenantContractEextension.do",
		type:"post",
		data:{
			"id":bid
		},
		dataType:"html",
		success:function(data){
			alert(666);
			$("#aaa").html(data);
		}
		
		
	});
}

//外部合约续约界面
function showOutDetailsBargain(bid){
	$.ajax({
		url:"/CBDSystem/outContractExtension.do",
		type:"post",
		data:{
			"id":bid
		},
		dataType: "json",
		success:function(data){
			$("#oldNumber").html(data.bargin.number);
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

