<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0057)http://www.17sucai.com/preview/1/2017-01-13/dh/index.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
	<title>包租用户修改信息主页</title>
	<link rel="stylesheet" type="text/css" href="../index.css">
</head>
<body>

<div class="wrap">
	<div class="logo">
	
	  密&nbsp&nbsp码：&nbsp&nbsp&nbsp<input type="text" name="password"value=${user.password}><br><br>
	  电&nbsp&nbsp话：&nbsp&nbsp&nbsp<input type="text" name="tel"value=${user.tel}><br><br>
   	  地&nbsp&nbsp址：&nbsp&nbsp&nbsp<input type="text" name="address"value=${user.address}><br><br>
   	  邮&nbsp&nbsp箱：&nbsp&nbsp&nbsp<input type="text" name="email"value=${user.email}><br><br>
   	  职&nbsp&nbsp业：&nbsp&nbsp&nbsp<input type="text" name="job"value=${user.job}><br><br>
   		<a href="../UserHome.jsp"> <input type="submit" value="完成"></a><br>
	</div>

</div>
<div class="nav-main">
<div class="nav-box">
<div class="nav">
  <ul class="nav-ul">
  	<li><a href="../UserHome.jsp#" class="home"><span>首页</span></a></li>
  	<li><a href="../UserHome.jsp#" class="develop"><span>个人信息</span></a></li>
  	<li><a href="../UserHome.jsp#" class="wechat"><span>历史记录</span></a></li>
  	<li><a href="../UserHome.jsp#" class="case"><span>我的车位</span></a></li>
  	<li><a href="../UserHome.jsp#" class="news"><span>车位信息</span></a></li>
  	<li><a href="UserHome.jsp#" class="contact"><span></span></a></li>
  </ul>
</div>
<!-- <div class="nav-slide">
    <div class="nav-slide-o" style="display: none;"></div>
    <div class="nav-slide-o" style="display: block;">
    	<ul>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>查看个人信息</span></a></li>
    		<li><a href="jsp/ModificationPersonal.jsp#"><span>修改个人信息</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview /1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    	</ul>
    </div>
    <div class="nav-slide-o" style="display: none;">
    	<ul>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>查看交易历史记录</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    	</ul>
    </div>
    <div class="nav-slide-o" style="display: none;">
    	<ul>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>查看我的车位</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>车位招租信息</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>查看被租车位信息</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>查看租借用户信息</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span></span></a></li>
    	</ul>
    </div>
    <div class="nav-slide-o" style="display: none;">
    	<ul>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    		<li><a href="http://www.17sucai.com/preview/1/2017-01-13/dh/index.html#"><span>企业建站</span></a></li>
    	</ul>
    </div>
</div>
</div>
</div> -->

<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
	var thisTime;
	$('.nav-ul li').mouseleave(function(even){
			thisTime	=	setTimeout(thisMouseOut,1000);
	})

	$('.nav-ul li').mouseenter(function(){
		clearTimeout(thisTime);
		var thisUB	=	$('.nav-ul li').index($(this));
		if($.trim($('.nav-slide-o').eq(thisUB).html()) != "")
		{
			$('.nav-slide').addClass('hover');
			$('.nav-slide-o').hide();
			$('.nav-slide-o').eq(thisUB).show();
		}
		else{
			$('.nav-slide').removeClass('hover');
		}
		
	})
	
	function thisMouseOut(){
		$('.nav-slide').removeClass('hover');
	}
	 
	$('.nav-slide').mouseenter(function(){
		clearTimeout(thisTime);
		$('.nav-slide').addClass('hover');
	})
	$('.nav-slide').mouseleave(function(){
		$('.nav-slide').removeClass('hover');
	})

})
</script>


</body></html>