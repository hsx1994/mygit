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
        #search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
        #main-tab th{ font-size:12px; background:url(../images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
        #main-tab td{ font-size:12px; line-height:40px;}
        #main-tab td a{ font-size:12px; color:#548fc9;}
        #main-tab td a:hover{color:#565656; text-decoration:underline;}
        .bordertop{ border-top:1px solid #ebebeb}
        .borderright{ border-right:1px solid #ebebeb}
        .borderbottom{ border-bottom:1px solid #ebebeb}
        td.fenye{ padding:10px 0 0 0; text-align:right;}
        #addinfo a{ font-size:14px; font-weight:bold; background:url(../images/main/replayblack.jpg) no-repeat 0 0px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background:url(../images/main/replayblue.jpg) no-repeat 0 0px;}
    </style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：合约管理&nbsp; > &nbsp;外部合约 > 历史合约</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="#" target="mainFrame" onFocus="this.blur()" class="add" onclick="javascript:history.go(-1);">返回上一级</a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                        <form method="post" action="">
                            <span>搜索：</span>
                            <input type="text" name="" value="" class="text-word">
                            <input name="" type="button" value="查询" class="text-but" >
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">合同编号</th>
                    <th align="center" valign="middle" class="borderright">合同企业</th>
                    <th align="center" valign="middle" class="borderright">联系人</th>
                    <th align="center" valign="middle" class="borderright">联系电话</th>
                    <th align="center" valign="middle" class="borderright">起始日期</th>
                    <th align="center" valign="middle" class="borderright">截止日期</th>
                    <th align="center" valign="middle">操作</th>
                </tr>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">1</td>
                    <td align="center" valign="middle" class="borderright borderbottom">admin</td>
                    <td align="center" valign="middle" class="borderright borderbottom">创始人</td>
                    <td align="center" valign="middle" class="borderright borderbottom">已锁定</td>
                    <td align="center" valign="middle" class="borderright borderbottom">2013-04-26 </td>
                    <td align="center" valign="middle" class="borderright borderbottom">2013-04-26 </td>
                    <td align="center" valign="middle" class="borderbottom"><a href="tenant_contract_detail.jsp" target="mainFrame" onFocus="this.blur()" class="add">详情</a></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="fenye"> &nbsp;&nbsp;
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