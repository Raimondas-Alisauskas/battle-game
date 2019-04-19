<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #313F66;">
    <c:choose>
        <c:when test="${sessionScope.fighterId != null}">
            <a class="navbar-brand" style="color: white" href="home">Home</a>
        </c:when>
    </c:choose>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${sessionScope.fighterId != null}">
                    <li class="nav-item" style="color: white">
                        <a class="nav-link" style="color: white" href="#">Find opponent</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="shop">Shop</a>
                    </li>
                </c:when>
            </c:choose>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <div class="inset">
                <c:choose>
                    <c:when test="${sessionScope.fighterId != null}">
                        <img src="<c:url value="/resources/images/${sessionScope.fighterImage}"/>">
                    </c:when>
                </c:choose>
            </div>
            <div class="navbar-text" style="color: white">
                Welcome, ${sessionScope.userName}
            </div>
            <a class="btn btn-primary my-2 my-sm-0" href="signout">Log out</a>
        </form>
    </div>
</nav>