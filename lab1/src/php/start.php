<?php
$lt = 0;
session_set_cookie_params($lt);
session_start();
if (isset($_SESSION['data'])) {
    foreach ($_SESSION['data'] as $elem) {
        echo "<tr class=\"answer_table\">";
        echo "<td class=\"answer_table\">" . $elem['x_str'] . "</td>";
        echo "<td class=\"answer_table\">" . $elem['y_str'] . "</td>";
        echo "<td class=\"answer_table\">" . $elem['r_str'] . "</td>";
        echo "<td class=\"answer_table\">" . $elem['today'] . "</td>";
        echo "<td class=\"answer_table\">" . $elem['res'] . "</td>";
        echo "<td class=\"answer_table\">" . $elem['ms'] . "</td>";
        echo "</tr>";
    }
}
