<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/styles/home.css" />"/>
</head>
<body>
<%@include file="header.jsp" %>


<c:choose>
    <c:when test ="${weaponsListBL.success == 'true'}" >

        <h1>Ginklu parduotuve</h1>
        <h2>Sveiki atvyke, ${username}</h2>
        <h3>Jus turite pinigu ${fighterUser.money}</h3>
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Pavadinimas</th>
                <th>Taikinys</th>
                <th>Kaina/Galia</th>
                <th>Pirkti</th>
            </tr>
            <c:forEach var="u" items="${weaponsListBL.data}">
                <tr>
                    <td>${u.name}</td>
                    <td>${u.target}</td>
                    <td>${u.power}</td>
                    <td>Pirkti</td>
                </tr>
            </c:forEach>

        </table>
</c:when>
<c:otherwise>
    <br>
    ${weaponsListBL.message}
</c:otherwise>
</c:choose>

</body>
</html>




