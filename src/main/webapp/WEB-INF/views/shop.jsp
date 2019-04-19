<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
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




