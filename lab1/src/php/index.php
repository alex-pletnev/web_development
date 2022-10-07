<?php
$start = microtime(true);
session_start();
$x_str = $_GET["x"];
$y_str = $_GET["y"];
$r_str = $_GET["r"];
if (!isset($_SESSION['data']))
    $_SESSION['data'] = array();
date_default_timezone_set('UTC');

function checkHit($x_str, $y_str, $r_str) : bool{
//XMLHttpRequest
    if (is_numeric($x_str) && is_numeric($y_str) && is_numeric($r_str)) {
        //echo $x;
        $x = floatval($x_str);
        $y = floatval($y_str);
        $r = floatval($r_str);
        $xFractionalPartLen = strlen(explode(".", $x_str)[1]);
        $yFractionalPartLen = strlen(explode(".", $y_str)[1]);
        $rFractionalPartLen = strlen(explode(".", $r_str)[1]);
        if ($xFractionalPartLen < 11 && $yFractionalPartLen < 11 && $rFractionalPartLen < 11) {
            //1 part
            if ($x > 0 and $y > 0) {
                return false;

            }
            //2 part
            if ($x <= 0 and $y >= 0) {
                if ($x >= -$r and $y <= ($r / 2)) {
                    return true;
                } else {
                    return false;
                }
            }
            //3 part
            if ($x <= 0 and $y <= 0) {
                $x1 = -$r / 2;
                $x2 = 0;
                $x3 = 0;
                $y1 = 0;
                $y2 = -$r;
                $y3 = 0;
                $p1 = ($x1 - $x) * ($y2 - $y1) - ($x2 - $x1) * ($y1 - $y);
                $p2 = ($x2 - $x) * ($y3 - $y2) - ($x3 - $x2) * ($y2 - $y);
                $p3 = ($x3 - $x) * ($y1 - $y3) - ($x1 - $x3) * ($y3 - $y);
                if ($p1 == 0 || $p2 == 0 || $p3 == 0) {
                    return true;
                }
                if ($p1 > 0 and $p2 > 0 and $p3 > 0) {
                    return true;
                } elseif ($p1 < 0 and $p2 < 0 and $p3 < 0) {
                    return true;
                }
                return false;
            }
            //part 4
            if ($x >= 0 and $y <= 0) {
                if ($x * $x + $y * $y <= $r * $r) {
                    return true;
                }
                return false;
            }
        } else {
            header("HTTP/1.0 400 Bad Requestt");
        }
    } else {
        header("HTTP/1.0 400 Bad Requesttt");
    }
    return false;
}
function checkOdz($val, $max, $min): bool
{
    if (($val < $max) && ($val > $min)) {
        return true;
    } else {
        //echo "<br>";
        //echo $val, $max, $min;
        //echo "<br>";
        return false;
    }
}
function createTableRow($x_str, $y_str, $r_str, $today, $res, $ms) {
    echo "<tr class=\"answer_table\"><td class=\"answer_table\">".($x_str).
        "</td><td class=\"answer_table\">".($y_str).
        "</td><td class=\"answer_table\">".($r_str).
        "</td><td class=\"answer_table\">".($today).
        "</td><td class=\"answer_table\">".($res).
        "</td><td class=\"answer_table\">".($ms)."</td></tr>";

}
function valid($x, $y, $r) : bool
{

    return false;
}
$today = date("H:i:s");
$ans = checkHit($x_str, $y_str, $r_str);
$res = "FALSE";
if ($ans) {
    $res = "TRUE";
}
$end = microtime(true);
$diff = $end - $start;
$ms_num = round($diff * 1000, 3);
$ms = "".($ms_num). " (ms)";
createTableRow($x_str, $y_str, $r_str, $today, $res, $ms);
$row = array("x_str"=>$x_str, "y_str"=>$y_str, "r_str"=>$r_str, "today"=>$today, "res"=>$res, "ms"=>$ms);
$_SESSION['data'][] = $row;



//foreach ($_SESSION['data'] as $elem) {
//    echo "<tr class=\"answer_table\">";
//    echo "<td class=\"answer_table\">" . $elem['x_str'] . "</td>";
//    echo "<td class=\"answer_table\">" . $elem['y_str'] . "</td>";
//    echo "<td class=\"answer_table\">" . $elem['r_str'] . "</td>";
//    echo "<td class=\"answer_table\">" . $elem['today'] . "</td>";
//    echo "<td class=\"answer_table\">" . $elem['res'] . "</td>";
//    echo "<td class=\"answer_table\">" . $elem['ms'] . "</td>";
//    echo "</tr>";
//}


