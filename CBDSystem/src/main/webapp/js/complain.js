//显示所有待受理的投诉信息
function showComplain(pages){
	$.ajax({
		url:"/CBDSystem/showComplain.do",
		type:"post",
		data:{
			"page":pages
		},
		dataType:"json",
		success:function(data){
			window.location.href=data;
		}
	});
}
showComplain(1);