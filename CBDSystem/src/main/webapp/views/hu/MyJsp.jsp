<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="application/x-javascript"
	src="../../js/public/jquery.1.9.1.js"></script>
<head>
<title>验证码校验测试</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
	手机号验证
	<input type="text" id="number">
	<input type="text" id="code">
	<button onclick="num()">发送验证码</button>
	<button onclick="code()">提交</button>
</body>
<script type="text/javascript">
	function num() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("post", "/CBDSystem/phone.do", true);
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlhttp.send("number=" + $("#number").val());
		//处理响应，监控状态码
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
				//接受服务器响应回来的内容
				var obj = xmlhttp.responseText;
				//同dom操作将数据显示到页面
				alert(11);
			}
		}
	}
	;
	function code() {
		/* var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("post", "/CBDSystem/number.do", true);
			xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xmlhttp.send("num=" +  $("#code").val());
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
					//接受服务器响应回来的内容
					var obj = xmlhttp.responseText;
					//同dom操作将数据显示到页面
					window.location.href="login.html";		
				}
			} */
		$.ajax({
			url : "/CBDSystem/number.do",
			type : "post",
			data : {
				num : $("#code").val()
			},
			dataType : "json",
			success : function(data) {
				if (data == "注册成功") {
					window.location.href = "login.html";

				} else {
					window.location.href = "regist.jsp";

				}



			}
		});



	}
	;
</script>
</html>
