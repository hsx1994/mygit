<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申请上架车位</title>
<link type="text/css" href="../css/csss.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.9.11.min.js"></script>
<script type="text/javascript" src="../js/js.js"></script>
<script type="text/javascript" src="/CBDSystem/js/logOut.js"></script>
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
  <a href="index.html"><img src="../images/logo.png" width="304" height="74" /></a>
  </h1>
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="/CBDSystem/index.jsp">首页</a></li>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="../images/vipImg.jpg" width="183" height="169" /></h2>
   <h3 class="vipName">包租婆</h3>
   <dl class="vipNav">
    <dt class="vip_1 vipCur">账户中心</dt>
     <dd><a href="LookMyCar.jsp">我的车位</a></dd>
     <dd><a href="LookOneUser.jsp">申请上架车位</a></dd>
     <dd><a href="LookCar.jsp">已上架车位</a></dd>
    <dt class="vip_2">个人</dt>
     <dd class="ddCur"><a href="one.jsp">个人信息</a></dd>
     <dd><a href="RentUser.jsp">修改个人信息</a></dd>
     <dd><a href="updatepasswd1.jsp">修改密码</a></dd>
     <dd><a href="LookOneOrder.jsp">查看租赁记录</a></dd>
    </dl>
    </div>
    <div class="vipRight">
   <h2 class="vipTitle">申请上架</h2>
  	<div>
  	  <form action="/CBDSystem/application.do" method="post"
						enctype="multipart/form-data">
						<table class="grzx" width="705" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td width="90"><span>*</span>车位地址:&nbsp;<input
									style="width: 180px;" type="text" name="address" maxlength="50" required/><br />
								</td>
							</tr>
							<tr>
								<td width="90"><span>*</span>车位号 :&nbsp;<input
									style="width: 180px;" type="text" name="parkingNum"
									maxlength="50"  required /><br /></td>
							</tr>
							<tr>
								<td width="90"><span>*</span>车位图片 :&nbsp;<input
									style="width: 180px;" type="file" name="imgFile"
									onchange="verificationPicFile(this)" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg"  required/><br /></td>
							</tr>
							<tr>
								<td width="90"><span>*</span>开始时间 :&nbsp;<input
									style="width: 180px;" type="date" id="startTime" name="startTime" onchange="timeCheck()" required /><br /></td>
							</tr>
							<tr>
								<td width="90"><span>*</span> 结束时间 :&nbsp;<input
									style="width: 180px;" type="date" id="endTime" name="endTime" onchange="timeCheck()" required/><br /></td>
							</tr>
							<tr>
								<td width="90"><span>*</span>车位价格 :&nbsp;<input
									style="width: 180px;" type="text" name="price"
									onchange="checkMobile(this);" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg"  required /><br /></td>
							</tr>
							<tr>
								<td width="90"><span>*</span>产权证编号:&nbsp;<input
									style="width: 180px;" type="text" name="certificate"
									maxlength="50"  required/><br /></td>
							</tr>
							<tr>
								<td width="90"><span>*</span>产权证复印件:&nbsp;<input
									style="width: 180px;" type="file" name="ImgFile"
									onchange="verificationPicFile(this)"  required/><br /></td>
							</tr>
							<tr>
								<td width="90"><button type="submit">申请上架</button></td>
							</tr>
						</table>
					</form>

  	</div>
  	
  	
  
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
  <span>&copy; 2014 Unqezi 使用前必读 更多模板：<a target="_blank">源码之家</a></span>
 </div><!--footer/-->
 <script>
		//车位价格的输入约束
			function checkMobile(obj) {
				var str = obj.value;
				if (str == "") {
					alert("不能为空！");
				} else {
					var re = /^\+?[1-9][0-9]*$/ // 以1开始后面加10位数字
					if (re.test(str)) {
					} else {
						alert("只能输入数字");
					}
				}
			}
			//验证时间
			function timeCheck(){
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				if(startTime != "" && endTime != ""){
					if(Date.parse(startTime)>Date.parse(endTime)){
			            alert("开始时间不能在结束时间之后");
			        }
				}
			}
			//图片大小验证
			function verificationPicFile(file) {
				var fileSize = 0;
				var fileMaxSize = 1024; //1M
				var filePath = file.value;
				if (filePath) {
					fileSize = file.files[0].size;
					var size = fileSize / 1024;
					if (size > fileMaxSize) {
						alert("文件大小不能大于1M！");
						file.value = "";
						return false;
					} else if (size <= 0) {
						alert("文件大小不能为0M！");
						file.value = "";
						return false;
					}
				} else {
					return false;
				}
			}
		</script>
 
</body>

</html>
