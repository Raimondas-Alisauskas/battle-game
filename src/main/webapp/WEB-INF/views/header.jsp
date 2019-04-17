<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <c:choose>
                    <c:when test="${fighterUser.image != null}">
                        <img src="<c:url value="/resources/images/${fighterUser.image}"/>">
                    </c:when>
                    <c:when test="${fighterUser.image == null}">
                        <img src="http://rs775.pbsrc.com/albums/yy35/PhoenyxStar/link-1.jpg~c200">
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