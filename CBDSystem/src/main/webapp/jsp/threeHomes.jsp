<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>包租用户主页</title>
<link href="../css/styles.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
</head>
<body>
<!--演示内容开始-->
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;text-decoration:none;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";background:#E8E8E8;}
.clearfix:after{content:".";display:block;height:0;clear:both;visibility:hidden;}
.clearfix{display:inline-table;}/* Hides from IE-mac */
*html .clearfix{height:1%;}
.clearfix{display:block;}/* End hide from IE-mac */
*+html .clearfix{min-height:1%;}
/* menu */
.menu{width:355px;background:url(../images/nav-bg.png) no-repeat;}
.menu ul{margin:0 0 0 42px;}
.menu ul li{width:164px;height:29px;padding-bottom:8px;overflow:hidden;position:relative;float:left;display:inline;}
.menu ul li a{display:block;width:164px;height:29px;line-height:26px;font-family:"微软雅黑";font-size:16px;color:#FFFFFF;text-indent:62px;overflow:hidden;position:relative;z-index:100000;}
.menu ul li p{position:absolute;z-index:100;top:0;left:-164px;width:164px;height:29px;background:url(images/nav-libg.png) no-repeat; }
.menu ul li b{position:absolute;z-index:100000;top:0;left:0;display:block;width:11px;height:29px;background:url(images/nav-jiao2.png) no-repeat;}
.menu ul li.current p{left:0;}
.menu ul li.current a{color:#0072d2;}
</style>

<div class="menu">
	<ul class="clearfix">
		<li class="current"><a href="http://sc.chinaz.com/">企业信息</a></li>
		<li><a href="jsp/EnterpriseUser.jsp">修改信息</a></li>
		<li><a href="http://sc.chinaz.com/">查看交易历史</a></li>
		<li><a href="http://sc.chinaz.com/">查看已租车位</a></li>
		<li><a href="http://sc.chinaz.com/">车位招租信息</a></li>
		<li><a href="http://sc.chinaz.com/">查看被租车位信息</a></li>
		<li><a href="http://sc.chinaz.com/">查看包租用户信息</a></li>
		<li><a href="http://sc.chinaz.com/"></a></li>
		<li><a href="http://sc.chinaz.com/"></a></li>
		<li><a href="http://sc.chinaz.com/">注销</a></li>
	</ul>
</div>


<script type="text/javascript">
$(function(){
	$(".menu ul li").append("<b class='pngFix'></b><p class='pngFix'></p>");
	
	$(".menu ul li").hover(function(){
		if($(this).attr("class") != "current"){
			$(this).children("p").stop().animate({left:"0px"},200);
			$(this).children("a").css({color:"#0072d2"},900);
		}
	},function(){
		if($(this).attr("class") != "current"){
			$(this).children("p").stop().animate({left:"-164px"},300);
			$(this).children("a").css({color:"#FFFFFF"},900);
		}
	});

	$(".menu ul li.current").unbind("hover");
});

$(function($){
	var left=0;
	var length=$(".menu li").length;
	for(length;length>0;length--){
		left+=12.60;
		$(".menu li").eq(length-1).css("margin-left",left)
	}
});

function setNav(id){
	var navList = $(".menu ul li");
	$(navList).eq(id-1).addClass("current");
}
</script>
<!--演示内容结束-->
<div style="text-align:center;clear:both">
<p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. </p>
</div>
</body>
</html>