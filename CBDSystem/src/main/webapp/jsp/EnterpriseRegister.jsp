<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>注册</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/gloab.css" rel="stylesheet">
<link href="../css/index.css" rel="stylesheet">
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/register.js"></script>
<script src="../js/public/jquery.1.9.1.js"></script>
<script type="text/javascript" src="/CBDSystem/js/logOut.js"></script>
</head>
<body class="bgf4">

	<div class="login-box f-mt10 f-pb50">
		<div class="main bgf">
			<div class="reg-box-pan display-inline">
				<div class="step">
					<ul>
						<li class="col-xs-4 on"><span class="num"><em
								class="f-r5"></em><i>1</i></span> <span class="line_bg lbg-r"></span>
							<p class="lbg-txt">填写用户信息</p></li>
						<li class="col-xs-4"><span class="num"><em
								class="f-r5"></em><i>2</i></span> <span class="line_bg lbg-l"></span> <span
							class="line_bg lbg-r"></span>
							<p class="lbg-txt">验证用户信息</p></li>
						<li class="col-xs-4"><span class="num"><em
								class="f-r5"></em><i>3</i></span> <span class="line_bg lbg-l"></span>
							<p class="lbg-txt">注册成功</p></li>
					</ul>
				</div>
				<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
					<div class="part1">
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>
							<div class="f-fl item-ifo">
								<input type="text" maxlength="20" class="txt03 f-r3 required"
									tabindex="1" data-valid="isNonEmpty||between:3-20||isUname"
									data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头"
									id="name" name="name" /> <span
									class="ie8 icon-close close hide"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
								<label class="focus valid"></label>
							</div>
						</div>

						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>
							<div class="f-fl item-ifo">
								<input type="password" id="password" name="password"
									maxlength="20" class="txt03 f-r3 required" tabindex="3"
									style="ime-mode:disabled;" onpaste="return  false"
									autocomplete="off"
									data-valid="isNonEmpty||between:6-20||level:2"
									data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" /> <span
									class="ie8 icon-close close hide" style="right:55px"></span> <span
									class="showpwd" data-eye="password"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus">6-20位英文（区分大小写）、数字、字符的组合</label> <label
									class="focus valid"></label> <span class="clearfix"></span> <label
									class="strength"> <span class="f-fl f-size12">安全程度：</span>
									<b><i>弱</i><i>中</i><i>强</i></b>
								</label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>
							<div class="f-fl item-ifo">
								<input type="password" maxlength="20"
									class="txt03 f-r3 required" tabindex="4"
									style="ime-mode:disabled;" onpaste="return  false"
									autocomplete="off"
									data-valid="isNonEmpty||between:6-16||isRepeat:password"
									data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword"  /> <span
									class="ie8 icon-close close hide" style="right:55px"></span> <span
									class="showpwd" data-eye="rePassword"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus">请再输入一遍上面的密码</label> <label class="focus valid"></label>
							</div>
						</div>

						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">下一步</a>
							</div>
						</div>
					</div>

					<div class="part2" style="display:none">
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>联系人姓名：</span>
							<div class="f-fl item-ifo">
								<input type="text" maxlength="10" class="txt03 f-r3 required"
									tabindex="1" data-valid="isNonEmpty||between:2-10||isZh"
									data-error="姓名不能为空||真实姓名长度2-10位||只能输入中文" id="contact"
									name="contact" /> <span class="ie8 icon-close close hide"></span>
								<label class="icon-sucessfill blank hide"></label> <label
									class="focus">2-10位，中文真实姓名</label> <label class="focus valid"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>企业名：</span>
							<div class="f-fl item-ifo">
								<input type="text" class="txt03 f-r3 required" tabindex="2"
									data-valid="isNonEmpty||isCard"
									data-error="企业名不能为空"  id="comName"
									name="comName" /> <span class="ie8 icon-close close hide"></span>
								<label class="icon-sucessfill blank hide"></label> <label
									class="focus">请填写真实企业名</label> <label class="focus valid"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>居住地址（楼层号）：</span>
							<div class="f-fl item-ifo">
								<input type="text" class="txt03 f-r3 required" tabindex="2"
									data-valid="isNonEmpty" data-error="地址格式不能为空" id="address"
									name="address" /> <span class="ie8 icon-close close hide"></span>
								<label class="icon-sucessfill blank hide"></label> <label
									class="focus">例如：XXX小区10(栋)-1(单元)-10(楼层)-1(号)</label> <label
									class="focus valid"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>职业：</span>
							<div class="f-fl item-ifo">
								<input type="text" class="txt03 f-r3 required" tabindex="2"
									data-valid="isNonEmpty" data-error="职业不能为空" id="job"
									name="job" /> <span class="ie8 icon-close close hide"></span>
								<label class="icon-sucessfill blank hide"></label> <label
									class="focus">请填写您的职业</label> <label class="focus valid"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>邮箱地址：</span>
							<div class="f-fl item-ifo">
								<input type="text" class="txt03 f-r3 required" tabindex="2"
									data-valid="isNonEmpty||isEmail" data-error="邮箱不能为空||邮箱格式不正确"
									id="email" name="email" /> <span
									class="ie8 icon-close close hide"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus">例如：4325234@qq.com</label> <label
									class="focus valid"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">下一步</a>
							</div>
						</div>
					</div>
					<div class="part3" style="display:none">
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>
							<div class="f-fl item-ifo">
								<input type="text" class="txt03 f-r3 required" keycodes="tel"
									tabindex="2" data-valid="isNonEmpty||isPhone"
									data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="tel"
									name="tel" /> <span class="ie8 icon-close close hide"></span>
								<label class="icon-sucessfill blank hide"></label> <label
									class="focus">请填写11位有效的手机号码</label> <label class="focus valid"></label>
							</div>
						</div>

						<div class="item col-xs-12">
							<span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>
							<div class="f-fl item-ifo">
								<input type="text" maxlength="6" id="verifyNo"
									class="txt03 f-r3 f-fl required" tabindex="4"
									style="width:167px" data-valid="isNonEmpty||isInt"
									data-error="验证码不能为空||请输入6位数字验证码" /> <span
									class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled
									style="width:97px;display:none;">发送验证码</span> <span
									class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz"
									style="width:97px;">发送验证码</span> <span
									class="ie8 icon-close close hide" style="right:130px"></span> <label
									class="icon-sucessfill blank hide"></label> <label
									class="focus" style="display:none"><span>请查收手机短信，并填写短信中的验证码（此验证码3分钟内有效）</span></label>
								<label class="focus valid"></label>
							</div>
						</div>
						<div class="item col-xs-12">
							<span class="intelligent-label f-fl">&nbsp;</span>
							<div class="f-fl item-ifo">
								<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part3"
									onclick="send()">注册</a>
							</div>
						</div>
					</div>
					<div class="part4 text-center" style="display:none">
						<h3>恭喜,您已注册成功</h3>
						<!--                     <p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a href="login.html" class="c-blue">登录</a></p>
 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="m-sPopBg" style="z-index:998;"></div>
	<div class="m-sPopCon regcon">
		<div class="m-sPopTitle">
			<strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose"
				onClick="closeClause()">×</b>
		</div>
		<div class="apply_up_content">
			<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
		</div>
		<center>
			<a
				class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3"
				href="javascript:closeClause();">已阅读并同意此条款</a>
		</center>
	</div>

	<script>
