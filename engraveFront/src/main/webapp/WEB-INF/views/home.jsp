<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
.img-rounded {
	
}
</style>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="utf-8">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	
	<!-- carousel starts here -->
	
	<div class="container-fluid">

		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img
						src="resources/images/vinayaka.jpg"
						class="img-responsive center-block"
						alt="slide1" style="width: 1400px;height: 400px;">
				</div>

				<div class="item">
					<img
						src="resources/images/elephant.jpg"
						class="img-responsive center-block"
						alt="slide2" style="width: 1400px;height: 400px;">
				</div>

				<div class="item">
					<img
						src="resources/images/theval.jpg"
						class="img-responsive center-block"
						alt="slide3" style="width: 1300px;height: 400px;"/>
				</div>
				
				<div class="item">
					<img
						src="resources/images/lion.jpg"
						class="img-responsive center-block"
						alt="slide4" style="width: 1300px;height: 400px;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- carousel ends here -->
	
	<!-- jumbotron -->
	<div class="container-fluid">
		<div class="jumbotron">
			<i class="fa fa-quote-left fa-2x fa-pull-left fa-border"></i>
			<h2>interior</h2>
			<p>"When it comes to art,buy with your eyses, not your ears. I tried very hard not to'decorate' with art. Art should be reflective of your personality  and what's going on in your head-not reflective of the colors of a sofa."</p>
			<center>
			<h2>Hotelier Jason Pomeranc</h2>
			</center>
		</div>
	</div>
	<!-- jumbotron ends here -->
	
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>