<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<jsp:include page="header.jsp"></jsp:include>
<div class="clear spaces10"></div>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 container containerMinHeight">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
		<table class="table table-hover" align="center">
			<tr class="tableHead">
				<th>Cart Id</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total</th>
				<th>Operation</th>
			</tr>
			<c:if test="${empty userCartList}">
				<tr class="tableContent" align="center">
					<td colspan="6">No products available in your cart.</td>
				</tr>
			</c:if>
			<c:if test="${!empty userCartList}">
			<c:forEach items="${userCartList}" var="cart">
				<tr class="tableContent">
					<td>${cart.cartId }</td>
					<td>${cart.cartId }</td>
					<td>${cart.cartQuantity }</td>
					<td>${cart.cartPrice }</td>
					<td>${cart.cartQuantity*cart.cartPrice }</td>
					<td>
						<a href="${pageContext.request.contextPath}/deleteCart/${cart.cartId}">Remove</a>
					</td>
					<c:set var="grandtotal" value="${grandtotal + (cart.cartQuantity*cart.cartPrice) }"></c:set>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td colspan="3"><label>Grand Total: </label></td>
				<td colspan="2"><label><c:out value="${grandtotal }"></c:out></label></td>
				<td></td>
			</tr>
			</c:if>
			<!-- Continue Shopping/Checkout -->
		</table>
		<div class="clear spaces10"></div>
	</div>
</div>
<td><a href="${pageContext.request.contextPath}/shipping"
			class="btn btn-success btn-outline">shipping</a></td>
<div class="clear spaces10"></div>

<jsp:include page="footer.jsp"></jsp:include>