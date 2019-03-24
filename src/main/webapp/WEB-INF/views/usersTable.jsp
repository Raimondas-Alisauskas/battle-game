<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users table</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Password</th>
        <th>Admin</th>
        <th>Rank</th>
        <th>Money</th>
        <th>CharacterId</th>
        <th>PartyId</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="u" items="${usersList}">
        <tr>
            <td>${u.id}</td>
            <td>${u.userName}</td>
            <td>${u.password}</td>
            <td>${u.admin}</td>
            <td>${u.rank}</td>
            <td>${u.money}</td>
            <td>${u.characterId}</td>
            <td>${u.partyId}</td>
            <td><a href="editUser/${u.id}">Edit</a></td>
            <td><a href="deleteUser/${u.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="insertUser">Add New User</a>