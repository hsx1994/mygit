//通过ID查询车位详细信息
function showDetailsParking(id){
	$.ajax({
		url:"/CBDSystem/showDetailsParking.do",
		type:"post",
		data:{
			"id":id
		},
		dataType:"html",
		success:function(data){
			$("#show").html(data)
		}
	});
}

//车位通过审核
function applyPass(){
	$.ajax({
		url:"/CBDSystem/passApply.do",
		type:"post",
		data:{
			"id":$("#id").val()
		},
		dataType:"json",
		success:function(data){
			alert(data);
			window.location.href="landlord_carpart_apply.jsp";
		}
	});
}

//车位审批驳回
function applyPassFail(){
	$.ajax({
		url:"/CBDSystem/passApplyFail.do",
		type:"post",
		data:{
			"id":$("#id").val()
		},
		dataType:"json",
		success:function(data){
			alert(data);
			window.location.href="landlord_carpart_apply.jsp";
		}
	});
}