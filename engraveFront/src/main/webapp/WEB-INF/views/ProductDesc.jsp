<%@ page language="java" contentType="text/html" import="com.niit.model.Product"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE> 
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<table class="table" style=width:50%;margin-top:100px;margin-left:auto;margin-right:auto;>
	<h1 align="center">Product List</h1>
    
    <thead class="blue-grey lighten-5"><tr bgcolor="#143A3D">
	<td style=color:white;>Product Name</td>
	<td style=color:white;>Category</td>
	<td style=color:white;>Supplier</td>
	<td style=color:white;>Price</td>
	<td style=color:white;>Stock</td>
	<td style=color:white;>Photo</td>
	<td style=color:white;>Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
	<tr bgcolor="#EEEEEE">
		<td>${product.productName}</td>
		<td>${product.catId}</td>
		<td>${product.supplierId}</td>
		<td>${product.price}</td>
		<td>${product.stock}</td>
		<td>
		<a href="productDesc/${product.productId}">
		<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width=100px;height=100px;/>
		</a>
		</td>
		<td><c:url value="/viewProduct/${product.productId}"
				   var="view" /> <a href="${view}">View</a>
		</td>
		</tr>
	</c:forEach>
</table>
<div  style=width:100%;height:2px;margin-top:400px;background:black;></div>

</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>