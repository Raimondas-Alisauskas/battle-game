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
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</head>
<body class="main">
<a href="userstable">Modify Users</a>
<div class="login-html">
    <div class="container">
        <div class="col">
            <%--<img id="memberImage" src="<c:url value="/resources/images/${photo}"/>">--%>
            <img id="memberImage"/>
        </div>
        <div class="col">
            <div class="header">CREATE YOUR MEMBER</div>
            <div class="create-member">
                <form method="post" class="create-member-form">
                    <div class="select-member">
                        <div class="btn-group">
                            <div class="group">
                                <select class="form-control" onchange="getMemberList(this.id,'selectMember')"
                                        id="selectParty"
                                        name="selectParty">
                                    <option id="selectedConcreteParty">-- Select party --</option>
                                    <c:forEach var="p" items="${partiesList}">
                                        <option id="selectedConcreteParty">${p.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="select-member">
                        <div class="btn-group">
                            <div class="group">
                                <select class="form-control" id="selectMember" name="selectMember"
                                        onchange="getImage()"></select>
                            </div>
                        </div>
                    </div>
                    <div class="group" id="submit-button">
                        <input type="submit" class="button" value="Create member">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>

    function getMemberList(s1, s2) {

        var s1 = document.getElementById(s1);
        var s2 = document.getElementById(s2);
        var parties = [];
        s2.innerHTML = "";

        <c:forEach var="p" items="${partiesList}">
        parties.push("${p.name}");
        </c:forEach>

        if (s1.value == parties[0]) {

            var optionArray = [];
            var imageArray = [];
            optionArray.push("|-- Select member --");

            <c:forEach begin="0" end="9" var="c" items="${charactersList}">
            optionArray.push("${c.name}|${c.name}");
            imageArray.push("${c.image}");
            </c:forEach>

        }

        if (s1.value == parties[1]) {

            var optionArray = [];
            var imageArray = [];
            optionArray.push("|-- Select member --");

            <c:forEach begin="10" end="19" var="c" items="${charactersList}">
            optionArray.push("${c.name}|${c.name}");
            imageArray.push("${c.image}");
            </c:forEach>

        }

        if (s1.value == parties[2]) {

            var optionArray = [];
            var imageArray = [];
            optionArray.push("|-- Select member --");

            <c:forEach begin="20" end="29" var="c" items="${charactersList}">
            optionArray.push("${c.name}|${c.name}");
            imageArray.push("${c.image}");
            </c:forEach>

        }

        for (var option in optionArray) {

            var pair = optionArray[option].split("|");
            var newOption = document.createElement("option");
            newOption.value = pair[0];
            newOption.innerHTML = pair[1];
            s2.options.add(newOption);

        }

    }

    function getImage() {

        document.getElementById("memberImage").src = <c:url value="/resources/images/Aladin.png"/>;

    }

</script>
</body>
</html>
