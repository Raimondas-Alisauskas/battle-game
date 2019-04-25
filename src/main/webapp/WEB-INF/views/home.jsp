<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/styles/home.css" />"/>
</head>
<body class="main">
<%@include file="header.jsp" %>
<c:forEach var="f" items="${callingFighters.data}">
    <div class="allfighters">
        <form class="fighter form-inline my-2 my-lg-0" action="callfight" method="post">
            <div class="inset">
                <img src="<c:url value="/resources/images/${f.image}"/>">
            </div>
            <input value="${f.id}" name="calledFighter" type="hidden">
            <div class="navbar-text" style="color: white">
                    ${f.userName}
            </div>
            <div class="navbar-text" style="color: white">
                    ${f.party}
            </div>
            <div class="navbar-text" style="color: white">
                    ${f.member}
            </div>
            <div class="navbar-text" style="color: white">
                    ${f.rating}
            </div>
            <button id="accept" type="submit" class="btn btn-success" value="accept" name="action">Accept
            </button>
            <button id="decline" type="submit" class="btn btn-danger" value="decline" name="action">Decline
            </button>

        </form>
    </div>
</c:forEach>
<div class="my-profile">

    <div class="container">
        <div class="col">
            <img id="memberImage" src="<c:url value="/resources/images/${fighterUser.image}"/>">
            <input id="hidden" name="image" type="hidden">
        </div>
        <div class="col">
            <div>Username: ${sessionScope.userName}</div>
            <div>Party: ${fighterUser.party}</div>
            <div>Character: ${fighterUser.member}</div>
            <div>Money: ${fighterUser.money}</div>
            <div>Rating: ${fighterUser.rating}</div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
