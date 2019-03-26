<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="<c:url value="/resources/styles/member.css" />"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body class="main">
<a href="userstable">Modify Users</a>
<div class="login-html">
    <div class="header">CREATE YOUR MEMBER</div>
    <div class="create-member">
        <form method="post" class="create-member-form">

            <%--Dropdown--%>
            <div class="select-member">
                <div class="btn-group">
                    <div class="group">
                        <button class="btn btn-info btn-lg dropdown-toggle" type="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            SELECT PARTY
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Partija 1</a>
                            <a class="dropdown-item" href="#">Partija 2</a>
                            <a class="dropdown-item" href="#">Partija 3</a>
                            <a class="dropdown-item" href="#">Partija 4</a>
                            <a class="dropdown-item" href="#">Partija 5</a>
                        </div>
                    </div>
                </div>

                <div class="btn-group">
                    <div class="group">
                        <button class="btn btn-info btn-lg dropdown-toggle" type="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            SELECT MEMBER
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Member 1</a>
                            <a class="dropdown-item" href="#">Member 2</a>
                            <a class="dropdown-item" href="#">Member 3</a>
                            <a class="dropdown-item" href="#">Member 4</a>
                            <a class="dropdown-item" href="#">Member 5</a>

                        </div>
                    </div>
                </div>
            </div>


            <div class="group">
                <input type="submit" class="button" value="Create member">
            </div>
        </form>
    </div>
</div>
</body>
</html>
