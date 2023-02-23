<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-Workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"
				class="d-inline-block align-text-top"><img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" height="48" width="80"> </a> <a href="index.jsp">Home
				Page</a>
		</div>
	</nav>
	<h1>Welcome to Valentine Data saving....</h1>
	<c:forEach items="${errors}" var="e">
		<span style="color: red;">${e.message}</span>
		</br>
	</c:forEach>

	<form action="valentine" method="post">
		<div class="mb-3">
			<label for="formFile" class="form-label">Name</label> <input
				type="text" class="form-control" name="name" id="formFile"
				placeholder="Enter your Name" value="${dto.name}" />
		</div>
		<div class="mb-3">
			Valentine Name<label for="formFile" class="form-label">
				Valentine Name</label> <input type="text" class="form-control"
				name="valentineName" id="formFile"
				placeholder="Enter your Valentine Name" value="${dto.valentineName}" />
		</div>
		
		Select Places <select class="form-select"
			aria-label="Default select example" name="place">
			<option value="${dto.place}">Select places</option>
			<c:forEach items="${places}" var="p">
				<option value="${p}">${p}</option>
			</c:forEach>
			
		</select> Gift <select class="form-select" aria-label="Default select example"
			name="gift">
			<option value="${dto.gift}">Select Gift</option>
			<c:forEach items="${gifts}" var="g">
				<option value="${g}">${g}</option>
			</c:forEach>
		</select> <input type="submit" value="Save" class="btn btn-primary" />

	</form>


</body>
</html>