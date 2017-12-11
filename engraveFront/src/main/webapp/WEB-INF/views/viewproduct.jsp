<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
<style type="text/css">
p{
color:black;
font-family: "arial";
}
.font
{
font-family: "arial";
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
	<center>
		<h2>Product Details</h2>
	</center>
	<br>
	<div class="container">
		<table class="table table-striped">
			<tr>
			
				<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width=100px;height=100px;/></td>
				<td class="font"><p><font color="black">Product Name</font></p>${product.productName}</td>
				<td class="font"> <p><font color="black">Price</font></p>${product.price}</td>
				<td class="font"><p><font color="black">Description</font></p> ${product.productDesc}</td>
			 
			</tr>
		</table>
		
		<form action="${pageContext.request.contextPath}/addToCart?id=${product.productId}" method="post">
			<!-- Enter Units<input type="text" name="units"><br> -->
			
				<input type="hidden" name="cartStock" id="cartStock" value="${Product.stock}" />
			<input type="number" style="width: 30%;"
				class="form-control" name="quant" required /><br>
			<button type="submit">
			<span class="glyphicon glyphicon-shopping-cart"></span>AddToCart</button>
			</form>	
	<c:url value="/productlist" var="action"></c:url>
		<form action="${action}">
			<button>
			<span class="glyphicon glyphicon-step-backward"></span>Back</button>
			</form>
		

	
	<c:if  test="${Product.stock==0 }">
	<center><p>Out Of Stock</p></center>
	</c:if>
	
	</div><br>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>