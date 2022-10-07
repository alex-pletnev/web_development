<?php
session_start();
if (isset($_SESSION['data']))
    $_SESSION['data'] = array();
echo "<tr class=\"answer_table\">\n" .
    "                    <th class=\"answer_table\">X</th>\n" .
    "                    <th class=\"answer_table\">Y</th>\n" .
    "                    <th class=\"answer_table\">R</th>\n" .
    "                    <th class=\"answer_table\">ТЕКУЩЕЕ ВРЕМЯ (UTS)</th>\n" .
    "                    <th class=\"answer_table\">РЕЗУЛЬТАТ ПОПАДАНИЯ</th>\n" .
    "                    <th class=\"answer_table\">ВРЕМЯ ИСПОЛНЕНИЯ</th>\n" .
    "                </tr>";
