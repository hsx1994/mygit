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
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
        .search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        .search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        .search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        .search a.add{ background:url(../images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
        .search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        .main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        .main-tab td{ font-size:12px; line-height:40px;}
        .main-tab td a{ font-size:12px; color:#548fc9;}
        .main-tab td a:hover{color:#565656; text-decoration:underline;}
        .bordertop{ border-top:1px solid #ebebeb}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        .borderleft{ border-left:1px solid #ebebeb}
        .gray{ color:#dbdbdb;}
        td.fenye{ padding:10px 0 0 0; text-align:right;}
        .bggray{ background:#f9f9f9}
        .title{
            color: white;font-size: 15px; margin-left: 20px;
        }
        #addinfo a{ font-size:14px; font-weight:bold; background:url(../images/main/replayblack.jpg) no-repeat 0 0px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background:url(../images/main/replayblue.jpg) no-repeat 0 0px;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:right; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
    </style>
</head>
<body onload="showDetailsComplain(${param.id })">
<!--main_top-->
<input type="hidden" value="${param.id }" id="id">
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：投诉管理&nbsp; > &nbsp;投诉详情</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="#" target="mainFrame" onFocus="this.blur()" class="add" onclick="javascript:history.go(-1);">返回上一级</a>
        </td>
    </tr>
    <tr >
        <td align="left" valign="top" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="search">
                <tr>
                    <td width="90%" align="left" valign="middle" style="background-color: #548fc9; height: 40px;" >
                        <span  class="title">事件记录▼</span>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">车位编号</th>
                    <th align="center" valign="middle" class="borderright">车位小区地址</th>
                    <th align="center" valign="middle" class="borderright">租赁开始时间</th>
                    <th align="center" valign="middle" class="borderright">租赁结束时间</th>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.order.parking.parkingNum }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.order.parking.address }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.order.startTime }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.order.endTime }</td>
                </tr>
            </table></td>
    </tr>

    <!--投诉方信息-->
    <tr style="height: 30px"></tr>
    <tr >
        <td align="left" valign="top" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="search">
                <tr>
                    <td width="90%" align="left" valign="middle" style="background-color: #548fc9; height: 40px;" >
                        <!--<input name="" type="button" value="事件记录▼" class="text-but" style="width: auto">-->
                        <span  class="title">投 诉 方▼</span>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">用 户 名</th>
                    <th align="center" valign="middle" class="borderright">真实姓名</th>
                    <th align="center" valign="middle" class="borderright">身份证号码</th>
                    <th align="center" valign="middle" class="borderright">职业</th>
                    <th align="center" valign="middle" class="borderright">联系电话</th>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.user.realName }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.user.realName }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.user.idcard }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.user.job }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.user.tel }</td>
                </tr>
                <!--<tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">投诉理由</td>
                    <td align="center" valign="middle" class="borderright borderbottom"></td>
                </tr>-->
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">投诉理由</th>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.content }</td>
                </tr>
            </table>
        </td>
    </tr>
    <!--被投诉方信息-->
    <tr style="height: 30px"></tr>
    <tr >
        <td align="left" valign="top" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="search">
                <tr>
                    <td width="90%" align="left" valign="middle" style="background-color: #548fc9; height: 40px;" >
                        <!--<input name="" type="button" value="事件记录▼" class="text-but" style="width: auto">-->
                        <span  class="title">被投诉方▼</span>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">用 户 名</th>
                    <th align="center" valign="middle" class="borderright">真实姓名</th>
                    <th align="center" valign="middle" class="borderright">身份证号码</th>
                    <th align="center" valign="middle" class="borderright">职业</th>
                    <th align="center" valign="middle" class="borderright">联系电话</th>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.buser.realName }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.buser.realName }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.buser.idcard }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.buser.job }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${complain.buser.tel }</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr style="height: 20px"></tr>
    <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="" type="button" value="投诉驳回" class="text-but" onclick="acceptComplain(2,${param.id })">
        <input name="" type="button" value="投诉通过" class="text-but" onclick="acceptComplain(1,${param.id })">
    </td>
    
</table>
<script type="text/javascript" src="../js/complain.js"></script>

</body>
</html>
</div>
