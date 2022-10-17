<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="history" scope="session" class="java.util.ArrayList"/>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link rel="icon" href="res/web1.2_icon.svg" type="image/svg">
    <script src="./js/main.js"></script>
    <title>Лабароторная работа №1</title>
</head>
<body>
<table id="main">
    <tr>
        <td colspan="2">
            <div style="float: left;">
                <object id="ic" data="res/web1.2_icon.svg" width="100px" height="100px"></object>
            </div>
            <div style="float: left;">
                <h1>Лабароторная работа №1 CASE 1914</h1>
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
            <form id="main-form" method="get" onsubmit="return validateMainForm(this)">
                <div class="input">
                    Выберите значение X:
                </div>
                <input type="button" name="value_x" value=-4 onclick="setValueX(-4)">
                <input type="button" name="value_x" value=-3 onclick="setValueX(-3)">
                <input type="button" name="value_x" value=-2 onclick="setValueX(-2)">
                <input type="button" name="value_x" value=-1 onclick="setValueX(-1)">
                <input type="button" name="value_x" value=0 onclick="setValueX(0)">
                <input type="button" name="value_x" value=1 onclick="setValueX(1)">
                <input type="button" name="value_x" value=2 onclick="setValueX(2)">
                <input type="button" name="value_x" value=3 onclick="setValueX(3)">
                <input type="button" name="value_x" value=4 onclick="setValueX(4)">
                <div class="input" id="xv" style="border-style: solid; width: 10%; text-align: center; border-radius: 45px;">NaN</div>
                <div class="input">
                    Введите значение Y:
                </div>
                <input type="text" id="input_y" name="y_value" aria-label="y_value" maxlength="11">
                <div class="input">
                    Выберите значение R:
                </div>
                <select id="input_r" name="r_value" aria-label="r_value">
                    <option value=1>1</option>
                    <option value=1.5>1.5</option>
                    <option value=2>2</option>
                    <option value=2.5>2.5</option>
                    <option value=3>3</option>
                </select>
                <div>
                    <button type="submit" class="button">Отправить</button>
                    <div class="validate-message"></div>
                </div>
            </form>
        </td>
        <td>
            <object id="plot" data="res/web2_plot.svg" width="600px" height="600px"> </object>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <div style="text-align: center"><button type="button" class="button" onclick="clearAnsTable()">Сбросить</button></div>
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
            </table>
        </td>
    </tr>
</table>
</body>
</html>