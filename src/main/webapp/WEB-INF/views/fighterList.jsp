<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/styles/fighterList.css" />"/>
</head>
<body class="main">
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #313F66;">
    <a class="navbar-brand" style="color: white" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item" style="color: white">
                <a class="nav-link" style="color: white" href="#">Find opponent</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="color: white" href="#">Shop</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <div class="inset">
                <img src="<c:url value="/resources/images/${fighterUser.image}"/>">
            </div>
            <div class="navbar-text" style="color: white">
                Welcome, ${sessionScope.userName}
            </div>
            <a class="btn btn-primary my-2 my-sm-0" href="signout">Log out</a>
        </form>
    </div>
</nav>

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
