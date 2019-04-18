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
        <form id = fightForm action="fight" method="get">
        <tr>
            <td>Neturtingi rinkėjai</td>
            <td>
                <select id="priemone1" name = "weapon1" onchange="getValue()">
                    <option name = "power1" value = "no--0">--Pasirinkite priemonę--</option>
                    <c:forEach var="w" items="${defaultDTO.data.fighter1.weaponList}">
                    <option value = "${w.name}--${w.power}">${w.name}: ${w.power}</option>
                    </c:forEach>
                </select>
            </td>
            <td id = powerValue1>0</td>
            <td><input type="radio"  name = "attType1" value="at"></td>
            <td><input type="radio"  name = "attType1" value="def"></td>
            <td><input type="radio"  name = "attType1" value="null" checked="checked"></td>
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

<div style="display: inline-flex">
    <div>
    <c:forEach var="al" items="${defaultDTO.data.fighter1ActionList}">
        <p></p>
        <c:forEach var="a" items="${al.attackList}">
            <p>${a.targetId} ${a.weapon} ${a.attackType} ${a.isWinned}</p>
        </c:forEach>
    </c:forEach>
    </div>
    <div>
        <c:forEach var="al" items="${defaultDTO.data.fighter2ActionList}">
            <p></p>
            <c:forEach var="a" items="${al.attackList}">
                <p>${a.targetId} ${a.weapon} ${a.attackType} ${a.isWinned}</p>
            </c:forEach>
        </c:forEach>
    </div>
</div>

<script>
    function getValue() {
        var val = document.getElementById("priemone1").value;
        var arr = val.split('--');
        document.getElementById("powerValue1").innerHTML = arr[arr.length-1];
    }
</script>



</body>
</html>
