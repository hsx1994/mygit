<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../js/pageinfo.js"></script>
<script type="text/javascript" src="../js/bargain.js"></script>
<div id="aaa">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>主要内容区main</title>
    <link href="../css/css.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link rel="shortcut icon" href="../images/main/favicon.ico" />
    <script type="text/javascript" src="/CBDSystem/js/jQuery-2.2.2.js"></script>
    <style>
        body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
        #searchmain{ font-size:12px;}
        #search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
        #search span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
        #search input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        #search a.add{ background:url(../images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
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
        .bggray{ background:#f9f9f9}
        .history-but{
            height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 30px; display:inline;
        }
    </style>
</head>
<body onload="showContract(1)">
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：合约管理&nbsp; > &nbsp;外部合约</td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                          <span>搜索：</span>
                          <input type="text" id="condition" class="text-word" value="${condition }">
                          <input type="button" value="查询" class="text-but" onclick="queryOutBargain(1)">
                        <a name="" type="button"  class="history-but" href="out_history_contract.jsp" ><span style="margin-left: -6px; margin-top: -7px;">历史合约</span></a>
                    </td>
                    <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="add_out_contract.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增合约</a></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">

            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">合同编号</th>
                    <th align="center" valign="middle" class="borderright">合同单位</th>
                    <th align="center" valign="middle" class="borderright">联系人</th>
                    <th align="center" valign="middle" class="borderright">联系电话</th>
                    <th align="center" valign="middle" class="borderright">起始日期</th>
                    <th align="center" valign="middle" class="borderright">截止日期</th>
                    <th align="center" valign="middle">操作</th>
                </tr>
                <c:forEach begin="0" step="1" items="${list}" var="obj">
                <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom">${obj.number }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${obj.company }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${obj.contact }</td>
                    <td align="center" valign="middle" class="borderright borderbottom">${obj.tel }</td>
                    <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${obj.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                    <td align="center" valign="middle" class="borderright borderbottom"><fmt:formatDate value="${obj.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td align="center" valign="middle" class="borderbottom"><a href="out_contract_extension.jsp" target="mainFrame" onFocus="this.blur()" class="add">续约</a><span class="gray">&nbsp;|&nbsp;</span><a href="out_contract_detail.jsp?id=${obj.id }" target="mainFrame" onFocus="this.blur()" class="add">详情</a></td>
                </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top" class="fenye"> &nbsp;&nbsp;
        	<input type="hidden" value="${pageinfo.firstPage}" id="first"/>
        	<input type="hidden" value="${pageinfo.lastPage}" id="last"/>
        	<input type="hidden" value="${pageinfo.prePage}" id="pre"/>
        	<input type="hidden" value="${pageinfo.nextPage}" id="next"/>
       		<a href="#" onclick="showContract(${pageinfo.firstPage})"  target="mainFrame" onFocus="this.blur()" id="firstPage">首页</a>&nbsp;&nbsp;
	        <c:if test="${pageinfo.hasPreviousPage}">
	        <a href="#"onclick="showContract(${pageinfo.prePage})" target="mainFrame" onFocus="this.blur()" id="prePage">上一页</a>&nbsp;&nbsp;
	        </c:if>
	        ${pageinfo.pageNum}/${pageinfo.pages} 页&nbsp;&nbsp;
	        <c:if test="${pageinfo.hasNextPage}">
	        <a href="#"onclick="showContract(${pageinfo.nextPage})" target="mainFrame" onFocus="this.blur()" id="nextPage">下一页</a>&nbsp;&nbsp;
	        </c:if>
	        <a href="#" onclick="showContract(${pageinfo.lastPage})" target="mainFrame" onFocus="this.blur()" id="lastPage">尾页</a>
		</td>
    </tr>
</table>

</body>
</html>
</div>