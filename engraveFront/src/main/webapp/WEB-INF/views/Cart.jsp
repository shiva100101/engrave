<%@ page language="java" contentType="text/html" import="com.niit.model.Cart"%>
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
<title>Cart</title>
<style>
.btn {
	border-radius: 100px !important;
	border: 6px solid transparent !important;
}
label {
    display: inline-block;
    margin-bottom: 5px;
    font-weight: 700;
    float: left;
    margin-left: 80%;
}
</style>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>

	<div>
		<table class="table">
			<h1 align="center">Cart</h1>
			<thead class="blue-grey lighten-5">
				<tr bgcolor="black">
					<%-- <td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width=100px;height=100px;/></td>
					<td class="font"><p><font color="black">Product Name</font></p>${product.productName}</td>
					<td class="font"> <p><font color="black">Price</font></p>${product.price}</td>
					<td class="font"><p><font color="black">Description</font></p> ${product.productDesc}</td> --%>
					
					<td style="color: white;">Product Name</td>
					<td style="color: white;">Product Image</td>
					<td style="color: white;">Price</td>
					<td style="color: white;">Quantity</td>
					<td style="color: white;">Total</td>
					
					<td style="color: white;">Action</td>
				</tr>
			</thead>
 			<c:if test="${empty userCartList}">
				<tr>
					<td align="center">No Record Exist</td>
				</tr>
			</c:if>
		
			<c:if test="${!empty userCartList}">
				<c:forEach items="${userCartList}" var="cart">
					<tr bgcolor="#EEEEEE">
						<td>${cart.product.productName}</td>

						<td><img
							src="<c:url value="/resources/images/${cart.product.productId}.jpg"/>"
							width=100px;height=100px; /></td>
						<td><i class="fa fa-inr" aria-hidden="true"></i>
							${cart.cartPrice}</td>
						<td><i aria-hidden="true"></i>
							${cart.cartQuantity}</td>
						<td><i class="fa fa-inr" aria-hidden="true"></i>${cart.cartQuantity * cart.cartPrice}</td>	
						
						<td><a style="padding-left: 25px; color: red;"
							href="<c:url value="/deleteCart/${cart.cartId}"/>"><i
								class="glyphicon glyphicon-trash"></i></a></td>
							
							<c:set var="grandtotal"
					value="${grandtotal + (cart.cartPrice * cart.cartQuantity)}"></c:set>

					</tr>
				</c:forEach>
			</c:if>
			

		</table>
		
				
	</div>
	<c:if test="${!empty userCartList}">
		<a href="${pageContext.request.contextPath}/"><button>Continue Shopping</button></a>
		<div id="vov" style=margin-left:70%;>
				
				<h2>Grand Total:<c:out value="${grandtotal }"></c:out></h2>
				
			
			<a href="${pageContext.request.contextPath}/CheckOut"
			class="btn btn-success btn-outline">Checkout</a>
			</div>
	</c:if>
	<br>
	<c:if test="${empty userCartList}">
	<a href="${pageContext.request.contextPath}/"><button>Continue Shopping</button></a>
</c:if>

</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>