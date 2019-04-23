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
<%@include file="header.jsp" %>
<c:forEach var="f" items="${fighterList.data}">
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
            <c:if test="${f.isCalled == 1}">
                <button id="letsfight" class="btn btn-secondary" disabled>Waiting for response</button>
            </c:if>
            <c:if test="${f.isCalled == 0}">
                <button id="letsfight" type="submit" class="btn btn-success">Let's fight!</button>
            </c:if>
        </form>
    </div>
</c:forEach>

<script>

    function changeButton() {

        document.getElementById("letsfight").classList.remove('btn-success');
        document.getElementById("letsfight").classList.add('btn-secondary');
        document.getElementById("letsfight").innerHTML = "Waiting for response";

    }

</script>

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
