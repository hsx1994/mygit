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
        #search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
        #search form input.text-but{height:24px; line-height:24px; width:55px; background:url(../images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
        a.add{ background:url(../images/main/addinfoblue.jpg) no-repeat 0px 0px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold;}
        a:hover.add{ text-decoration:underline; color:black;}
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
        .bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
        .main-for{ padding:10px;}
        .main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
        .main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
        .main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
        #addinfo a{ font-size:14px; font-weight:bold; background: no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
        #addinfo a:hover{ background: no-repeat 0 1px;}
    </style>
    <script type="text/javascript" src="../js/jQuery-2.2.2.js"></script>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">您的位置：合约管理&nbsp;&nbsp;>&nbsp;&nbsp;新增合约</td>
    </tr>
    <tr>
        <td align="left" valign="top" id="addinfo">
            <a href="" target="mainFrame" onFocus="this.blur()" class="add"></a>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <form method="post" action="/CBDSystem/companyBargainAdd.do">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合&nbsp; 同&nbsp; 编&nbsp; 号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="number" value="${bean.number }" class="text-word">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">企业用户名称：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="company.comName" value="${bean.company.comName }" class="text-word">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">对 方 联 系 人：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="contact" value="${bean.contact }" class="text-word">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">联&nbsp; 系&nbsp; 电&nbsp; 话：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="tel" value="${bean.tel }" class="text-word" id="1">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合同生效日期：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="date" name="startTime" value="${bean.startTime }" class="text-word" id="2">
                        </td>
                    </tr>
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合同截至日期：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="date" name="endTime" value="${bean.endTime }" class="text-word" id="3">
                        </td>
                    </tr>
                   <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">合 同 复 印 件：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input type="text" name="img" value="${bean.img }" class="text-word" id="4">
                        </td>
                    </tr>
                 </table>
                 <table width="100%" border="0" cellspacing="0" cellpadding="0" id="parking">
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">车&nbsp; 位&nbsp; 编&nbsp; 号：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <%-- <input type="text" name="parkingNumber" value="${parkingNumber }" class="text-word" id="5"> --%>
                            <div class="address"><select></select></div>
                        </td>
                        <td align="right" valign="middle" class="borderright borderbottom bggray">车&nbsp; 位&nbsp; 地&nbsp; 址：</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <%-- <input type="text" name="address" value="${address }" class="text-word" id="6"> --%>
                            <div class="parkingNumber"><select></select></div>
                        </td>
                        <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;">
                        	<a href="javascript:addParking()" target="mainFrame" onFocus="this.blur()" class="add">新增车位</a></td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                    <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
                        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
                        <td align="left" valign="middle" class="borderright borderbottom main-for">
                            <input name="" type="submit" value="提交" class="text-but">
                            <input name="" type="button" value="返回" class="text-but" onclick="javascript:history.go(-1);"></td>
                    </tr>
                </table>
             </form>
        </td>
    </tr>
</table>
</body>

<script type="text/javascript">
	var line = "";
	function addParking(){
		var context = $("#parking").html();
		context += line;
		$("#parking").html(context);
	}
	function findAddress(){
		$.ajax({
			url:"/CBDSystem/showAddress.do",
			type:"post",
			data:{},
			dataType:"json",
			success:function(data){
				context="<select name='address' onchange='findParkingNumber(this)'>"
				context +="<option value='"+"'>"+"</option>";
				for(var i = 0;i<data.length;i++){
					context +="<option value='"+data[i]+"'>"+data[i]+"</option>";
				}
    			context +="</select>";
    			$(".address").html(context);
    			line = $("#parking").html();
			}
		})
	}
	findAddress();
	function findParkingNumber(e){
		var context = "";
		$.ajax({
			url:"/CBDSystem/showParkingNumber.do",
			type:"post",
			data:{
				"address":e.value
			},
			dataType:"json",
			success:function(data){
				context="<select name='parkingNumber'>"
				for(var i = 0;i<data.length;i++){
					context +="<option value='"+data[i]+"'>"+data[i]+"</option>";
				}
    			context +="</select>";
    			/* $(".parkingNumber").html(context); */
    			$(e).parentsUntil("table").find(".parkingNumber").html(context);
			}
		})
	}
</script>
</html>
