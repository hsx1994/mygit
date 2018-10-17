<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/ShowParkingSpace.js"></script>
<title>普通管理员添加页面</title>
</head>
<body>
<hr>
<label>添加测试</label>
<br><br>
<form action="/CBDSystem/Administrator/register.do" method="post">
<label>密码：</label><input type="password" name="pass"><br/><br/>
<label>姓名：</label><input type="text" name="name"><br/><br/>
<label>提交： </label><input type="submit"><br/><br/>
<label>输出：</label>${name}
<hr>
</form>


<label>删除测试</label>
<br><br>
<form action="/CBDSystem/Administrator/delete.do" method="post">
<label>管理员id：</label><input type="text" name="id"><br/><br/>
<label>提交： </label><input type="submit"><br/><br/>
<label>输出：</label>${result}	
</form>
<hr>
<label>修改测试</label>
<br><br>
<form action="/CBDSystem/Administrator/change.do" method="post">
<label>管理员id：</label><input type="text" name="id"><br/><br/>
<label>修改权限：</label><input type="text" name="limit"><br/><br/>
<label>提交： </label><input type="submit"><br/><br/>
<label>输出：</label>${changeresult}	
</form>
<hr>




<label>查询所有管理员的测试</label>
<br><br>
<form action="/CBDSystem/Administrator/findAll.do" method="post">
<label>提交： </label><input type="submit"><br/><br/>
<c:forEach items="${ablist}" var="ab" >
		<tr>

			 <td align = "center">${ab.id}</td>
		 </tr>

</c:forEach>
</form>
<hr>


<form id="from1" action="/CBDSystem/16.do" method="post">
 <label>提交： </label><input type="submit"><br/><br/>  
 提交：
<c:forEach items="${allParking}" var="ab" >
		<tr>

			 <td align = "center">${ab.id}</td>
		 </tr>

</c:forEach> 
 </form>
</body>
 <script type="text/javascript" src="../063/js/ShowParkingSpace.js"></script>
</html>