<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入时间插件My97DatePicke中的WdatePicker.js文件 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="show">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车位展示</title>
<link type="text/css" href="/CBDSystem/css/css1.css" rel="stylesheet" />
<script type="text/javascript" src="/CBDSystem/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/CBDSystem/js/js.js"></script>
<script language="javascript" type="text/javascript"
	src="/CBDSystem/js/dateutil/WdatePicker.js"></script>
</head>
<body onload="upNum(1)">
	<input type="hidden" value="${sessionScope.login.role }" id="role">
	<!-- <body > -->
	<div class="hrader" id="header">
		<div class="top">
			<c:choose>
				<c:when test="${sessionScope.login.name != null}">
					<span>欢迎您:&nbsp;&nbsp;</span>
					<span>${sessionScope.login.name}</span>
					<span><a href="/CBDSystem/logoutExit.do">注销</a></span>
				</c:when>
				<c:otherwise>
					<a href="/CBDSystem/jsp/login.jsp" style="color:#C94E13;">登录</a> <a href="/CBDSystem/jsp/regist.jsp">注册</a>
				</c:otherwise>
			</c:choose>						
			<ul class="topNav">
				<li class="shoucangjia"><a onclick="turn()">个人中心</a></li>
			</ul>		
		</div>
	</div>

	<div class="mid">
		<h1 class="logo" style="text-align:left;">
			<a><img
				src="/CBDSystem/images/parking/images/logo.png" width="304"
				height="74" /></a>
		</h1>>
	  </div>
	<div class="navBox navBg2">
		<ul class="nav">
			<li><a href="/CBDSystem/index.jsp">首页</a></li>
		</ul>
		<!--nav/-->
	</div>
	<!--navBox/-->
	<div class="proDingzhi">
		<img src="/CBDSystem/images/parking/images/top2.jpg" width="972"
			height="200" />
		<script>
			window._bd_share_config = {
				"common" : {
					"bdSnsKey" : {},
					"bdText" : "",
					"bdMini" : "2",
					"bdMiniList" : false,
					"bdPic" : "",
					"bdStyle" : "0",
					"bdSize" : "24"
				},
				"share" : {}
			};
			with (document)
				0[(getElementsByTagName('head')[0] || body)
						.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
						+ ~(-new Date() / 36e5)];
		</script>
		<table class="proDSel">


			<tr>
				<th>
					<h3>按车位号查找：</h3>
				</th>

				<td>&nbsp;&nbsp;车位序号：<input type="text" name="num" id="num" />&nbsp;&nbsp;&nbsp;
					<button onclick="upNum">提交</button>
				</td>

			</tr>

			<tr>
				<th>
					<h3>按价格查找：</h3>
				</th>
				<td>&nbsp;&nbsp;价格区间：<input id="price1" type="text" />--<input
					id="price2" type="text" />&nbsp;元/小时&nbsp;&nbsp;
					<button onclick="upPrice(1)">提交</button>
				</td>
			</tr>

			<tr>
				<th>
					<h3>按时间查找：</h3>
				</th>
				<td>&nbsp;&nbsp;时间区间：<input id="time1" class="Wdate"
					type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />--&nbsp;<input
					id="time2" class="Wdate" type="text"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />&nbsp;
					&nbsp;
					<button onclick="upTime(1)">提交</button>
				</td>
			</tr>

		<!--**********车位展示部分**********************************************************************************************-->
		<div id="showparking" class="phoneBox">
			<c:forEach items="${all}" var="parking">
				<dl>
					<dt>
						<img src="${parking.img}" />
					</dt>
					<dd>
						<h3>价格：${parking.price}元/小时</h3>
						<div class="phonePars">地址：${parking.address}</div>
						<!--phonePar/-->
						<!-- <div class="xiaoliang">
						<span class="blue">157451条评价</span> <span class="pad">上海有货</span>
					</div> -->
						<!--xiaoliang/-->
						<div class="jiaru-shoucang">
							<span class="jiaruCar">收藏车位</span> <span class="shoucangCar"><a
								href="/CBDSystem/showOne.do?id=${parking.id}">查看详情</a></span>
							<div class="clears"></div>
						</div>
						<!--jiaru-shoucang/-->
					</dd>
				</dl>
			</c:forEach>

			<!-- ***************************************** 分页部分 *****************************************************-->
			<div class="page">
				<div class="content-bottom-paging">
					<a href="#" onclick="upCurrentPage(${paging.lastPage})">末页</a>
				</div>

				<div class="content-bottom-paging">
					<script type="text/javascript">
						
					</script>
					<c:if test="${paging.hasNextPage}">
						<a target="mainFrame" href="#"
							onclick="upCurrentPage(${paging.nextPage})">下一页</a>
					</c:if>
				</div>

				<div id="page" class="content-bottom-paging">
					<span id="currentPage">${paging.pageNum}</span>/<span id="tolPage">${paging.pages}</span>
				</div>
				<div class="content-bottom-paging">
					<c:if test="${paging.hasPreviousPage}">
						<a href="#" onclick="upCurrentPage(${paging.prePage})">上一页</a>
					</c:if>
				</div>
				<div class="content-bottom-paging">
					<a href="#" onclick="upCurrentPage(${paging.firstPage})">首页</a>
				</div>
			</div>





			<div class="clears"></div>
		</div>
		<!--phoneBox/-->
	</div>
	<!--proDingzhi/-->
	<div class="footBox">
		<div class="footers">
			<div class="footersLeft">
				<a><img
					src="/CBDSystem/images/parking/images/ftlogo.jpg" width="240"
					height="64" /></a>
				<h3 class="ftphone">400 000 0000</h3>
				<div class="ftKe">
					客服 7x24小时(全年无休)<br /> <span>客服邮箱：kefu@webqin.net </span>
				</div>
				<!--ftKe/-->
			</div>
			<!--footersLeft/-->
			<div class="footersRight">
				<ul>
					<li class="ftTitle">新手指南</li>
					<li><a href="#">下单流程</a></li>
					<li><a href="#">会员计划</a></li>
					<li><a href="#">优惠规则</a></li>
					<li><a href="#">联系客服</a></li>
					<li><a href="#">常见问题</a></li>
				</ul>
				<ul>
					<li class="ftTitle">付款方式</li>
					<li><a href="#">在线支付</a></li>
					<li><a href="#">优惠券支付</a></li>
					<li><a href="#">现金支付</a></li>
					<li><a href="#">银行付款</a></li>
				</ul>
				<ul>
					<li class="ftTitle">订单服务</li>
					<li><a href="#">下单时效</a></li>
					<li><a href="#">下单超时</a></li>
					<li><a href="#">下单须知</a></li>
					<li><a href="#">查看订单</a></li>
				</ul>
				<ul>
					<li class="ftTitle">发票服务</li>
					<li><a href="#">发票申请</a></li>
					<li><a href="#">电子发票</a></li>
					<li><a href="#">纸质发票</a></li>
					<li><a href="#">补印发票</a></li>
					<li><a href="#">发票说明</a></li>
				</ul>
				<ul>
					<li class="ftTitle">特色服务</li>
					<li><a href="#">礼品卡</a></li>
					<li><a href="#">车位试用</a></li>
					<li><a href="#">车位中心</a></li>
					<li><a href="#">快速下单</a></li>
					<li><a href="#">推荐车位</a></li>
				</ul>

				<div class="clears"></div>
			</div>
			<!--footBox/-->
			
			<!-- 引入外部js文件 -->
			<script type="text/javascript"
				src="/CBDSystem/js/ShowParkingSpace.js"></script>
</body>
	</html>
</div>