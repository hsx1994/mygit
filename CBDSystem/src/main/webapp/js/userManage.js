//管理员按条件搜索企业
function searchCompany(pages){
	$.ajax({
		url:"/CBDSystem/queryCompany.do",
		type: "post",
		data:{
			"condition":$("#condition").val(),
			"page":pages,
		},
		dataType:"html",
		success:function(data){
			$("#aaa").html(data)
		}
	})
	
}

//管理员新增企业
function addCompany(){
	$.ajax({
		url:"/CBDSystem/addCompany.do",
		type: "post",
		data:{
			"name":$("#name").val(),
			"comName":$("#comName").val(),
			"password":$("#pwd").val(),
			"repwd":$("#repwd").val(),
			"tel":$("#tel").val(),
			"email":$("#email").val(),
			"contact":$("#contact").val(),
			"address":$("#address").val()
		},
		dataType:"json",
		success:function(data){
			alert(data);
			if(data=="添加成功"){
				window.parent.mainFrame.location.href="company_info.jsp"
			}
				
		}
	});
}

