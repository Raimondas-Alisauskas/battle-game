<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: inline-flex">
    <div>
    <div>fighterId: ${fight.fighter1.id}</div>
    <p>Reitingas: ${fight.fighter1.rate}</p>
    <p>Liko pinigų: ${fight.fighter1.moneyLeft}</p>
    <p>Garbė: ${fight.fighter1.honorLeft}</p>

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
        <form id = fightForm action="arena/">
        <tr>
            <td>Neturtingi rinkėjai</td>
            <td>
                <select id="priemone1" name = "power1" onchange="getValue()">
                    <option value = 0>--Pasirinkite priemonę--</option>
                    <c:forEach var="w" items="${fight.fighter1.weaponList}">
                    <option name = "power1" value = "${w.power}">${w.name}: ${w.power}</option>
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
    </div>

    <div >
        <div>fighterId: ${fight.fighter2.id}</div>
        <p>Reitingas: ${fight.fighter2.rate}</p>
        <p>Liko pinigų: ${fight.fighter2.moneyLeft}</p>
        <p>Garbė: ${fight.fighter2.honorLeft}</p>

    </div>
</div>
<div>
<button type = "submit" form="fightForm">Važiuojam!</button>
</div>

<script>
    function getValue() {
        val = document.getElementById("priemone1").value;
        document.getElementById("powerValue1").innerHTML = val;
    }
</script>



</body>
</html>
