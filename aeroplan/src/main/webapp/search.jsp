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
				src="https://www.airindia.in/assets/images/logo.svg"
				" width="80" height="48" class="d-inline-block align text-top">
			</a> <a href="aero">register</a> <a href="index.jsp">Home</a>
		</div>
	</nav>
	<h4 style="color: red">${mesage}</h4>
	<form action="Search">
		<input type="search" name="id"> <input type="submit"
			value="search">
	</form>
	<h5 style="color: green;">
		Company:${dto.company}<br> Name:${dto.name}<br>
		Cost:${dto.cost}<br> Type:${dto.type}<br>
		Country:${dto.country}<br>
	</h5>

</body>
</html>