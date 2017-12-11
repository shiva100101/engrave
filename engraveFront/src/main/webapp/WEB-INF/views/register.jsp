<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container" align="center">
			<div class="col-lg-12">

			<div class="row">
					
			<!-- 	<c:url value="saveregister" var="action"></c:url> -->
				<form:form action="saveregister" method="post" name="form" modelAttribute="user" id="registerForm">
				 
					 <body>
      <div id="container">
         <header><h3>Create new account</h3></header>
        <%--  <form method="post"> --%>
            <fieldset>
               <br/>
                             
               <input type="text" name="name" id="name" placeholder="Enter UserName" >
               <br/><br/>
               
               <input type="email" name="email" id="email" placeholder="Enter E-mail Address" >
               <br/><br/>
                             
               <input type="text" name="phone" id="phone" placeholder="Enter Phone Number"  >
               <br/><br/>
               
               <input type="text" name="address" id="address" placeholder="Enter Address"  >
               <br/><br/>
               
                <input type="password" name="password" id="password" placeholder="Enter Password" >
               <br/><br/>
               
               
               
               <input type="text" name="country" id="country" placeholder="Enter Country"  >
               <br/><br/>
               
               <label for="submit"></label>
               <button type="submit" class="glyphicon glyphicon-edit">Register</button>

               <label for="reset"></label>
               <button type="reset" class="">Cancel</button>
            </fieldset>
        <%--  </form> --%>
      </div>
   </body>
   			</form:form>
			</div>
		</div>
	</div>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>