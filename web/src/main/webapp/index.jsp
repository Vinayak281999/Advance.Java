<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<nav style="background-color: purple;">
		<div class="container-fluid">
			<a> <img alt=""
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				width="400" height="100" />
			</a> <a href="">Egg</a>
		</div>
	</nav>
	<h1>Welcome to Egg Application</h1>
	
	
	<form action="egg" method="post">
	<pre>
	Hotel Name : <input type="text" name="hotelName"/>
	Egg Dish Name: 	<select name="dishName">
						<option>Select</option>
						<option>Omelette</option>
						<option>Egg Fried Rice</option>
						<option>Egg Curry</option>
						<option>Egg Biriyani</option>
						<option>Egg Masala</option>
						<option>Egg Toast</option>
						<option>Egg Bhurji</option>
						<option>Egg Bonda</option>
					</select>
	Egg Type : 	<select name="type">
					<option>Select</option>
					<option>Nati Koli</option>
					<option>Farm Koli</option>
					<option>Boiler Koli</option>
					<option>Duck</option>
					<option>Ostrich</option>
				</select>
	Price : <input type="number" name="price"/>	
	Quantity 	<select name="quantity">
					<option>Select</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>
	Take Away : 	Yes <input type="radio" value="true" name="takeAway"/>No <input type="radio" value="false" name="takeAway"/>
					
	<input type="submit" value="Order" class="btn btn-primary"/>
	</pre>
	</form>
</body>
</html>