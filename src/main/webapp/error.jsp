<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oops!</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>Message</td>
				<td>${message}</td>
			</tr>
			<tr>
				<td>Error</td>
				<td>${error}</td>
			</tr>
			<tr>
				<td>Status</td>
				<td>${status}</td>
			</tr>
			<tr>
				<td>Date</td>
				<td>${timestamp}</td>
			</tr>
			<tr>
				<td>Exception</td>
				<td>${exception}</td>
			</tr>
			<tr>
				<td>StackTrace</td>
				<td>${trace}</td>
			</tr>
		</table>
		<br> <br>
		<h2>
			<a href="state"> Go back to safety </a>
		</h2>
	</center>
</body>
</html>