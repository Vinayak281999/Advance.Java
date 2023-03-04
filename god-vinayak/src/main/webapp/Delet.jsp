<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZVpDXX0ujsuQS_asgWczXWcoCHatL_F1wcQ&usqp=CAU"
				alt="" width="80" height="48" class="d-inline-block align text-top">
			</a> <a href="index.jsp">Home</a>
			<a href="search.jsp">search</a>
		</div>
	</nav>
	<h5 style="color: pink;"> ${message}</h5>
	<h5 style="color: red;"> ${messag}
	<br>
	<c:forEach items="${errors}" var="e">
	 ${e.message}
	</c:forEach>
	</h5>
	
	<form action="delete" method="post">
	
	Name <input type="text" name="name" value="${dto.name}"/>
	<br>
	vehicle <input type="text" name="vehicle" value="${dto.vehicle}"/>
	<br>
	religion<select name="religion">
	<option  value="${dto.religion}">${dto.religion}</option>
	<c:forEach items="${religion}" var="p">
				  <option value="${p}">${p}</option>
			</c:forEach>
	</select>
	<br>
	
	Country	<select name="counties">
	<option value="${dto.counties}">${dto.counties}</option>
	<c:forEach items="${country}" var="p">
				<option value="${p}">${p}</option>
				
	</c:forEach>
	</select>
	<br>
	<input type="submit" value="Delet">
</form>

</body>
</html>