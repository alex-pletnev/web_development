<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="history" scope="" class="java.util.ArrayList"/>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link rel="icon" href="res/web1.2_icon.svg" type="image/svg">
    <title>Лабароторная работа №2</title>
</head>
<body>
<table id="main">
    <tr>
        <td colspan="2">
            <div style="float: left;">
                <object id="ic" data="res/web1.2_icon.svg" width="100px" height="100px"></object>
            </div>
            <div style="float: left;">
                <h1>Лабароторная работа №2 CASE 1198</h1>
            </div>

        </td>
    </tr>
    <tr>
        <td colspan="2">
            <h2 class="var">Плетнев А. Д. P32111</h2>
            <h2 class="var">ИСУ: 335156</h2>
        </td>
        <td>

        </td>
    </tr>
    <tr>
        <td>
            <form id="main-form" method="get" onsubmit="parseData(event);">
<%--                <div class="input">--%>
<%--                    Выберите значение X:--%>
<%--                </div>--%>
<%--                <input type="text" id="input_x" name="x_value" aria-label="x_value" maxlength="11">--%>
                <div class="form__group field">
                    <input type="text" class="form__field" maxlength="5" placeholder="Enter the X value" name="x_value" id='input_x' required />
                    <label for="input_x" class="form__label">Enter the X value</label>
                </div>
                <div class="form__group field">
                    <select class="form__field" id="input_y" name="y_value" aria-label="y_value">
                        <option value=-4>-4</option>
                        <option value=-4>-3</option>
                        <option value=-2>-2</option>
                        <option value=-1>-1</option>
                        <option value=0>0</option>
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                    </select>
                    <label for="input_y" class="form__label">Choose the Y value</label>
                </div>
                <div class="input">
                    Choose the R value
                </div>
                    <ul style="margin: auto -40px -40px;">
                        <li>
                            <input type="radio" id="r1-option" name="r_value" value=1 onclick="setValueR('1')">
                            <label for="r1-option">1</label>

                            <div class="check"></div>
                        </li>

                        <li>
                            <input type="radio" id="r2-option" name="r_value" value=2 onclick="setValueR('2')">
                            <label for="r2-option">2</label>

                            <div class="check"><div class="inside"></div></div>
                        </li>

                        <li>
                            <input type="radio" id="r3-option" name="r_value" value=3 onclick="setValueR('3')">
                            <label for="r3-option">3</label>

                            <div class="check"><div class="inside"></div></div>
                        </li>
                        <li>
                            <input type="radio" id="r4-option" name="r_value" value=4 onclick="setValueR('4')">
                            <label for="r4-option">4</label>

                            <div class="check"><div class="inside"></div></div>
                        </li>
                        <li>
                            <input type="radio" id="r5-option" name="r_value" value=5 onclick="setValueR('5')">
                            <label for="r5-option">5</label>

                            <div class="check"><div class="inside"></div></div>
                        </li>
                    </ul>
                <div style="flex-basis: 100%; height: 0;"></div>
                <div>
                    <button type="submit" class="button">submit</button>
                    <div class="validate-message"></div>
                </div>
            </form>
        </td>
        <td>
            <table class="answer_table" id="coord-live">
                <tr class="answer_table">
                    <th class="answer_table">X</th>
                    <th class="answer_table">Y</th>
                </tr>
                <tr class="answer_table">
                    <td class="answer_table" id="x-live">0</td>
                    <td class="answer_table" id="y-live">0</td>
                </tr>

            </table>
            <svg id="plot"  width="400px" height="400px" onclick="makeDot(event)">
                <c:forEach items="${history}" var="col">
                    <circle class = "shot" cx="${200 + 40 * col.getX()}" cy="${200 - 40 * col.getY()}" r="3" fill="#BC4321" stroke-width="1" stroke="#ffffff"></circle>
                </c:forEach>            </svg>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <div style="text-align: center">
                <button type="button" class="button" onclick="clearAnsTable()">clean</button>
            </div>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <table class="answer_table" id="at">
                <tr class="answer_table">
                    <th class="answer_table">X</th>
                    <th class="answer_table">Y</th>
                    <th class="answer_table">R</th>
                    <th class="answer_table">ТЕКУЩЕЕ ВРЕМЯ (UTC)</th>
                    <th class="answer_table">РЕЗУЛЬТАТ ПОПАДАНИЯ</th>
                    <th class="answer_table">ВРЕМЯ ИСПОЛНЕНИЯ</th>
                </tr>
                <c:forEach items="${history}" var="row">
                    <tr class="answer_table">${row.httpRowToString()}</tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
</body>
<script src="./js/main.js"></script>
<script src="./js/jquery-3.6.1.min.js"></script>
</html>