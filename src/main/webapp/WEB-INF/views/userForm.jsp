<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New user</h1>
<form:form method="post" action="update">
    <table border="2" width="70%" cellpadding="2">
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Admin</th>
        <th>Rating</th>
        <th>Money</th>
        <th>CharacterId</th>
        <th>PartyId</th>
        <th></th>
        <tr>
            <form:hidden path="id"/>
            <td><form:input path="userName"/></td>
            <td><form:input path="password"/></td>
            <td><form:input path="email"/></td>
            <td><form:input path="admin"/></td>
            <td><form:input path="rating"/></td>
            <td><form:input path="money"/></td>
            <td><form:input path="characterId"/></td>
            <td><form:input path="partyId"/></td>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>