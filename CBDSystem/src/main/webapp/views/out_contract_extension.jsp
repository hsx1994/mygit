<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主要内容区main</title>
    <link href="../css/css.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="../images/main/favicon.ico" />
    <script type="text/javascript" src="../js/bargain.js"></script>
    <script type="text/javascript" src="/CBDSystem/js/jQuery-2.2.2.js"></script>
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
        #search span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        td.fenye{ padding:10px 0 0 0; text-align:right;}
        .bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
        .main-for{ padding:10px;}
        .main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
        .main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
        #addinfo a{ font-size:14px; font-weight:bold; background: no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background: no-repeat 0 1px;}
    </style>
</head>
<body onload="outContractExtension(${param.id})">
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：合约管理&nbsp;&nbsp;>&nbsp;&nbsp;外部合同续约</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="" target="mainFrame" onFocus="this.blur()" class="add"></a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">原 合&nbsp;同&nbsp;编&nbsp;号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <span id="oldNumber"></span>
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">新 合&nbsp;同&nbsp;编&nbsp;号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="" value="" class="text-word" id="">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合&nbsp; 同&nbsp; 单&nbsp; 位：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" id="company" value="" class="text-word" id="company">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">单位详细地址：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" id="address" value="" class="text-word" id="address">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">对 方 联 系 人：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" id="contact" value="" class="text-word" id="contact">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">联&nbsp; 系&nbsp; 电&nbsp; 话：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" value="" class="text-word" id="tel">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合同生效日期：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="" value="" class="text-word" id="startTime">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合同截至日期：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="" value="" class="text-word" id="endTime">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">新合同复印件：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="file" name="" value="" class="text-word" id="">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">车&nbsp; 位&nbsp; 编&nbsp; 号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="" value="" class="text-word" id="carNum">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input name="" type="button" value="提交" class="text-but">
                            <input name="" type="button" value="返回" class="text-but" onclick="javascript:history.go(-1);"></td>
                    </tr>
                </table>
        </td>
    </tr>
</table>

</body>
</html>
