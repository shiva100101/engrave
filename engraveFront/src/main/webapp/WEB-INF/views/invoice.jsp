 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title></head>
<style>
.btn {
	border-radius: 100px !important;
	border: 6px solid transparent !important;
	width:20%;
}
</style>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

<div class="container" style="margin-bottom:10%;">
	<form action="${pageContext.request.contextPath}/ack" class="form-horizontal">
		<h1>	 Invoice</h1>
		<div class="container">

<div class="col-lg-8">
<div class="row">
<div class="form-group">
		<label for="firstname">Customer Name</label>
			
			<label  for="firstname">: ${user.name}</label>
		</div>
		
		<div class="form-group">
		<label for="email">Customer Email</label>
			
			<label  for="email">: ${user.email}</label>
			</div>
		
		<div class="form-group">
		<label  for="address">Customer Address</label>
			
			<label  for="address">: ${user.address}</label>
			</div>
			
			<div class="form-group">
		<label  for="address">Customer Phone</label>
			
			<label  for="phone">: ${user.phone}</label>
			</div>
			
			<div class="form-group">
		<label  for="deliverydate">Delivery Date</label>
			
			<label  for="deliverydate">: Within 7 working days.</label>
			</div>
			
			<div class="form-group">
			
			<label for="submit"></label>
			
			<button type="submit" class="btn btn-success btn-outline">Submit</button>
			
			</div>
		
		
		</div>
	</div>
	</div>
	</form>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>