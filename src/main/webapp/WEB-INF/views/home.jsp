<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value="/resources/styles/createCharacter.css" />" />
</head>
	<body>
		<div class="background">
			<h1>Hello world!</h1>

			<P>The time on the server is ${serverTime}.</p>

			<form action="userDAL" method="post">
				<input type="text" name="userName"><br> <input
					type="submit" value="Login">
			</form>
		</div>
	</body>
</html>