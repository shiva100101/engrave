<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>


<body>
<jsp:include page="header.jsp"></jsp:include>

<h2 align="center">Login Form</h2>

<form action="${pageContext.request.contextPath}/login" method="post" id="loginForm">
 

 <div class="container" align="center">
    <label><b>User Name</b></label>
    <input type="text" placeholder="Username" name="email" required></br></br>

    <label><b>Password</b></label>
    <input type="password" placeholder="Password" name="password" required></br>
    
    <u><a href="${pageContext.request.contextPath}/register">New User?</a></u><br>
        
   <input type="submit" value="login"/>
 
  </div>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

  <!--  -->
  
   
  
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>