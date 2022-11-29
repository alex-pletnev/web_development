<%--
  Created by IntelliJ IDEA.
  User: aleksandrpletnev
  Date: 17.10.2022
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="history" scope="session" class="java.util.ArrayList"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link rel="stylesheet" href="css/result.css" type="text/css">

</head>
<body>
    <table style="width: 100%; height: 100%">
        <tr>
            <td>
                <div class="prew">Result</div>
            </td>
        </tr>
        <tr>
            <td>
                <table class="answer_table" id="mt">
                    <tr class="answer_table">
                        <th class="answer_table">X</th>
                        <th class="answer_table">Y</th>
                        <th class="answer_table">R</th>
                        <th class="answer_table">ТЕКУЩЕЕ ВРЕМЯ (UTC)</th>
                        <th class="answer_table">РЕЗУЛЬТАТ ПОПАДАНИЯ</th>
                        <th class="answer_table">ВРЕМЯ ИСПОЛНЕНИЯ</th>
                    </tr>
                    <tr class="answer_table" id="ar">
                        ${history.get(history.size()-1).httpRowToString()}
                    </tr>

                </table>
            </td>
        </tr>
        <tr>
            <td id="pic">
                <img src="./res/web2_start.svg" width="700px" height="700px" alt="img" style="margin: auto auto auto auto">
            </td>
        </tr>
        <tr>
            <td>
                <div style="text-align: center">
                    <button type="button" class="button" onclick="goToMainPage()">Continue</button>
                </div>
            </td>
        </tr>
    </table>


<%--TODO do this part--%>
</body>
<script src="./js/anime.min.js"></script>
<script src="./js/result.js"></script>
</html>
