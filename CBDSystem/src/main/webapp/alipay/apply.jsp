<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支付</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>
	<script type="text/javascript" src="js/datatime.js"></script>

  </head>
  <style>
        body{
            margin: 0 0;
            background-color: #EFF0F1;
        }
        .head{
            width: 100%;
            height: 50px;
            background-color: #fff;
            border-bottom: 1px solid #d7d8d8;
            box-shadow: 0 1px 1px #ddd;
            margin-bottom: 1px;
        }
        .header-container {
            width: 950px;
            height: 100%;
            margin: 0 auto;
            padding-top: 10px;
        }
        .header-title {
            float: left;
            width: 82px;
            height: 22px;
            padding-top: 10px;
            padding-right: 15px;
            background-repeat: no-repeat;
            border-right: 1px solid gray;
            background-image: url(https://t.alipayobjects.com/images/rmsweb/T13IFgXjlaXXXXXXXX.png);
        }
        .logo-title {
            font: normal 18px/26px Microsoft YaHei,SimSun;
            color: #1a1a1a;
            float: left;
            padding-left: 10px;
            margin-top: 2px;
        }
        .logo-title {
            font: normal 18px/26px Microsoft YaHei,SimSun;
            color: #1a1a1a;
            float: left;
            padding-left: 10px;
            margin-top: 2px;
        }
        .header-right {
            font: normal 15px/15px Microsoft YaHei,SimSun;
            color: #1a1a1a;
            float: left;
            padding-left: 500px;
            margin-top: 8px;
        }
        .main {
            width: 950px;
            height: 100%;
            margin: 50px auto;
            padding-top: 10px;
        }
        .image{
            margin: 50px 20px 50px;
            width: 200px;
            height: 200px;
            float: left;
        }
        .message {
            float: left;
            height: 70px;
            width: 500px;
            padding-left: 200px;
            line-height: 100px;
            vertical-align: middle;
        }
        .pay {
            color: #ff8208;
            font-weight: 700;
            font-size: 22px
        }
        .date{
        	color: #ff8208;
    		font-weight: 700;
    		font-size: 18px;
        }
    </style>
  <body>
  	<div class="head">
        <div class="header-container">
            <div class="header-title"></div>
            <div class="logo-title">我的收银台</div>
            <div class="header-right">找人代付  |  唯一热线：95188</div>
        </div>
    </div>
    <div class="main">
        <div class="image"><img alt="支付二维码" src="${QRcode}"></div>
        <div class="message">收款方:  <span class="date">CBDSystem停车租赁公司</span></div>
        <div class="message">订单编号:  <span class="date">${order.id}</span></div>
        <div class="message">车位位置:  <span class="date">${order.parking.address}  ${order.parking.parkingNum}</span></div>
        <div class="message"> 时间:  <span class="date"><fmt:formatDate value="${order.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>  到  <span class="date"><fmt:formatDate value="${order.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></div>
        <div class="message">金额:<span class="pay"> ${order.pay}</span>元</div>
    </div>
    <div><fmt:formatDate value="${order.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
  </body>
  <script type="text/javascript">
 	function QueryState(){
 		$.ajax({
  			url:"queryState.do",
  			type:"post",
  			async:true,
  			data:{
  				"orderId":${order.id}
  			},
  			dataType:"json",
  			success:function(data){
  				if(data){
  					alert("支付成功");
  					window.location.href="/CBDSystem/index.jsp";
  				}
  			}
 		})
 	}
 	
 	setInterval(QueryState, 1000);
  </script>
</html>
