<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div id="show">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>包租婆查看租赁记录</title>
<link type="text/css" href="../css/csss.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.11.min.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<style>
	td{
		text-align:center;
	}
	th{
		text-align:center;
	}
</style>
</head>

<body onload="select(1)">
 <div class="hrader" id="header">
  <div class="top">
   <a href="login.html" style="color:#C94E13;">请登录</a> 
   <a href="reg.html">注册</a>
   </ul><!--topNav/-->
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
   <h3 class="vipName">用户</h3>
   <dl class="vipNav">
    <dt class="vip_1 vipCur">账户中心</dt>
     <dd><a href="LookMyCar.jsp">我的车位</a></dd>
     <dd><a href="LookOneUser.jsp">申请上架车位</a></dd>
     <dd><a href="LookCar.jsp">已上架车位</a></dd>
    <dt class="vip_2">个人</dt>
     <dd class="ddCur"><a href="one.jsp">个人信息</a></dd>
     <dd><a href="RentUser.jsp">修改个人信息</a></dd>
     <dd><a href="LookOrder.jsp">查看租赁记录</a></dd>
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">租赁记录</h2>
   
    <form action="../findByNum.do" method="post" enctype="multipart/form-data">
				<table class="grzx" width="705" border="0" cellspacing="0"
					cellpadding="0">
					<thead>
						<tr>
							<th width="100"><span>*</span>车位号</th>
							<th width="700"><span>*</span>订单信息</th>
						</tr>
					</thead>
					<c:forEach items="${list }" var="obj">
					<c:if test="${not empty obj.orders }">
						<tr>
							<td>${obj.parkingNum}<br/></td>
							<td>
								<table>
									<thead>
										<tr>
											<th width="150"><span>*</span>订单开始时间</th>
											<th width="150"><span>*</span>订单结束时间</th>
											<th width="150"><span>*</span>订单使用用户</th>
											<th width="150"><span>*</span>订单总价</th>
											<th width="70"><span>*</span>操作</th>
										</tr>
									</thead>
									<c:forEach items="${obj.orders }" var="order">
										<tr>
											<td><fmt:formatDate value="${order.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/></td>
											<td><fmt:formatDate value="${order.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br /></td>
											<td>${order.user.login.name }</td>
											<td>${order.pay }</td>
											<td><button onclick="addComplaint()">投诉</button></td>
										</tr>
									</c:forEach>
									
								</table>
							</td>
						</tr>
						</c:if>
					</c:forEach>
					<tr>
				        <td width="100"> 
				       		<a href="#" onclick="select(${pageinfo.firstPage})"  target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
				       	</td>
				       	<td width="100">
					        <c:if test="${pageinfo.hasPreviousPage}">
					        <a href="#"onclick="select(${pageinfo.prePage})" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
					        </c:if>
					    </td>
					    <td width="100">
					        ${pageinfo.pageNum}/${pageinfo.pages} 页&nbsp;&nbsp;
					    </td>
					    <td width="100">
					        <c:if test="${pageinfo.hasNextPage}">
					        <a href="#"onclick="select(${pageinfo.nextPage})" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
					        </c:if>
					    </td>
					    <td width="100">
					        <a href="#" onclick="select(${pageinfo.lastPage})" target="mainFrame" onFocus="this.blur()">尾页</a>
				      </td>
				    </tr>
				</table>
	</form>
     
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
  <span>&copy; 2014 Unqezi 使用前必读 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></span>
 </div><!--footer/-->
 <input type="hidden" value="${sessionScope.id }" id="uid" />
 <script>
 	function select(page){
 		$.ajax({
 			url:"/CBDSystem/selectOrder.do",
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
 	
 	function addComplaint(){
 		
 	}
 </script>
</body>
</html>
</div>