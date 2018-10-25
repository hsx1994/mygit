<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主要内容区main</title>
    <link href="../css/css.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="../images/main/favicon.ico" />
     <script type="text/javascript" src="/CBDSystem/js/jQuery-2.2.2.js"></script>
     <script type="text/javascript" src="/CBDSystem/js/userManage.js"></script>
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
        #search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #search a.add{ background:url(../images/main/add.jpg) no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
        #search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .bordertop{ border-top:1px solid #ebebeb}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        .borderleft{ border-left:1px solid #ebebeb}
        .gray{ color:#dbdbdb;}
        td.fenye{ padding:10px 0 0 0; text-align:right;}
        .bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
        .main-for{ padding:10px;}
        .main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
        .main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
        #addinfo a{ font-size:14px; font-weight:bold; background: no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background: no-repeat 0 1px;}
        input::-webkit-input-placeholder {
         /* placeholder颜色  */
         color: #aab2bd;
         /* placeholder字体大小  */
         font-size: 12px;
         /* placeholder位置  */
	       text-align: left;
     }
    </style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;添加企业</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="" target="mainFrame" onFocus="this.blur()" class="add"></a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
           <!--  <form method="post" action="/CBDSystem/addCompany.do"> -->
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">企业登录名：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="name" id="name" value="" class="text-word" placeholder="6~18位包含数字、大小写字母和汉字的任意组合(必填)" onblur="javaScript:check(this.value)">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">登 录 密 码：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="password" name="password" id="pwd"  class="text-word" placeholder="6~15位数字（必填）" onblur="isPass(this.value)">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">确 认 密 码：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="password" name="repwd" id="repwd"  class="text-word" placeholder="再次输入密码" onblur="isRePass()">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">企 业 名 称：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <input type="text" name="comName"  class="text-word" id="comName" placeholder="必填" onblur="">
                    </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">企 业 地 址：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="address" id="address" class="text-word" placeholder="必填" onblur="">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">企业联系人：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="contact" id="contact" class="text-word" placeholder="必填" onblur="">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">联系人电话：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="tel" id="tel" class="text-word" placeholder="必填" onblur="isPhone(this.value);">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">联系人邮箱：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="email" id="email" class="text-word" placeholder="必填" onblur="isEmail(this.value);">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input name="" type="button" value="提交" class="text-but" onclick="addCompany()">
                            <input name="" type="button" value="返回" class="text-but" onclick="javascript:history.go(-1);"></td>
                    </tr>
                </table>
           <!--  </form> -->
        </td>
    </tr>
</table>
<script type="text/javascript">

	function check(val){
	var flag = val.search(/[\u4e00-\u9fa5_a-zA-Z0-9_]{8,15}/);
	if($("#name").val()==""){
		alert("企业登录名不能为空");
	}else if(flag==-1){
		alert("企业登录名不合格")
	}else if($("#comName").val()==""){
		alert("企业名不能为空");
	}else if($("#contact").val()==""){
		alert("联系人不能为空")
	}else if($("#address").val()==""){
		alert("地址不能为空")
	} 
	
}
function isPass(val){
	var flag = val.search(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/);
	if($("#pwd").val().length<6){
		alert("请输入6~15位密码");
	}else if(flag==-1){
		alert("密码格式不正确");
	}
}
function isRePass(){
	if($("#pwd").val()!=$("#repwd").val()){
			alert("两次密码不一致")
		}
}
//验证邮箱是否合法
function isEmail(strEmail) {
    var flag = strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
    if (flag == -1){
        alert("邮箱格式不正确");
    }
}
//验证手机号是否合法
function isPhone(phone){
    //alert(phone)
    var RegCellPhone = /^(1)([0-9]{10})?$/;
    var  falg=phone.search(RegCellPhone);
    if (falg==-1){
        alert("手机号不正确");
        this.focus();
    }
}
</script>
</body>
</html>
