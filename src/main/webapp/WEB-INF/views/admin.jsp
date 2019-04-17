<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test ="${usersListBL.success == 'true'}" >
        <h1>Users table</h1>
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Admin</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="u" items="${usersListBL.data}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.userName}</td>
                    <td>${u.password}</td>
                    <td>${u.email}</td>
                    <td>${u.isAdmin}</td>
                    <td><a href="edituser/${u.id}">Edit</a></td>
                    <td><a href="deleteuser/${u.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="insertnewuser">Add New User</a>
    </c:when>
    <c:otherwise>
        <br>
        ${usersListBL.message}
    </c:otherwise>
</c:choose>

