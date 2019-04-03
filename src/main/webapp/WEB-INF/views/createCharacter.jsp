<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="<c:url value="/resources/styles/createCharacter.css" />"/>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="../js/wizard.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</head>
<body class="main">
<a href="userstable">Modify Users</a>
<div class="login-html">
    <div class="header">CREATE YOUR MEMBER</div>
    <div class="create-member">
        <form method="post" class="create-member-form">

            <div class="select-member">
                <div class="btn-group">
                    <div class="group">
                        <select class="form-control" id="selectParty">
                            <c:forEach var="p" items="${partiesList}">
                                <option>${p.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="select-member">
                <div class="btn-group">
                    <div class="group">
                        <select class="form-control" id="selectMember">
                            <c:forEach var="c" items="${charactersList}">
                                <option>${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>


            <div class="group">
                <input type="submit" class="button" value="Create member">
            </div>
        </form>
    </div>
    <%--<img src="/SpringMVC/resources/images/lzp_donald.png">--%>
</div>


</body>
</html>
