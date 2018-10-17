<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主要内容区main</title>
    <link href="../css/css.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="../images/main/favicon.ico" />
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
        #search  span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left; font-size: 14px}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        td.fenye{ padding:10px 0 0 0; text-align:right;}
    </style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;> 车位审批</td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                        <span>待审车位▼</span>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">申请时间</th>
                    <th align="center" valign="middle" class="borderright">申请用户</th>
                    <th align="center" valign="middle" class="borderright">车位地址</th>
                    <th align="center" valign="middle">操作</th>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">admin</td>
                    <td align="center" valign="middle" class="borderright borderbottom">创始人</td>
                    <td align="center" valign="middle" class="borderright borderbottom">2013-04-26 11:00:59</td>
                    <td align="center" valign="middle" class="borderbottom"><a href="landlord_carpart_check.jsp" target="mainFrame" onFocus="this.blur()" class="add">受理</a></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="fenye"> 
       	    <a href="list?page=${pageinfo.firstPage}" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
	        <a href="list?page=${pageinfo.prePage}" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
	        ${pageinfo.pageNum}/${pageinfo.pages} 页&nbsp;&nbsp;
	        <a href="list?page=${pageinfo.nextPage}" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
	        <a href="list?page=${pageinfo.lastPage}" target="mainFrame" onFocus="this.blur()">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
