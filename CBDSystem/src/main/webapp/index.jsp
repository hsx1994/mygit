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
<body onload="upCurrentPage(1)">
	<!-- <body > -->
	<div class="hrader" id="header">
		<div class="top">
			<script>
				
			
			</script>
			<a href="/CBDSystem/jsp/login.jsp" style="color:#C94E13;">登录</a> <a href="/CBDSystem/jsp/PersonalRegister.jsp">注册</a>
			<ul class="topNav">
				<!-- <li><a href="order.html">我的订单 </a></li> -->

				<li class="shoucangjia"><a href="shoucang.html">个人中心</a></li>
				<!-- <li class="kefus"><a href="#">客服</a></li> -->

				<div class="clears"></div>
			</ul>
		</div>
	</div>

	<div class="mid">
		<h1 class="logo" style="text-align:left;">
			<a href="index.html"><img
				src="/CBDSystem/images/parking/images/logo.png" width="304"
				height="74" /></a>
		</h1>
		<!--subBox/-->
		<div class="ding-gou">
			<!--ding/-->
			<!-- <div class="gou">
				<a href="car.html"><img
					src="/CBDSystem/images/parking/images/gouwuche.jpg" width="126"
					height="32" /></a>
			</div> -->
			<!--gou/-->
			<div class="clears"></div>
		</div>
		<!--ding-gou/-->
	</div>
	<div class="navBox navBg2">
		<ul class="nav">
			<li><a href="/CBDSystem/jsp/ShowParkingSpace.jsp">首页</a></li>
			<!-- <li><a href="buy.html">个人中心</a></li>
			<li class="navCur"><a href="sell.html">企业中心</a></li>
			<li><a href="vip.html">CBD中心</a></li>
			<li><a href="xuanshang.html">注册</a></li> -->
			<!-- <li><a href="luntan.html" class="luntan">论坛</a></li> -->
			<!-- <li><a href="help.html">帮助</a></li> -->
			<div class="clears"></div>
		</ul>
		<!--nav/-->
	</div>
	<!--navBox/-->
	<form action="#" method="get" class="proDingzhi">
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
					<form action="/CBDSystem/findByNum.do"   method="post">
					<td>&nbsp;&nbsp;车位序号：<input type="text" name="num" />&nbsp;&nbsp;&nbsp;
						<input type="submit" class="queen"  />
					</td>
					</form>

				</tr>
			
			<tr>
				<th>
					<h3>按价格查找：</h3>
				</th>
				<td>&nbsp;&nbsp;价格区间：<input type="text" />--<input type="text" />&nbsp;元/小时&nbsp;&nbsp;
					<input type="submit" class="queen" />
				</td>
			</tr>

			<tr>
				<th>
					<h3>按时间查找：</h3>
				</th>
				<td>&nbsp;&nbsp;时间区间：<input class="Wdate" type="text"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />--&nbsp;<input
					class="Wdate" type="text"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />&nbsp;
					&nbsp; <input type="submit" class="queen" />
				</td>
			</tr>




			<!--*****************************************************************************  -->
			<!-- <tr>
				<th>
					<h3>高级功能</h3>
				</th>
				<td>
					<div class="proPosition">
						<ul class="xuan moreHeight">
							<li><input type="checkbox" /><a href="#">双卡双待</a></li>
							<li><input type="checkbox" /><a href="#">高清视频</a></li>
							<li><input type="checkbox" /><a href="#">WIFI</a></li>
							<li><input type="checkbox" /><a href="#">前置摄像头</a></li>
							<li><input type="checkbox" /><a href="#">电视播放</a></li>
							<div class="clearfix"></div>
						</ul>
						xuan/
						<span class="duoxuan"> 多选 </span>
						duoxuan/
						<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
					</div>
				</td>
			</tr> -->


			<!-- ********************************************************************** -->
			<!-- <tr>
				<td colspan="2">
					<ul class="xuan2">
						<li><a href="#">网络制式</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">摄像头像素</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">上市时间</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">显示屏尺寸</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">操控</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">外观</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">系统</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">屏幕色彩</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">分辨率</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">电池可拆卸</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">单卡双卡</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<li><a href="#">手机内存</a>
							<div class="chilXuan">
								<div class="chilXBox">
									<div>
										<input type="checkbox" /><a href="#">选项1</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项2</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项3</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项4</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项5</a>
									</div>
									<div>
										<input type="checkbox" /><a href="#">选项6</a>
									</div>
									<div class="clears"></div>
									<span class="duoxuan"> 多选 </span>
									duoxuan/
									<input type="image" src="/CBDSystem/images/parking/images/queding.png" class="queen2" />
								</div>
								chilXBox
							</div>
							chilXuan/</li>
						<div class="clearfix"></div>
					</ul>
					xuan2/
				</td>
			</tr> -->
		</table>

		<!--proDSel/-->
		<!-- <div style="height:15px;">&nbsp;</div>
		<ul class="proSelect">
			<li>综合</li>
			<li>销量 &darr;</li>
			<li>评论 &darr;</li>
			<li>价格 &darr;</li>
			<div class="clears"></div>
		</ul> -->




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
	</form>
	<!--proDingzhi/-->
	<div class="footBox">
		<div class="footers">
			<div class="footersLeft">
				<a href="index.html"><img
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
			<
			<!-- div class="footer" style="text-align:left;">
		<a href="#">关于我们</a> <a href="#">友情链接</a> <a href="#">版权声明</a> <a
			href="#">网站地图</a> <br /> <span>&copy; 2014 Unqezi 使用前必读 更多模板：<a
			href="http://www.mycodes.net/" target="_blank">源码之家</a></span>
	</div> -->
			<!--footer/-->

			<!-- 引入外部js文件 -->
			<script type="text/javascript"
				src="/CBDSystem/js/ShowParkingSpace.js"></script>
</body>
	</html>
</div>