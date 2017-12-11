<%@ page language="java" contentType="text/html" import="com.niit.model.Orders"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>My Orders</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
 	<div id="box1" style="width: 100%; float: left;margin:auto;margin-bottom:20%;">
 	<h1 align="center">History of Orders</h1>
		<table class="table"
			style="width: 70%; margin-top: 40px; margin-left: auto; margin-right: auto;">
			
			<thead class="blue-grey lighten-5">
				<tr bgcolor="black">
					<td style="color: white;">Order Id</td>
					<td style="color: white;">Date and Time of Orders</td>
					<td style="color: white;">Price of Orders</td>

					<td style="color: white;">Mode of Payments</td>
				</tr>
			</thead>
			<c:if test="${empty userOrdersList}">
				<tr>
					<td align="center">No Record Exist</td>
				</tr>
			</c:if>
			<c:if test="${!empty userOrdersList}">
				<c:forEach items="${userOrdersList}" var="orders">
				<tr bgcolor="#EEEEEE">
				<td>${orders.getOrderId()}</td>
				<td>${orders.getOrderDate()}</td>
				<td>${orders.getOrderAmount()}</td>
				<td>${orders.getPaymentMode()}</td>
				</tr>
				</c:forEach>
				</c:if>
				
	
</table>
</div> 
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>