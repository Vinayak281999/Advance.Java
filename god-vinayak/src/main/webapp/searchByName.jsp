<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl4C8C--Qa9435NAeQKfNVq6uBi1Zb7Vt-JiIUN_oPMQtjuMnt3zVUnshAD9_Nzj-Cf90&usqp=CAU"
				alt="" width="80" height="48" class="d-inline-block align text-top">
			</a> <a href="index.jsp">Home</a> <a href="search.jsp">search</a> <a
				href="updateGod.jsp">updateGod</a>

		</div>



		<br> <a href="godName.jsp"> Register </a>
		</nav>

		<h1>Welcome to Search by name</h1>

		<h3>
			<span style="color: green"> ${message}</span>
		</h3>

		<form action="findByName" method="get">
		
			Search By name <input type="text" name="name" /> <input
				type="submit" value="search">

		</form>
		<br>

		<table border="2" class="table">
			<tr>
				<th>Id</th>
				<th>name</th>
				<th>vehicle</th>
				<th>country</th>
				<th>religion</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>
			<c:forEach items="${list}" var="f">

				<tr>
					<td>${f.id}</td>
					<td>${f.name}</td>
					<td>${f.vehicle}</td>
					<td>${f.counties}</td>
					<td>${f.religion}</td>
					<td><a href="update?id=${f.id}">Edit</a></td>
					<td><a href="delete?id=${f.id}">Delete</a></td>
				</tr>

			</c:forEach>

		</table>
</body>
</html>