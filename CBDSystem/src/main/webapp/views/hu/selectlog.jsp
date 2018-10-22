<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单列表</title>
<style type="text/css">
.inner-center {
	float: left;
	width: 100px;
	height: 100px;
	border: 1px solid red;
	text-align: center;
	line-height: 100px;
}

.outter {
	width: 1100px;
	height: auto;
	border: 2px solid blue;
	margin: auto;
}

td {
	width: 200px;
	height: auto;
	text-align: center;
}
</style>

</head>
<script type="application/x-javascript"
	src="../../js/public/jquery.1.9.1.js"></script>
<body>
	<div class="outter">
		<table border=1>
			<thead>
				<tr>

					<th>车位号</th>
					<th style="width: 1000px;height: auto;text-align: center;">订单信息</th>



				</tr>

			</thead>
			<tbody>
				<c:forEach items="${list}" var="obj">
					<tr>
						<td style="width: 100px;height: auto;text-align: center;">${obj.parkingNum }</td>
						<td>
							<table border=1>
								<thead>
									<c:forEach items="${obj.orders }" var="list">
										<tr>
											<td>${list.id}</td>
											<td>${list.startTime}</td>
											<td>${list.endTime}</td>
											<td>${list.user.realName}</td>
											<td>${list.state}</td>
											<td>${list.pay}</td>
											<td><form action="/CBDSystem/showOneOrder.do"
													method="post">
													<input type="hidden" value="${list.id}" name="id">
													<button type="submit">查看详情</button>
												</form></td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>