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
    <link rel="stylesheet" href="<c:url value="/resources/styles/shop.css" />"/>

</head>
<body>
<%@include file="header.jsp" %>

<c:choose>
    <c:when test ="${weaponsListBL.success == 'true'}" >

        <h1>Ginklų parduotuvė</h1>
        <h2>Sveiki atvykę, ${username}!</h2>
        <h3>Jūsų turimi pinigai: <strong id="user-money"> ${money} </strong></h3>
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
                    <td><button id="${u.id}" onclick="buyThis(this.id, this.name); this.disabled=true;" value="${u.power}" name="${u.name}">Pirkti</button></td>
                </tr>
            </c:forEach>
        </table>
        <br>

        <form id="shop-basket" method="post" action="fighter-weapon-map">
        <h3>Jūsų užsakymas:</h3>
            <input type="hidden" id="user-money-hidden" name="hidden-field">
        <div id="order-details"></div>
            <div id="order-details-hidden"></div>
            <br>
            <button id="submit-order"  type="submit">Patvirtinti pirkimą</button>
        </form>
        <form>
            <button id="cancel-order" onclick="clearOrder()" type="submit" method="post" action="get-fighter-money">Anuliuoti krepšelį</button>
          </form>
            </c:when>
<c:otherwise>
    <br>
    ${weaponsListBL.message}
</c:otherwise>
</c:choose>

<script>
    function buyThis(id, name) {
        let userMoney = Number(document.getElementById("user-money").innerHTML);
        let price = Number(document.getElementById(id).value);

        if (userMoney >= price) {
            let moneyAfter = userMoney - price;

            document.getElementById("user-money").innerHTML = moneyAfter;
            document.getElementById("user-money-hidden").setAttribute("value", moneyAfter);

            let infoNode = document.createElement("DIV");
            let textNode = document.createTextNode(name);
            infoNode.appendChild(textNode);

            let divNode = document.createElement("INPUT");
            divNode.setAttribute("value", id);
            divNode.setAttribute("name", id);
            divNode.setAttribute("type", "hidden");
            divNode.style.width = "600px";
            divNode.readOnly = true;
            document.getElementById("order-details-hidden").appendChild(divNode);
            document.getElementById("order-details").appendChild(infoNode);
            document.getElementById(id).disabled = true;
        }
    }

    function clearOrder() {
        let list = document.getElementById("order-details");
        while (list.hasChildNodes()) {
            list.removeChild(list.firstChild);
        }
        let listHidden = document.getElementById("order-details-hidden");
        while (listHidden.hasChildNodes()) {
            listHidden.removeChild(list.firstChild);
        }
    }
</script>
</body>
</html>




