<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>Centro partija - "Paskolos butelio dėžutėje partija"</div>
<p>Reitingas: ${fighterBL.rate}</p>
<p>Liko pinigų: ${fighterBL.moneyLeft}</p>
<p>Garbė: ${fighterBL.honorLeft}</p>

<table><!--Table  with choices-->
    <thead>
    <tr>
        <th>Taikinys</th>
        <th>Priemonė</th>
        <th>Pinigai</th>
        <th>Puolimas</th>
        <th>Gynyba</th>
    </tr>
    </thead>
    <tbody>
    <form id = fightForm>
    <tr>
        <td>Neturtingi rinkėjai</td>
        <td>
            <select id="priemone1" name = "power1" onchange="getValue()">
                <option value = 0>--Pasirinkite priemonę--</option>
                <c:forEach var="w" items="${fighterBL.weaponList}">
                <option value = "${w.power}">${w.name}: ${w.power}</option>
                </c:forEach>
            </select>
        </td>
        <td id = powerValue1>0</td>
        <td><input  type="radio" id="checkbox1p" name = "option1" value="at"></td>
        <td><input type="radio" id="checkbox1g" name = "option1" value="def"></td>
    </tr>
    </form>

    </tbody>
</table>
<button type = "submit" form="fightForm">Važiuojam!</button>

<script>
    function getValue() {
        val = document.getElementById("priemone1").value;
        document.getElementById("powerValue1").innerHTML = val;
    }
</script>



</body>
</html>