$(function(){	
	//第一页的确定按钮
	$("#btn_part1").click(function(){						
		if(!verifyCheck._click()) return;
		$(".part1").hide();
		$(".part2").show();
		$(".step li").eq(1).addClass("on");
	});
	//第二页的确定按钮
	$("#btn_part2").click(function(){			
		if(!verifyCheck._click()) return;
		$(".part2").hide();
		$(".part3").show();	
	});	
	//第三页的确定按钮
	$("#btn_part3").click(function(){			
		if(!verifyCheck._click()) return;
		$(".part3").hide();
		$(".part4").show();
		$(".step li").eq(2).addClass("on");
		countdown({
			maxTime:10,
			ing:function(c){
				$("#times").text(c);
			},
			after:function(){
				window.location.href="login.html";		
			}
		});		
	});	
});
function showcode(){$("#verifyYz").show();}

</script>

	<script type="text/javascript">
function send(){
	var name=$("#name").val();
	var password=$("#password").val();
	var realName=$("#realName").val();
	var idcard=$("#idcard").val();
	var address=$("#address").val();
	var job = $("#job").val();
	var email=$("#email").val();
	var tel=$("#tel").val();
	var user={"name":name,
	 			 "password":password,
	 			 "realName":realName,
	 			 "idcard":idcard,
				 "address":address,
				 "job" :job,
				 "email":email,
	 			"tel":tel
	 			}
	alert(name,password,realName,idcard,address,job,email,tel);
		$.ajax({
				url:"../personl.do",
				type:"post",
				contentType:"application/json;charset=utf-8",
				async:true,
				data:{name:$("#name").val()},
				/* JSON.stringify(user)
				, */
				datatype: "json",
				success:function(data){
					alert(data);
				}
			});
			/* var jsonobj = {"name":$("#name").val(),"pass":$("#password").val()};
			$.ajax({
				url:"../personl.do",
				type:"post",
				async:true,
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(jsonobj),
				success:function(message){
					console.info(message);
				}
			}); */
	}
</script>
	<div style="text-align:center;"></div>

</body>
</html>
