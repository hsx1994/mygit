<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addparking.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        包租婆批量添加车位
        <form action="/CBDSystem/application.do" method="post" enctype="multipart/form-data">
        车位地址:<input type="text" name="address"><br/>
        车位号  :<input type="text" name="parkingNum"><br/>
        车位图片 :<input type="file" name="imgFile"><br/>
        车位价格 :<input type="text" name="price"><br/>
        开始时间 :<input type="date" name="startTime"><br/>
        结束时间 :<input type="date" name="endTime"><br/>
    产权证编号:<input type="text"  name="certificate"><br/>
   产权证复印件:<input type="file"  name="ImgFile"><br/> 
        <button type="submit">申请上架</button>
        </form> 
  </body>
</html>
