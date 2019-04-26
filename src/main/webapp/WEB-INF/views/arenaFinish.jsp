<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${defaultDTO.message}</h2>
<div style="display:flex; justify-content: space-evenly;">
    <div>
        <div>fighterId: ${defaultDTO.data.fighter1.id}</div>
        <p>Reitingas: ${defaultDTO.data.fighter1.rate}</p>
        <p>Liko pinigų: ${defaultDTO.data.fighter1.moneyLeft}</p>
        <p>Garbė: ${defaultDTO.data.fighter1.honorLeft}</p>
    </div>

    <div >
        <div>fighterId: ${defaultDTO.data.fighter2.id}</div>
        <p>Reitingas: ${defaultDTO.data.fighter2.rate}</p>
        <p>Liko pinigų: ${defaultDTO.data.fighter2.moneyLeft}</p>
        <p>Garbė: ${defaultDTO.data.fighter2.honorLeft}</p>

    </div>
</div>


<div style="display:flex; justify-content: space-evenly;">
    <div>
        <table>
            <c:forEach var="al" items="${defaultDTO.data.fighter1ActionList}">

                <c:forEach var="a" items="${al.attackList}">
                    <tr>${a.targetId} ${a.weapon} ${a.attackType} ${a.isWinned}</tr>
                    <p>-----------------------------</p>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
    <div>
        <table>
            <c:forEach var="al" items="${defaultDTO.data.fighter2ActionList}">

                <c:forEach var="a" items="${al.attackList}">
                    <tr style="height: 2em">${a.targetId} ${a.weapon} ${a.attackType} ${a.isWinned}</tr>
                    <p>-----------------------------</p>
                </c:forEach>
            </c:forEach>
        </table>
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
