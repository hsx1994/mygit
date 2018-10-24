function logOut(){
	$.ajax({
		url:"/CBDSystem/logoutExit.do",
		type:"post",
		data:{},
		dataType:"json",
		success:function(data){
			alert(data);
			window.location.href="/CBDSystem/index.jsp";
		}
	});
}
