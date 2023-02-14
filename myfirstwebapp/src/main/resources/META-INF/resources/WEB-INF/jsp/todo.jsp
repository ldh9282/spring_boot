<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.css">
		<title>Add Todo Page</title>		
	</head>
	<body>
		<div class="container">
			<h1>Enter Todo Details</h1>
			<form method="post">
				Description: <input type="text" name="description">
				<button type="submit" class="btn btn-success">Submit</button>
			</form>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		
	</body>
</html>