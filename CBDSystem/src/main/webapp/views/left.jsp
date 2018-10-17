<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="../css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/sdmenu.js"></script>
<script type="text/javascript" src="../js/jQuery-2.2.2.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(../images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="../images/main/member.gif" width="44" height="44" /></div>
    <span>用户：admin<br>角色：管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>权限管理</span>
        <a href="all_admin_info.jsp" target="mainFrame" onFocus="this.blur()">查看管理员</a>
        <a href="add_admin.jsp" target="mainFrame" onFocus="this.blur()">新增管理员</a>
      </div>
      <div class="collapsed">
        <span>个人信息</span>
        <a href="userinfo.jsp" target="mainFrame" onFocus="this.blur()">详细信息</a>
      </div>
      <div class="collapsed">
        <span>用户管理</span>
        <a href="company_info.jsp" target="mainFrame" onFocus="this.blur()">企业管理</a>
        <a href="landlord_carpart_apply.jsp" target="mainFrame" onFocus="this.blur()">包租婆车位审批</a>
      </div>
      <div class="collapsed">
        <span>合约管理</span>
        <a href="out_contract_info.jsp" target="mainFrame" onFocus="this.blur()">外部合约管理</a>
        <a href="tenant_contract_info.jsp" target="mainFrame" onFocus="this.blur()">租户合约管理</a>
      </div>
      <div class="collapsed">
        <span>车位管理</span>
        <a href="cbd_carport.jsp" target="mainFrame" onFocus="this.blur()">CBD车位管理</a>
      </div>
      <div class="collapsed">
        <span>投诉管理</span>
        <a target="mainFrame" onclick="showComplain(1)" onFocus="this.blur()">投诉事件</a>
      </div>
    </div>
    <script type="text/javascript" src="/CBDSystem/js/complain.js"></script>
</body>
</html>
