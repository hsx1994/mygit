<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <title>订单列表</title>
	 <style type="text/css">
      .inner-center{
      float: left;
      width: 198px;
      height: 100px;
      border: 1px solid red;
      text-align: center;
      line-height: 100px;
     }
    .outter{
     width: 1000px;
     height: auto;
     border: 2px solid blue;
     margin: auto;
    }
    </style>

</head>
  <script type="application/x-javascript" src="../../js/public/jquery.1.9.1.js"></script>
 <body>
   <div class="outter">
      <table border=1>
		<thead>
			<tr>
				
				<th>订单编号</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>车位号</th>
				<th>车位总价</th>
				<th>订单状态</th>
				<th>操作</th>
				
			</tr>
			
		</thead>
		<tbody>
			<c:forEach items="${list}" var="obj">
				<tr>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.id }</td>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.startTime }</td>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.endTime}</td>
					
					<td style="width: 198px;height: 100px;text-align: center;">${obj.parking.parkingNum }</td>
					<td style="width: 198px;height: 100px;text-align: center;">${obj.pay }</td>
				    <td style="width: 198px;height: 100px;text-align: center;">${obj.state }</td>
				    <td style="width: 198px;height: 100px;text-align: center;">
				    <form action="/CBDSystem/addComplaint.do" method="post">
					<input type="hidden" value="${obj.id }" name="id">
				     <button type="submit">添加投诉</button>
				    </form>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
   </div>
</body>

</html>