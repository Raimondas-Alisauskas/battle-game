<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Seimas Game</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/styles/createCharacter.css" />"/>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</head>
<body class="main">
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #313F66;">
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
                <img src="http://rs775.pbsrc.com/albums/yy35/PhoenyxStar/link-1.jpg~c200">
            </div>
            <div class="navbar-text" style="color: white">
                Welcome, ${sessionScope.userName}
            </div>
            <form method="post" action="signout">
                <input type="submit" value="Log out" class="btn btn-primary my-2 my-sm-0">
            </form>

        </form>
    </div>
</nav>

<div class="login-html">
    <div class="container">
        <div class="col">
            <img id="memberImage">
        </div>
        <div class="col">
            <div class="header">CREATE YOUR MEMBER</div>
            <div class="create-member">
                <form method="post" action="home" class="create-member-form">
                    <div class="select-member">
                        <div class="btn-group">
                            <div class="group">
                                <select class="form-control" onchange="getMemberList(this.id,'selectMember')"
                                        id="selectParty" name="selectParty">
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
            optionArray.push("${c.charname}|${c.charname}");
            imageArray.push("${c.imageReference}");
            </c:forEach>

        }

        if (s1.value == parties[1]) {

            var optionArray = [];
            var imageArray = [];
            optionArray.push("|-- Select member --");

            <c:forEach begin="10" end="19" var="c" items="${charactersList}">
            optionArray.push("${c.charname}|${c.charname}");
            imageArray.push("${c.imageReference}");
            </c:forEach>

        }

        if (s1.value == parties[2]) {

            var optionArray = [];
            var imageArray = [];
            optionArray.push("|-- Select member --");

            <c:forEach begin="20" end="29" var="c" items="${charactersList}">
            optionArray.push("${c.charname}|${c.charname}");
            imageArray.push("${c.imageReference}");
            </c:forEach>

        }

        for (var option in optionArray) {

            var pair = optionArray[option].split("|");
            var newOption = document.createElement("option");
            newOption.value = pair[0];
            newOption.id = "selectedConcreteMember";
            newOption.innerHTML = pair[1];
            s2.options.add(newOption);

        }

    }

    function getImage() {

        var images = [];

        <c:forEach var="p" items="${charactersList}">
        images.push("${p.imageReference}");
        </c:forEach>

        var selectedMember = document.getElementById("selectMember").value;

        for (var i = 0; i < images.length; i++) {

            if (images[i].includes(selectedMember)) {

                var imageName = images[i];
                break;

            }

        }

        document.getElementById("memberImage").src = "<c:url value="/resources/images/"/>" + imageName;

    }

</script>

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
