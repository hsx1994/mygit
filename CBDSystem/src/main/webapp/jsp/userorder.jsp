<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>抢租用户主页</title>
<link type="text/css" href="/CBDSystem/css/csss.css" rel="stylesheet" />
<script type="text/javascript" src="/CBDSystem/js/jquery-1.9.11.min.js"></script>

</head>

<body>
 <div class="hrader" id="header">
  <div class="top">
	<a style="color:#C94E13;">欢迎您:${sessionScope.login.name }</a> 
    <a onclick="logOut()">注销</a>
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a><img src="../images/logo.png" width="304" height="74" /></a>
  </h1>
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li class="navCur"><a href="/CBDSystem/index.jsp">首页</a></li>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="../images/vipImg.jpg" width="183" height="169" /></h2>
   <h3 class="vipName">抢租客</h3>
   <dl class="vipNav">
    <dt class="vip_1">用户中心</dt>
     <dd><a href="LookTwoCar.jsp">查看上架车位</a></dd>
    <dt class="vip_2">个人中心</dt>
     <dd class="ddCur"><a href="two.jsp">个人信息</a></dd>
     <dd><a href="RentUser.jsp">修改个人信息</a></dd>
     <dd><a href="updatepasswd2.jsp">修改密码</a></dd>
     <dd><a href="LookTwoUser.jsp">查看租赁记录</a></dd>
    <dt class="vip_3"></dt>
     <dd><a></a></dd>
     <dd><a></a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
	<div class="vipRight">
		<h2 class="vipTitle">我的订单</h2>
		<button onclick="changeOrder(success)">已完成订单</button>
		<button onclick="changeOrder(failed)">未支付订单</button>
   
   		<h2 class="oredrName">我的订单 <span style="margin-left:40px;">已完成: <span class="red" id="successfulOrder"></span> </span>
    		<span>未支付: <span class="red" id="failedOrder"></span></span>
    	</h2>
    	<table class="main">
    		<tr>
				
				<th>订单编号</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>车位号</th>
				<th>车位总价</th>
				<th>订单状态</th>
				<th>操作</th>
				
			</tr>
    		<c:forEach items="${list}" var="obj">
				<tr>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.id }</td>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.startTime }</td>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.endTime}</td>
					
					<td style="width: 198px;height: 100px;text-align: center;">${obj.parking.parkingNum }</td>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.pay }</td>
					<c:if test="${obj.state==1 }">
						<a>已完成</a>
						<form action="/CBDSystem/addComplaint.do" method="post">
							<input type="hidden" value="${obj.id }" name="id">
				     		<button type="submit">添加投诉</button>
				    	</form>
					</c:if>
					<c:if test="${obj.state==0 }">
						<a>未完成</a>
						<form action="/CBDSystem/addComplaint.do" method="post">
							<input type="hidden" value="${obj.id }" name="id">
				     		<button type="submit">去付款</button>
				    	</form>
					</c:if>
				    <td style="width: 198px;height: 100px;text-align: center;">
				    </td>
				</tr>
			</c:forEach>
     		<tr>
        		<td align="left" valign="top" class="fenye"> &nbsp;&nbsp;
      			<a href="#" onclick="showHTContract(${pageinfo.firstPage})"  target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
	        	<c:if test="${pageinfo.hasPreviousPage}">
	        	<a href="#"onclick="showHTContract(${pageinfo.prePage})" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
	        	</c:if>
	    			 ${pageinfo.pageNum}/${pageinfo.pages} 页&nbsp;&nbsp;
	        	<c:if test="${pageinfo.hasNextPage}">
	        	<a href="#"onclick="showHTContract(${pageinfo.nextPage})" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
	        	</c:if>
	        	<a href="#" onclick="showHTContract(${pageinfo.lastPage})" target="mainFrame" onFocus="this.blur()">尾页</a>
         		</td>
    		</tr>
    </table><!--vipOrder/-->
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a><img src="../images/ftlogo.jpg" width="240" height="64" /></a>
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
 </div><!--footer/-->
 	<script type="text/javascript">
		function showOrder(){
			$.ajax({
				url:"",
				type:"post",
				data:{},
				dataType:"json",
				successful:function(data){
					
				}
			})
		}
	</script>
</body>
	
</html>
