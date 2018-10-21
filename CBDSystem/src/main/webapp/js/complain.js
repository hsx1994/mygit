//显示指定待处理投诉的详细详细
function showDetailsComplain(id){
	$.ajax({
		url:"/CBDSystem/showDetailsComplain.do",
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

function acceptComplain(state,id){
	$.ajax({
		url:"/CBDSystem/acceptComplain.do",
		type: "post",
		data:{
			"state":state,
			"id":id
		},
		dataType:"json",
		success:function(data){
			alert(data);
			window.parent.mainFrame.location.href="complain_info.jsp";
		}
	});
	
	
}

