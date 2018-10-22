<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车位展示页面</title>
<!-- 引入css样式 -->
<link href="063/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- 引入js文件 -->
<script type="text/javascript" src="063/js/jquery.min.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="total">
			<div class="header">
				<div class="header-bot">
					<div class="logo">
						<a href="index.html"><img src="063/images/logo.png" alt="" /></a>
					</div>
					<div class="f-right">
						<p class="welcome-msg">Welcome to our online CBDSystem!</p>
						<div class="clear"></div>
						<ul class="links">
							<li class="first"><a href="#" title="My Account">My
									Account</a></li>
							<li><a href="#" title="My Wishlist">My Wishlist</a></li>
							<li><a href="#" title="My Cart" class="top-link-cart">My
									Cart</a></li>
							<li><a href="#" title="Checkout" class="top-link-checkout">Checkout</a></li>
							<li class=" last"><a href="#" title="Log In">Log In</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="header_bottom">
				<div class="menu">
					<ul>
						<li><a href="index.html">主页</a></li>
						<li><a href="about.html">关于</a></li>
						<li class="active"><a href="specials.html">车位展示</a></li>
						<li><a href="contact.html">Contact</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="search_box">
					<form>
						<input type="text" value="搜索" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Search';}"><input
							type="submit" value="">
					</form>
				</div>
				<div class="clear"></div>
			</div>
			<div class="mian">
				<div class="content-top">
					<div class="sellers">
						<h4>
							<span><span>Top</span> sellers</span>
						</h4>
					</div>
					<!-- ***************************************** 公司查看合约车位************************************************ -->
					<!-- ***************************************** 车位展示部分 *****************************************************-->
					<div class=parkingmain>
						<c:forEach items="${all}" var="parking" >
							<!--隐藏车位id  -->
							<%-- <input id="${parking.id}" class="hidden" type="text" value="${parking.id}"> --%>
						
							<div class="parking">
								<div class="imge">
									<img src="${parking.img}" alt="" />
								</div>
								<div class="prod-inner">地址：${parking.address}</div>
								<div class="prod-inner">
									<span class="price">${parking.price}元/小时</span> <a
										onclick="getId();" href="/CBDSystem/showOne.do?id=${parking.id}" class="button" rel="nofollow">查看该车位</a>
									<div class="clear"></div>
								</div>
							</div>
							<div></div>
						</c:forEach>
					</div>
					<!-- ***************************************** 分页部分 *****************************************************-->
					<div class="page">
						<div id="" class="content-bottom-paging"><a href="/CBDSystem/showall.do?page=${paging.lastPage}">末页</a></div>
						<div id="" class="content-bottom-paging"><a href="/CBDSystem/showall.do?page=${paging.nextPage}">下一页</a></div>
						<div id="page" class="content-bottom-paging"><span id=currentPage>${paging.pageNum}</span>/<span id="tolPage">${paging.pages}</span></div>
						<div id="" class="content-bottom-paging"><a href="/CBDSystem/showall.do?page=${paging.prePage}">上一页</a></div>
						<div id="" class="content-bottom-paging"><a href="/CBDSystem/showall.do?page=1">首页</a></div>
					</div>

				</div>

				<!-- *******************************底部导航************************************************************************ -->
				<div class="clear"></div>
				<!-- </div> -->
			</div>
			<div class="footer">
				<div class="footer-top">
					<div class="col_1_of_4 span_1_of_4">
						<h3>INFORMATION</h3>
						<ul>
							<li><a href="#">About us</a></li>
							<li><a href="#">Sitemap</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Terms and conditions</a></li>
							<li><a href="#">Legal Notice</a></li>
						</ul>
					</div>
					<div class="col_1_of_4 span_1_of_4">
						<h3>CATEGORIES</h3>
						<ul>
							<li><a href="#">New products</a></li>
							<li><a href="#">top sellers</a></li>
							<li><a href="#">Specials</a></li>
							<li><a href="#">Products</a></li>
							<li><a href="#">Comments</a></li>
						</ul>
					</div>
					<div class="col_1_of_4 span_1_of_4">
						<h3>My ACCOUNT</h3>
						<ul>
							<li><a href="#">Your Account</a></li>
							<li><a href="#">Personal info</a></li>
							<li><a href="#">Prices</a></li>
							<li><a href="#">Address</a></li>
							<li><a href="#">Locations</a></li>
						</ul>
					</div>
					<div class="col_1_of_4 span_1_of_4 footer-lastgrid">
						<h3>FOLLOW US</h3>
						<ul>
							<li><a href="#">FACEBOOK</a></li>
							<li><a href="#">TWITTER</a></li>
							<li><a href="#">RSS</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="copy">
					<p>
						Copyright &copy; 2016.Company name All rights reserved.<a
							target="_blank" href="http://h2design.taobao.com/">氢设计</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- 引入外部js文件 -->
<script type="text/javascript" src="063/js/ShowParkingSpace.js"></script>
</html>




