<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="<c:url value="/resources/styles/index.css" />"/>
</head>
<body class="main">

<a href="userstable">Modify Users</a> <br>
<a href="arena/">Arena</a>
<form action="arena/">
    <input type="hidden" name="id1" value="1">
    <input type="hidden" name="id2" value="2">
    <button >getFight1</button>
</form>
<form action="arena/">
    <input type="hidden" name="id1" value="2">
    <input type="hidden" name="id2" value="1">
    <button >getFight2</button>
</form>
<%--<form action="arena/1-2">--%>
<%--    <button >getFightPath</button>--%>
<%--</form>--%>
<div class="login-html">
    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Log In</label>
    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>


    <div class="login-form">
        <form action="loginuser" method="post" class="sign-in-htm">
            <div class="group">
                <label for="emailLogin" class="label">Email Adress</label>
                <input id="emailLogin" type="email" name="email" class="input" required>
            </div>
            <div class="group">
                <label for="passwordLogin" class="label">Password</label>
                <input id="passwordLogin" type="password" class="input" name="password" data-type="password" required>
            </div>
            <div class="group">
                <input type="submit" class="button" value="Log In">
            </div>
            <div class="hr"></div>
        </form>
        <form method="post" action="registeruser" class="sign-up-htm">
            <div class="group">
                <label for="usernameSignup" class="label">Username</label>
                <input id="usernameSignup" name="userName" type="text" class="input" required>
            </div>
            <div class="group">
                <label for="passwordSignup" class="label">Password</label>
                <input id="passwordSignup" name="password" type="password" class="input" data-type="password" required>
            </div>
            <div class="group">
                <label for="email" class="label">Email Address</label>
                <input id="email" name="email" type="text" class="input" required>
            </div>
            <div class="group">
                <input type="submit" class="button" value="Sign Up">
            </div>
            <div class="hr"></div>
            <div class="foot-lnk">
                <label for="tab-1">Already Member?</label>
            </div>
        </form>
    </div>
    <div class="error-message" style="color: red;text-align: center">${error}</div>
</div>
</body>
</html>
