<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add State</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
	padding: 20px;
}

.form-container {
	max-width: 500px;
	margin: 0 auto;
	background-color: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.1);
}

.form-container h3 {
	margin-bottom: 20px;
}

.form-container form input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border-radius: 5px;
	border: 1px solid #ced4da;
}

.form-container form button[type="submit"] {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
}

.form-container form button[type="submit"]:hover {
	background-color: #0056b3;
}

.message {
	margin-top: 20px;
	padding: 10px;
	border-radius: 5px;
	background-color: #d4edda;
	color: #155724;
}
</style>
</head>
<body>
	<div class="form-container">
		<c:if test="${state!=null}">
			<h3>Update a State</h3>
			<form action="updateStates" method="post">
				<input type="hidden" name="state_id"
					value="<c:out value="${state.state_id}"/>"> <input
					type="text" name="name" placeholder="Enter Name"
					value="<c:out value="${state.name}"/>"><br> <input
					type="text" name="abbrevation" placeholder="Enter Abbreviation"
					value="<c:out value="${state.abbrevation}"/>"><br> <input
					type="text" name="popultion" placeholder="Enter Population"
					value="<c:out value="${state.popultion}"/>"><br> <input
					type="text" name="capital" placeholder="Enter Capital"
					value="<c:out value="${state.capital}"/>"><br>
				<button type="submit">Update State</button>
			</form>
			<div class="message">
				<%=request.getAttribute("message") != null ? request.getAttribute("message") : ""%>
			</div>
		</c:if>

		<c:if test="${state==null}">
			<h3>Add a State</h3>
			<form action="addState" method="post">
				<input type="text" name="state_id" placeholder="Enter State ID"
					size="30"><br> <input type="text" name="name"
					placeholder="Enter State Name" size="30"><br> <input
					type="text" name="abbrevation" placeholder="Enter Abbreviation"
					size="30"><br> <input type="text" name="population"
					placeholder="Enter Population" size="30"><br> <input
					type="text" name="capital" placeholder="Enter Capital" size="30"><br>
				<button type="submit">Add State</button>
			</form>
			<div class="message">
				<%=request.getAttribute("message") == null ? request.getAttribute("message") : "Failed to intert please try again"%>
			</div>
		</c:if>
	</div>
	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
