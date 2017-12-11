<%@ page language="java" contentType="text/html"
	import="com.niit.model.Category"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>In_Dec</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:url value="/AddCategory" var="insert" />
	<!--<form action="AddCategory" method="post">-->
	<form:form action="AddCategory" modelAttribute="category" id="categoryForm">
		<table align="center" cellspacing="2">
			<tr>
				<td colspan="2">Category Module</td>
			</tr>
			<tr>
				<td>Category ID</td>
				<td><form:input class="form-control" path="catId" /></td>
			</tr>
			<tr>
				<td>Category Name</td>
				<td><form:input class="form-control" path="catName" />
			</tr>
			<tr>
				<td>Category Desc</td>
				<!--<td><input type="text" name="catDesc" /></td>-->
				<td><form:input class="form-control" path="catDesc" />
			</tr>
		</table>
		<tr>
		<td colspan="3"></td>
		<center>
			<input type="submit" value="Insert" />
		</center>
	</tr>
	</form:form>
	
	<table cellspacing="2" align="center">
		<tr bgcolor="#C2FFEF">
			<td>Category ID</td>
			<td>Category Name</td>
			<td>Category Description</td>
			<td>operation</td>
		</tr>

		<c:forEach items="${categoryList}" var="category">
			<tr bgcolor="#E6FFEC">
				<td>${category.catId}</td>
				<td>${category.catName}</td>
				<td>${category.catDesc}</td>
				
				<td><c:url value="/deleteCategory/${category.catId}" var="delete"/>
				<a href="${delete}">DELETE</a>
				<c:url value="/updateCategory/${category.catId}" var="update"/>
				<a href="${update}">UPDATE</a>
				</td>
			</tr>

		</c:forEach>


	</table>

</body><br><br><br><br><br><br><br><br>

<jsp:include page="footer.jsp"></jsp:include>
</html>