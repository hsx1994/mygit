<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理登录界面</title>
    <link href="/CBDSystem/css/alogin.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server" action="/CBDSystem/adminLogin.do" method="post">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span><img src="/CBDSystem/images/login/logo.png" alt="" style="" /></span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">                	
                    <li><span class="left login-text">用户名：</span>
                        <input id="Text1" type="text" class="txt" name="name" value="${user.name }"/>               
                    </li>
                    <li><span class="left login-text">密&nbsp;&nbsp; 码：</span>
                       <input id="Text2" type="password" class="txt" name="password" value="${user.password }"/>  
                    </li>
                    <li><span class="left login-text">验证码：</span>
                       <input id="Text3" type="text" class="txt" name="checkcode" style="width: 90px" value="${checkcode }"/>                  	                	
                    </li>   
                                                     
                </ul>
                
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>            
            <li class="middle_C"><span class="btn"><input name="" type="image" src="/CBDSystem/images/login/btnlogin.gif" /><label><font color="red">${errorMsg }</font></label></span></li>        	
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">网站后台管理系统&nbsp;&nbsp;www.php.com</li>
        </ul>
    </div>
    </form>
</body>
</html>