<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>${pageTitle}</title>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>


<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/FormValidation.js"></script>

<style>
{
height:100%;
}
.fx{
position:fixed;
z-index:9
}
div.container a {
	color: black;
	text-decoration: none;
	font: 15px Raleway;
	position: relative;
	z-index: 0;
	cursor: pointer;
}
/* Circle behind */
div.circleBehind a:before, div.circleBehind a:after {
	position: absolute;
	top: 22px;
	left: 50%;
	width: 50px;
	height: 50px;
	border: 4px solid #0277bd;
	transform: translateX(-50%) translateY(-50%) scale(0.8);
	border-radius: 50%;
	background: transparent;
	content: "";
	opacity: 0;
	transition: all 0.3s;
	z-index: -1;
}
div.circleBehind a:after {
	border-width: 2px;
	transition: all 0.4s;
}
div.circleBehind a:hover:before {
	opacity: 1;
	transform: translateX(-50%) translateY(-50%) scale(1);
}
div.circleBehind a:hover:after {
	opacity: 1;
	transform: translateX(-50%) translateY(-50%) scale(1.3);
}
nav {
	background-color: #1B4F50 !important;
	border-color: darkblue !important;
		text-align: center;
}
nav a:hover {
	color: black !important;
}
.nav.navbar-nav.navbar-right li a {
	color: white;
}
.nav.navbar-nav li a {
	color: white;
}
.navbar-toggle.collapsed li a{
	background-color: #239B56 !important;
}
.navbar-inverse .navbar-brand {
	color: #ffc107;
}
.dropdown a {
	background-color: #239B56 !important;
}
.dropdown-menu li a {
	background-color: white !important;
	color: black !important;
	height: 50px;
	text-align: center;
}
</style>

</head>

<body>
  
  <!-- Header Navbar Content - Start -->

		<nav id="navbar-black" class="navbar navbar-inverse navbar-static-top" role="navigation">
			<div class="container">
				<ul class="nav navbar-nav">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#In_Dec-nav">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</ul>
			</div>
			<div class="collapse navbar-collapse spaces5 bottom5" id="In_DEC-nav">	
				<a href="${pageContext.request.contextPath}/">
					<img src="${pageContext.request.contextPath}/resources/images/logoengrave4.png" align="left" height="90px" width="150px" class="logoImgStyle shiftLeft left5" />	
					
				</a>	
				
						
				<ul class="nav navbar-right navbar-nav right0">
					<li><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home"></span> Engrave</a></li>
					<c:if test="${pageContext.request.userPrincipal.name==null}">
						
						<li><a href="${pageContext.request.contextPath}/gotologin"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
						<li><a href="${pageContext.request.contextPath}/register">Sign Up</a></li>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name!=null}">
					<c:if test = "${sessionScope.roleName == 'user'}">
					<li><a href="${pageContext.request.contextPath}/productlist">Products</a></li>
					<li>
						<a href="${pageContext.request.contextPath}/MyCart"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;My Cart</a>
						<div class="notification">${sessionScope.cartCount}</div>
					</li>
					</c:if>
					<c:if test = "${sessionScope.roleName == 'admin'}">
						<li>
							<a class="dropdown-toggle navbarTitleStyle" data-toggle="dropdown" href="#">Admin Roles<span class="caret"></span></a>
							
							<ul class="dropdown-menu">
								
								<li><a href="${pageContext.request.contextPath}/category">Category</a></li>
								
								<li><a href="${pageContext.request.contextPath}/supplier">Suppliers</span></a></li>
								
								<li><a href="${pageContext.request.contextPath}/product">Products</span></a></li>
								
							</ul>
						</li>
						</c:if>
						<li>
							<a class="dropdown-toggle navbarTitleStyle" data-toggle="dropdown" href="#">
								Welcome, ${sessionScope.userName}<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
							</ul>
						</li>
					</c:if>


				</ul>
			</div>
		</nav>
</div>
  
  </body>