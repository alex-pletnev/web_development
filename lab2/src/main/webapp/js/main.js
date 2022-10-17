let x = NaN;
let y = NaN;
let r = NaN;
let tableHeader = "<tr class=\"answer_table\">\n" +
    "                    <th class=\"answer_table\">X</th>\n" +
    "                    <th class=\"answer_table\">Y</th>\n" +
    "                    <th class=\"answer_table\">R</th>\n" +
    "                    <th class=\"answer_table\">ТЕКУЩЕЕ ВРЕМЯ (UTC)</th>\n" +
    "                    <th class=\"answer_table\">РЕЗУЛЬТАТ ПОПАДАНИЯ</th>\n" +
    "                    <th class=\"answer_table\">ВРЕМЯ ИСПОЛНЕНИЯ</th>\n" +
    "                </tr>"
let validateMessage = document.querySelector('.validate-message');
const regexAns = new RegExp('(fasle|true)');
startFunction();
function setValueX(a_x) {
    x = String(a_x);
    document.getElementById("xv").innerHTML = x;
    console.log(x);
}
function startFunction() {
    let xhr = new XMLHttpRequest();
    let data = "?start=true"
    xhr.open("GET", "./controller" + data, true);
    xhr.send(null);
    xhr.onload = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                document.querySelector(".answer_table").innerHTML = tableHeader + xhr.response;
            }
        }
    }
}

function clearAnsTable() {
    let xhr = new XMLHttpRequest();
    let data = "?clean=true";
    xhr.open("GET", "./controller" + data, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                document.querySelector(".answer_table").innerHTML = tableHeader + xhr.response;
            }
        }
    }
}

function validateMainForm() {
    y = parseFloat(document.getElementById("input_y").value);
    r = parseFloat(document.getElementById("input_r").value);
    if (!isNaN(x) && !isNaN(y) && !isNaN(r)) {
        if (y > -3 && y < 3) {
            //message
            validateMessage.innerHTML = "<object data=\"../web_access_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div class='validate-message' style='margin-top: 30px;\n" +
                "    margin-left: 8px;\n float: left; '>The parametrs are correct</div>";
            //get data to php
            let data = "?x="+ x + "&y=" + y + "&r=" + r + "&clean=false";
            let xhr = new XMLHttpRequest();
            xhr.open("GET", "index.php" + data, true);
            console.log(data);
            xhr.send();
            //add data in .answer_table
            xhr.onload = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        validateMessage.innerHTML = "<object data=\"../web1_cycle_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div class='validate-message' style='margin-top: 30px;\n" +
                            "    margin-left: 8px;\n float: left; '>Waiting for the xhrer response</div>";
                        document.querySelector(".answer_table").innerHTML = tableHeader + xhr.response;
                        if (regexAns.exec(xhr.response)[0] === "true") {
                            validateMessage.innerHTML = "<object data=\"../web_access_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div class='validate-message' style='margin-top: 30px;\n" +
                                "    margin-left: 8px;\n float: left; '>HIT</div>";
                        } else {
                            validateMessage.innerHTML = "<object data=\"../web1_err_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div class='validate-message' style='margin-top: 30px;\n" +
                                "    margin-left: 8px;\n float: left; '>MISS</div>";
                        }
                    }
                }
            }

        } else {
            validateMessage.innerHTML = "<object data=\"../web1_err_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div style='margin-top: 30px;\n" +
                "    margin-left: 8px;\n float: left'>Y must be in range from -3 to 3</div>";
        }
    } else {
        validateMessage.innerHTML = "<object data=\"../web1_err_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div style='margin-top: 30px;\n" +
            "    margin-left: 8px;\n float: left'>Not all the parameters are correct</div>";
    }
    console.log(x + "; ", y + "; ", r + ";")
    return false;
}
