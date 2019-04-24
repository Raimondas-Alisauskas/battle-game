<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Error Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/styles/index.css" />"/>
</head>
<body class="main">
<div class="login-html">
    <h1  id="error-message" style="color: red;">Error have been occurred</h1>
    <h2 id="error-message" style="color: red;"> Error code is: <%= request.getAttribute("javax.servlet.error.status_code") %> </h2>
    <%switch ((request.getAttribute("javax.servlet.error.status_code")).toString()) {
        case "400":
    %> <h2 id="error-message" style="color: red;"> Bad request error, go back and try again </h2><%
        break;
    case "403":
%> <h2 id="error-message" style="color: red;"> This action is forbidden, please go back and try again</h2><%
        break;
    case "404":
%><h2 id="error-message" style="color: red;"> Page not found, go back and try again </h2><%
        break;
    case "405":
%><h2 id="error-message"> This function is not allowed, go back and try again</h2><%
        break;
    case "408":
%><h2 id="error-message" style="color: red;"> Request timeout, server haven't got information about a resource</h2><%
        break;
    case "500":
%><h2 id="error-message" style="color: red;"> Server error, that is our fault</h2>

    <h2 id="error-message" style="color: red;"> We are very sorry, please go back and try again </h2><%
        break;
    case "501":
%> <h2 id="error-message" style="color: red;">Function not implemented yet, we are working on it </h2>

    <h2 id="error-message" style="color: red;"> We are very sorry, please go back and try again </h2><%
        break;
    case "503":
%> <h2 id="error-message" style="color: red;"> Service not available at this moment</h2>

    <h2 id="error-message" style="color: red;"> We are very sorry, please go back and try again </h2><%
            break;
        default:
%> <h2 id="error-message" style="color: red;"> Unknown error</h2>

    <h2 id="error-message" style="color: red;"> We are very sorry, please go back and try again </h2><%
            break;
    }
%>
    <div>
        <button type="button" class="btn btn-primary" id="back" onclick="history.back()">Back
        </button>
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
