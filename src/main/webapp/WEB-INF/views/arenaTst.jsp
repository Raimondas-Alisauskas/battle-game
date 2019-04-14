<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${defaultDTO.message}</h2>
<div style="display: inline-flex">
    <div>
    <div>fighterId: ${defaultDTO.data.fighter1.id}</div>
    <p>Reitingas: ${defaultDTO.data.fighter1.rate}</p>
    <p>Liko pinigų: ${defaultDTO.data.fighter1.moneyLeft}</p>
    <p>Garbė: ${defaultDTO.data.fighter1.honorLeft}</p>

    <table><!--Table  with choices-->
        <thead>
        <tr>
            <th>Taikinys</th>
            <th>Priemonė</th>
            <th>Pinigai</th>
            <th>Puolimas</th>
            <th>Gynyba</th>
            <th>Nieko</th>
        </tr>
        </thead>
        <tbody>
        <form id = fightForm action="fight">
        <tr>
            <td>Neturtingi rinkėjai</td>
            <td>
                <select id="priemone1" name = "power1" onchange="getValue()">
                    <option name = "power1" value = 0>--Pasirinkite priemonę--</option>
                    <c:forEach var="w" items="${defaultDTO.data.fighter1.weaponList}">
                    <option name = "power1" value = "${w.power}">${w.name}: ${w.power}</option>
                    </c:forEach>
                </select>
            </td>
            <td id = powerValue1>0</td>
            <td><input type="radio"  name = "option1" value="at"></td>
            <td><input type="radio"  name = "option1" value="def"></td>
            <td><input type="radio"  name = "option1" value="null" checked="checked"></td>
        </tr>
        </form>

        </tbody>
    </table>
    </div>

    <div >
        <div>fighterId: ${defaultDTO.data.fighter2.id}</div>
        <p>Reitingas: ${defaultDTO.data.fighter2.rate}</p>
        <p>Liko pinigų: ${defaultDTO.data.fighter2.moneyLeft}</p>
        <p>Garbė: ${defaultDTO.data.fighter2.honorLeft}</p>

    </div>
</div>
<div>
<button type = "submit" form="fightForm">Važiuojam!</button><br>
<a href="deletefight">DeleteFight</a>
</div>

<script>
    function getValue() {
        val = document.getElementById("priemone1").value;
        document.getElementById("powerValue1").innerHTML = val;
    }
</script>



</body>
</html>
