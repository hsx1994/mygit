<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台页面头部</title>
<link href="../css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jQuery-2.2.2.js"></script>
</head>
<body onselectstart="return false" oncontextmenu=return(false) style="overflow-x:hidden;">
<!--禁止网页另存为-->
<noscript><iframe scr="*.htm"></iframe></noscript>
<!--禁止网页另存为-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="header">
  <tr>
    <td rowspan="2" align="left" valign="top" id="logo"><img src="../images/main/logo.jpg" width="74" height="64"></td>
    <td align="left" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="bottom" id="header-name">CBD停车管理系统</td>
        <td align="right" valign="top" id="header-right">
        	<a href=""   class="admin-out" onclick="exidLogout();">注销</a>
        	<script>
        		function exidLogout(){
        			$.ajax({
        				url:"/CBDSystem/logoutExitAdmin.do",
        				type:"post",
        				data:{
        				
        				},
        			dataType:"json",
        			success:function(data){
        				alert(data);
        				window.parent.location.href="/CBDSystem/views/login.jsp"
        			}
        			
        			
        			})
        		
        		}
        	
        	
        	</script>
        	
            <a href="/CBDSystem/views/manage.jsp" target="top"  class="admin-home">管理首页</a>     	
            <span>
<!-- 日历 -->
<SCRIPT type=text/javascript src="../js/clock.js"></SCRIPT>
<SCRIPT type=text/javascript>showcal();</SCRIPT>
            </span>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="left" valign="bottom">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top" id="header-admin">后台管理系统</td>
       <!-- <td align="left" valign="bottom" id="header-menu">
        <a href="index.jsp" target="left" onFocus="this.blur()" id="menuon">后台首页</a>
        <a href="index.jsp" target="left" onFocus="this.blur()">用户管理</a>
        <a href="index.jsp" target="left" onFocus="this.blur()">栏目管理</a>
        <a href="index.jsp" target="left" onFocus="this.blur()">信息管理</a>
        <a href="index.jsp" target="left" onFocus="this.blur()">留言管理</a>
        <a href="index.jsp" target="left" onFocus="this.blur()">附件管理</a>
        <a href="index.jsp" target="left" onFocus="this.blur()">站点管理</a>
        </td>-->
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
