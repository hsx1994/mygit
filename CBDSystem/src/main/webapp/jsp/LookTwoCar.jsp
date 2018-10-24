<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div id="show">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>未完成订单</title>
<link type="text/css" href="../css/csss.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.11.min.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script type="text/javascript" src="/CBDSystem/js/logOut.js"></script>
<style>
		td{
			text-align:center;
		}
  </style>
</head>

<body onload="select(1)">
 <div class="hrader" id="header">
  <div class="top">
   	<a style="color:#C94E13;">欢迎您:${sessionScope.login.name }</a> 
    <a onclick="logOut()">注销</a>
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a href="index.html"><img src="../images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="#" method="get" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="../images/sub.jpg" width="95" height="32" class="subImg" />
    <div class="hotci">
   
   </div><!--hotci/-->
   </div><!--subBox2/-->
  </form><!--subBox/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="/CBDSystem/index.jsp">首页</a></li>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="../images/vipImg.jpg" width="183" height="169" /></h2>
    <h3 class="vipName">抢租客</h3>
   <dl class="vipNav">
    <dt class="vip_1">用户中心</dt>
     <dd ><a href="two.jsp">个人信息</a></dd>
    <dt class="vip_2">个人中心</dt>
     <dd><a href="changeUserInfo.jsp">修改个人信息</a></dd>
     <dd><a href="LookTwoUser.jsp">查看已完成订单</a></dd>
     <dd class="ddCur"><a href="LookTwoCar.jsp">查看未完成订单</a></dd>
     <dd><a href="vipXiaofei.html"></a></dd>
    <dt class="vip_3"></dt>
     <dd><a href="vipQuxiao.html"></a></dd>
     
     <dd><a href="vipTousu.html"></a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
<div class="vipRight">
   <h2 class="vipTitle">未完成订单</h2>
   
				<table class="grzx" width="705" border="0" cellspacing="0"
					cellpadding="0">
						<tr>
							<th width="100"><span>*</span>订单编号</th>
							<th width="100"><span>*</span>开始时间</th>
							<th width="100"><span>*</span>结束时间</th>
							<th width="100"><span>*</span>车位编号</th>
							<th width="100"><span>*</span>订单总价</th>
							<th width="100"><span>*</span>操作</th>
						</tr>
					<c:forEach items="${list}" var="obj">
						<tr>
							<td>${obj.id }<br/></td>
							<td><fmt:formatDate value="${obj.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/></td>
							<td><fmt:formatDate value="${obj.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/></td>
							<td>${obj.parking.address }${obj.parking.parkingNum }<br /></td>
							<td>${obj.pay}<br/></td>
							<td><a href="/CBDSystem/apply.do?orderId=${obj.id }">去支付</a></td>
						</tr>
					</c:forEach>
					<tr>
				        <td width="100"> 
				       		<a href="#" onclick="select(${pageinfo.firstPage})">首页</a>&nbsp;&nbsp;
				       	</td>
				       	<td width="100">
					        <c:if test="${pageinfo.hasPreviousPage}">
					        <a href="#"onclick="select(${pageinfo.prePage})">上一页</a>&nbsp;&nbsp;
					        </c:if>
					    </td>
					    <td width="100">
					        ${pageinfo.pageNum}/${pageinfo.pages} 页&nbsp;&nbsp;
					    </td>
					    <td width="100">
					        <c:if test="${pageinfo.hasNextPage}">
					        <a href="#"onclick="select(${pageinfo.nextPage})">下一页</a>&nbsp;&nbsp;
					        </c:if>
					    </td>
					    <td width="100">
					        <a href="#" onclick="select(${pageinfo.lastPage})">尾页</a>
				      </td>
				    </tr>
				</table>
    
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.html"><img src="../images/ftlogo.jpg" width="240" height="64" /></a>
    <h3 class="ftphone">400 000 0000 </h3>
    <div class="ftKe">
     客服 7x24小时(全年无休)<br />
     <span>客服邮箱：kefu@webqin.net </span>
    </div><!--ftKe/-->
   </div><!--footersLeft/-->
   <div class="footersRight">
    <ul>
     <li class="ftTitle">新手指南</li>
     <li><a href="#">购物流程</a></li>
     <li><a href="#">会员计划及划分</a></li>
     <li><a href="#">优惠券规则</a></li>
     <li><a href="#">联系客服</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li class="ftTitle">付款方式</li>
     <li><a href="#">在线支付</a></li>
     <li><a href="#">礼品卡支付</a></li>
     <li><a href="#">货到付款</a></li>
     <li><a href="#">银行付款</a></li>
    </ul>
    <ul>
     <li class="ftTitle">配送服务</li>
     <li><a href="#">配送时效及运费</a></li>
     <li><a href="#">超时赔付</a></li>
     <li><a href="#">验货与签收</a></li>
     <li><a href="#">配货信息跟踪</a></li>
    </ul>
    <ul>
     <li class="ftTitle">售后服务</li>
     <li><a href="#">退换货政策</a></li>
     <li><a href="#">退换货区域</a></li>
     <li><a href="#">退款时限</a></li>
     <li><a href="#">先行赔付</a></li>
     <li><a href="#">发票说明</a></li>
    </ul>
    <ul>
     <li class="ftTitle">特色服务</li>
     <li><a href="#">礼品卡</a></li>
     <li><a href="#">产品试用</a></li>
     <li><a href="#">花粉中心</a></li>
     <li><a href="#">快速购物</a></li>
     <li><a href="#">推荐好友</a></li>
    </ul>
    
    <div class="clears"></div>
   </div><!--footersRight/-->
   <div class="clears"></div>
  </div><!--footers/-->
 </div><!--footBox/-->
 <div class="footer" style="text-align:left;">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  <input type="hidden" value="${sessionScope.id }" id="uid" />
 </div><!--footer/-->
  <script>
 	function select(page){
 		$.ajax({
 			url:"/CBDSystem/showlog.do",
 			type:"post",
 			data:{
 				"id":$("#uid").val(),
 				"page":page
 			},
 			dataType:"html",
 			success:function(data){
 				$("#show").html(data);
 			}
 		});
 	}
 </script>
</body>
</html>
</div>
