<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入时间插件My97DatePicke中的WdatePicker.js文件 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0065)http://www.17sucai.com/preview/87827/2015-03-19/404web/index.html -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>403页面自动跳转</title>
<script type="text/javascript" src="/CBDSystem/js/jQuery-2.2.2.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	outline: none;
	font-family: \5FAE\8F6F\96C5\9ED1, 宋体;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	-khtml-user-select: none;
	user-select: none;
	cursor: default;
	font-weight: lighter;
}

.center {
	margin: 0 auto;
}

.whole {
	width: 100%;
	height: 100%;
	line-height: 100%;
	position: fixed;
	bottom: 0;
	left: 0;
	z-index: -1000;
	overflow: hidden;
}

.whole img {
	width: 100%;
	height: 100%;
}

.mask {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background: #000;
	opacity: 0.6;
	filter: alpha(opacity = 60);
}

.b {
	width: 100%;
	text-align: center;
	height: 400px;
	position: absolute;
	top: 50%;
	margin-top: -230px
}

.a {
	width: 150px;
	height: 50px;
	margin-top: 30px
}

.a a {
	display: block;
	float: left;
	width: 150px;
	height: 50px;
	background: #fff;
	text-align: center;
	line-height: 50px;
	font-size: 18px;
	border-radius: 25px;
	color: #333
}

.a a:hover {
	color: #000;
	box-shadow: #fff 0 0 20px
}

p {
	color: #fff;
	margin-top: 40px;
	font-size: 24px;
}

#num {
	margin: 0 5px;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	var num = 3;
	function redirect() {
		num--;
		document.getElementById("num").innerHTML = num;
		if (num < 0) {
			document.getElementById("num").innerHTML = 0;
			history.back();								
		}
	}
	setInterval("redirect()", 1000);
</script>
</head>

<body onload="redirect()">
	<div class="whole">
		<img src="./images/back.jpg">
		<div class="mask"></div>
	</div>
	<div class="b">
		<p>
			不能访问该资源<br> 没有足够的权限，请联系管理员<br> <span id="num">3</span>秒后自动跳转到上一个页面
		</p>
	</div>
</body>
</html>