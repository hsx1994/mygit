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
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
        #search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        .bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
        .main-for{ padding:10px;}
        .main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
        .main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
        #addinfo a{ font-size:14px; font-weight:bold; background:url(../images/main/replayblack.jpg) no-repeat 0 0px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background:url(../images/main/replayblue.jpg) no-repeat 0 0px;}
    </style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：合约管理&nbsp;&nbsp;>&nbsp;&nbsp;外部合约详情</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="#" target="mainFrame" onFocus="this.blur()" class="add" onclick="javascript:history.go(-1);">返回上一级</a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">合&nbsp; 同&nbsp; 编&nbsp; 号：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">123456</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">合&nbsp; 同&nbsp; 单&nbsp; 位：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">admin@sina.com</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">单&nbsp; 位&nbsp; 地&nbsp; 址：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for" style="line-height:24px;">测试</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">对 方 联 系 人：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">666</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">联 系 人 电 话：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for">测试内容</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">合同生效日期：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for" style="line-height:24px;">测试</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">合同截止日期：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for" style="line-height:24px;">测试</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">车&nbsp; 位&nbsp; 编&nbsp; 号：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for" style="line-height:24px;">测试</td>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="right" valign="middle" class="borderright borderbottom bggray">合 同 复 印 件：</td>
                    <td align="left" valign="middle" class="borderright borderbottom main-for" style="line-height:24px;">测试</td>
                </tr>
            </table>
            <div style="width:89%;height: 500px;border: solid 1px #b0b0b0;margin-left: 130px">

            </div>
        </td>
    </tr>
</table>
</body>
</html>
