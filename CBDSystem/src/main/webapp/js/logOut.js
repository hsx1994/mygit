function logOut(){
	$.ajax({
		url:"/CBDSystem/logoutExit.do",
		type:"post",
		data:{},
		dataType:"json",
		success:function(data){
			alert("注销成功");
			window.location.href="/CBDSystem"+data;
		}
	});
}
