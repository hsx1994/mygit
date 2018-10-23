<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="show">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主要内容区main</title>
    <link href="../css/css.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="../images/main/favicon.ico" />
    <script type="text/javascript" src="../js/jQuery-2.2.2.js"></script>
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
        #search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        .bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
        .main-for{ padding:10px;}
        .main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:right; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
        .main-for textarea{ width:100%; height:150px; line-height:24px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:10px; color:#666}
        #addinfo a{ font-size:14px; font-weight:bold; background:url(../images/main/replayblack.jpg) no-repeat 0 0px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background:url(../images/main/replayblue.jpg) no-repeat 0 0px;}
        .title{
            color: white;font-size: 15px; margin-left: 20px;
        }
    </style>
</head>
<body onload="showDetailsParking(${param.id })">
<input type="hidden" value="${param.id }" id="id">
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;车位审核</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="#" target="mainFrame" onFocus="this.blur()" class="add" onclick="javascript:history.go(-1);">返回上一级</a>
        </td>
    </tr>
    <tr>
        <td width="90%" align="left" valign="middle" style="background-color: #548fc9; height: 40px;" >
            <span  class="title">包租婆信息审核▼</span>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <form method="post" action="">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">包租婆用户名：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.user.login.name }</td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">真实姓名：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.user.realName }</td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">身份证号码：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.user.idcard }</td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">家庭地址：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.user.address }</td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
<table width="99%">
    <tr>
        <td width="90%" align="left" valign="middle" style="background-color: #548fc9; height: 40px;" >
            <!--<input name="" type="button" value="事件记录▼" class="text-but" style="width: auto">-->
            <span  class="title">车位信息审核▼</span>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="main-tab">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">车位编号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.parkingNum }</td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">产权证编号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.certificate }</td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">车位详细地址：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">${park.address }</td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">产权证复印件：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for"></td>
                    </tr>
                </table>
            <div style="width:89%;height: 500px;border: solid 1px #b0b0b0;margin-left: 130px">
				<img src="${park.certImg }">
            </div>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="left" valign="middle" class="borderright borderbottom main-for">
                        <input onclick="applyPassFail()" type="button" value="驳回" class="text-but">
                        <input onclick="applyPass()" type="button" value="通过" class="text-but">
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>
<script type="text/javascript" src="../js/parking.js"></script>
</body>
</html>
</div>