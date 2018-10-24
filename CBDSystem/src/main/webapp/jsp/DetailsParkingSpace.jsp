<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 时间格式化标签库 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="show">
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车位详情展示</title>
<link type="text/css" href="/CBDSystem/css/css1.css" rel="stylesheet" />
<script type="text/javascript" src="/CBDSystem/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/CBDSystem/js/js.js"></script>

<!-- 引入时间插件My97DatePicke中的WdatePicker.js文件 -->
<script language="javascript" type="text/javascript"
	src="/CBDSystem/js/dateutil/WdatePicker.js"></script>
	<!-- 引入外部js文件 -->
			<script type="text/javascript" src="/CBDSystem/js/ShowParkingSpace.js"></script>
</head>

<body>
	<div class="hrader" id="header">
		<div class="top">
			<a href="/jsp/login.jsp" style="color:#C94E13;">登录</a> <a
				href="/jsp/regist.jsp">注册</a>
			<ul class="topNav">
				<li class="shoucangjia"><a onclick="turn()">个人中心</a></li>
				<div class="clears"></div>
			</ul>
		</div>
	</div>
	<!--hrader/-->
	<div class="mid">
		 <h1 class="logo" style="text-align:left;">
			<a href="index.html"><img
				src="/CBDSystem/parking/images/logo.png" width="304" height="74" /></a>
		</h1> 
		<div class="ding-gou"><div class="clears"></div>
		</div>
		<!--ding-gou/-->
	</div>
	<!--mid-->
	<div class="navBox navBg2">
		<ul class="nav">
			<li><a href="/CBDSystem/index.jsp">首页</a></li>
			<div class="clears"></div>
		</ul>
		<!--nav/-->
	</div>
	<!--navBox/-->
	<div class="banner">
		<div class="banLeft">
			<div class="focus">
				<ul class="rslides f426x240">
					<li><a class="clj" href="#"><img
							src="/CBDSystem/images/parking/images/dt1.jpg" width="404"
							height="300" /></a></li>
					<li><a class="clj" href="#"><img
							src="/CBDSystem/images/parking/images/dt2.jpg" /></a></li>
					<li><a class="clj" href="#"><img
							src="/CBDSystem/images/parking/images/dt3.jpg" /></a></li>
					<li><a class="clj" href="#"><img
							src="/CBDSystem/images/parking/images/dt3.jpg" /></a></li>
					<li><a class="clj" href="#"><img
							src="/CBDSystem/images/parking/images/dt4.jpg" /></a></li>
				</ul>
			</div>
			<!--focus/-->
		</div>
		<!--banLeft/-->
		<div class="banRight">
			<!-- <img src="/CBDSystem/parking/images/xinpin.jpg" width="195"
				height="57" /> -->
			<div class="newPhone">
				<img src="/CBDSystem/images/parking/images/qiangchewei.jpg"
					width="180px" height="165px" />
			</div>
			<div class="phonePar">
				<span style="margin-left:40px;">平台车位均价</span><br /> <strong
					class="cheng">10元/小时</strong> <span class="hui">15元/小时</span>
			</div>
			<!---->
		</div>
		<!--banRight/-->
		<div class="clears"></div>
	</div>
	<!--banner/-->
	<div class="proBox">

		<!--*********************车位详情展示部分**************************************************************************-->
		<div class="sells">
			<dl>
				<dt>
					<a href="buyinfo.html"><img src="${one.img}" width="200px"
						height="220px" /></a>
				</dt>
				<dd>
					<h3>
						<a href="buyinfo.html">车位号：${one.parkingNum}</a>
					</h3>
					<h4>车位地点：${one.address}</h4>
					<h5>
						车位单价：<span>${one.price}元/小时</span>
					</h5>
					<div class="tishi">
						<span>车位空闲时间：</span>
						<div class="startTime">
							开始：
							<fmt:formatDate value="${one.startTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</div>
						<div class="endTime">
							结束：
							<fmt:formatDate value="${one.endTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</div>
					</div>
					<input type="hidden" id="pid" value="${one.id }"/>
					<div class="sellmails">
						<div class="form1">
							<form action="/CBDSystem/show.do">
								<input type="hidden" value="${one.id}" />
								<div class="hint">请选择租用车位的时间：</div>
								<div class="time1">
									<label>开始时间：</label><input class="Wdate" id="startTime" type="text"
										onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> <br />
									<br />
								</div>
								<div class="time2">
									<label>结束时间：</label><input class="Wdate" id="endTime" type="text"
										onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div>
								<div class="time2">
									<!-- <input class="time2-button" type="submit"/> -->
								</div>

								<a href="javascript:order()">预约车位</a>
								 <a class="sellmai" onclick="pay()">立即下单</a>
							</form>
						</div>
					</div>
				</dd>

				<!-- *****************************底部导航栏******************************************************************************** -->
				<div class="clears"></div>
			</dl>

			<br />

			<!--*****************************页码部分***********************************************  -->

		</div>


	</div>
	<!--  ************************底部导航栏  *********************************************************************************-->
	<div class="footBox">
		<div class="footers">
			<div class="footersLeft">
				<a href="#"><img
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
			<!--footersRight/-->
			<div class="clears"></div>
		</div>
		<!--footers/-->
	</div>
	
	<script>
		function pay(){
			$.ajax({
				url:"/CBDSystem/pay.do",
				type:"post",
				data:{
					"startTime":$("#startTime").val(),
					"endTime":$("#endTime").val(),
					"parking.id":$("#pid").val()
				},
				dataType:"json",
				success:function(data){
					if(data==0){
						alert("添加订单失败");
					} else {
						window.location.href="/CBDSystem/apply.do?orderId="+data;
					}
				}
			});
		}
		
		function order(){
			$.ajax({
				url:"/CBDSystem/pay.do",
				type:"post",
				data:{
					"startTime":$("#startTime").val(),
					"endTime":$("#endTime").val(),
					"parking.id":$("#pid").val()
				},
				dataType:"json",
				success:function(data){
					if(data==0){
						alert("添加订单失败");
					} else {
						alert("添加订单成功");
					}
				}
			});
		}
	</script>
</body>
	</html>
</div>
