<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>包租婆修改信息</title>
<link type="text/css" href="../css/csss.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.11.min.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script type="text/javascript" src="/CBDSystem/js/logOut.js"></script>

</head>

<body>
 <div class="hrader" id="header">
  <div class="top">
   <a href="login.html" style="color:#C94E13;">请登录</a> 
   <a href="reg.html">注册</a>
   <ul class="topNav">
    <li><a href="order.html">我的订单 </a></li>
    <li class="gouwuche"><a href="car.html">购物车</a> <strong style="color:#C94E13;">3</strong></li>
    <li class="shoucangjia"><a href="shoucang.html">收藏夹</a></li>
    <li class="kefus"><a href="#">联系客服</a></li>
<li><a href="#" class="lan">中文</a></li>
    <li><a href="#" class="lan">English</a></li>
    <div class="clears"></div>
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
  <div class="ding-gou">
   <div class="ding">
    <a href="order.html"><img src="../images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="car.html"><img src="../images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="one.jsp">首页</a></li>
   <li><a href=""></a></li>
   <li><a href=""></a></li>
   <li class="navCur"><a href="one.jsp">用户中心</a></li>
   <li><a href="xuanshang.html"></a></li>
   <li><a href="luntan.html" class="luntan"></a></li>
   <li><a href="help.html"></a></li>
   <div class="clears"></div>
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
     <dd><a href="LookOnCar.jsp">已上架车位</a></dd>
    <dt class="vip_2">个人</dt>
     <dd class="ddCur"><a href="three.jsp">企业信息</a></dd>
     <dd><a href="RentCompany.jsp">修改企业信息</a></dd>
     <dd><a href=""></a></dd>
     <dd><a href="LookCar.jsp">查看租赁记录</a></dd>
    <dt class="vip_3"></dt>
     <dd><a href="vipQuxiao.html"></a></dd>
     
     <dd><a href="vipTousu.html"></a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">个人信息修改</h2>
   
  
       <table class="grzx" width="705" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="90"><span>*</span>密码：</td>
          <td width="430"><input type="text" name="password"></td>
          
        </tr>
       
        <tr>
          <td>&nbsp;邮箱:</td>
          <td><input type="text" name="email" /></td>
        </tr>
        
        <tr>
          <td>&nbsp;&nbsp;电话：</td>
          <td><input type="text" name="tel" ></td>
        </tr>
        <tr>
          <td>&nbsp;联系人姓名：</td>
          <td><input type="text" name="contact" ></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><button type="submit" onclick="sendss()"><a herf="three.jsp">完成</a></button></td>
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
  <span>&copy; 2014 Unqezi 使用前必读 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></span>
 </div><!--footer/-->
<script type="text/javascript">
    function sendss(){
		$.ajax({
			   	url:"../companyUpdate.do",
				type:"post",
				data:
				{
				 password:$("#password").val(),
	             contact:$("#contact").val(),
	             email:$("#email").val(),
	             tel:$("#tel").val(),
			},
				datatype: "json",
				success:function(data){
					alert(data);
				}
			});
			
	};
</script>
</body>
</html>
