<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Supplier</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form:form action="${pageContext.request.contextPath}/UpdateSupplier"
		modelAttribute="supplier" method="post" enctype="multipart/form-data">
		<table align="center" cellspacing="2">
			<tr>
				<td colspan="2">Supplier Module</td>
			</tr>

			<tr>
				<td>Supplier ID</td>
				<td><form:input path="supplierId" /></td>
			</tr>

			<tr>
				<td>Supplier Nmae</td>
				<td><form:input path="supplierName" /></td>
			</tr>

			<tr>
				<td>Supplier E-mail</td>
				<td><form:input path="supplierMailId" /></td>
			</tr>
		</table>
		<tr>
		<td colspan="3"></td>
		<center>
			<input type="submit" value="UpdateSupplier" />
		</center>
	</tr>
	</form:form>
	
	<table cellspacing="2" align="center">
		<tr bgcolor="gray">
			<td>Supplier ID</td>
			<td>Supplier Name</td>
			<td>Supplier E-mail</td>
			<td>operation</td>
		</tr>

		<c:forEach items="${supplierList}" var="supplier">
			<tr bgcolor="cyan">
				<td>${supplier.supplierId}</td>
				<td>${supplier.supplierName}</td>
				<td>${supplier.supplierMailId}</td>
				
				<td><c:url value="/deleteSupplier/${supplier.supplierId}" var="delete"/>
				<a href="${delete}">DELETE</a>
				<c:url value="/updateSupplier/${supplier.supplierId}" var="update"/>
				<a href="${update}">UPDATE</a>
				</td>
			</tr>

		</c:forEach>


	</table>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>