//显示指定后台管理员的详细详细
function showAdmain(id){
	$.ajax({
		url:"/CBDSystem/showOneAdmin.do",
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
//删除指定管理员
function deleteAdmin(id){
	$.ajax({
		url:"/CBDSystem/deleteAdmin.do",
		type:"post",
		data:{
			"id":id
		},
		dataType:"json",
		success:function(data){
			alert(data);
			window.location.reload();
		}
	});
}
//添加指定管理员
function addAdmin(id){
	var arr = new Array();

	var temp= $("input[type='checkbox']:checked").each(function(index, item) {

		arr.push($(this).val());

	});
	$.ajax({
		url:"/CBDSystem/addAdmin.do",
		type:"post",
		data:{
			"limits":arr,
			"jobNumber":$("#jobNumber").val(),
			"realName":$("#realName").val(),
			"tel":$("#phone").val(),
			"login.name":$("#loginName").val(),
			"login.password":$("#loginPassword").val()
		},
		traditional:true,
		dataType:"json",
		success:function(data){
			alert(data);
			window.location.href="/CBDSystem/views/all_admin_info.jsp";
		}
	});
}


function updatePer(){
	var arr = new Array();

	var temp= $("input[type='checkbox']:checked").each(function(index, item) {
		arr.push($(this).val());
	});
	
	alert(arr);
	$.ajax({
		url:"/CBDSystem/updatePer.do",
		type:"post",
		data:{
			"limits":arr,
			"id":$("#aid").val()
		},
		traditional:true,
		dataType:"json",
		success:function(data){
			alert(data);
			window.location.href="/CBDSystem/views/all_admin_info.jsp";
		}
	});
}
