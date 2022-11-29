let x = NaN;
let y = NaN;
let r = NaN;

let validateMessage = document.querySelector('.validate-message');


function setValueR(a_r) {
    r = String(a_r);
    let path = "url(\"./res/web2R"+r+"_plot.svg\")";
    document.getElementById("plot").style.background = path;
    console.log(path)
}

function makeDot() {
    if (isNaN(r)) {
        validateMessage.innerHTML = "<object data=\"./res/web1_err_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div class='validate-message' style='margin-top: 30px;\n" +
            "    margin-left: 8px;\n float: left; '>Please Set a value for R</div>";
        return;
    }
    let page_x = event.clientX;
    let page_y = event.clientY;
    let plot_rect = document.getElementById("plot").getBoundingClientRect();
    let plot_x = page_x-plot_rect.left;
    let plot_y = page_y-plot_rect.top;

    if (plot_x <= 10 && plot_y <= 10) {
        window.location = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        return;
    }

    x = (plot_x-200)/40;
    y = -(plot_y-200)/40;
    validateMainForm();
}
 function pos(){
    let target = document.getElementById("plot").getBoundingClientRect();
    let x_live = (event.clientX-target.left-200)/40;
    let y_live = -(event.clientY - target.top-200)/40;
    document.getElementById('x-live').innerHTML = x_live.toFixed(3);
    document.getElementById('y-live').innerHTML = y_live.toFixed(3);
}

document.getElementById("plot").addEventListener('mousemove', pos, false);

function clearAnsTable() {
    let xhr = new XMLHttpRequest();
    let data = "?clean=true";
    xhr.open("GET", "./controller" + data, true);
    xhr.send();
    xhr.onload = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                document.getElementById("at").innerHTML = "<tr class=\"answer_table\">\n" +
                    "                    <th class=\"answer_table\">X</th>\n" +
                    "                    <th class=\"answer_table\">Y</th>\n" +
                    "                    <th class=\"answer_table\">R</th>\n" +
                    "                    <th class=\"answer_table\">ТЕКУЩЕЕ ВРЕМЯ (UTC)</th>\n" +
                    "                    <th class=\"answer_table\">РЕЗУЛЬТАТ ПОПАДАНИЯ</th>\n" +
                    "                    <th class=\"answer_table\">ВРЕМЯ ИСПОЛНЕНИЯ</th>\n" +
                    "                </tr>" + xhr.response;
            }
        }
    }
}
function parseData() {
    let str_x = document.getElementById("input_x").value.replace(",", ".")
    x = parseFloat(str_x);
    y = parseFloat(document.getElementById("input_y").value);
    validateMainForm();
}

function validateMainForm() {
    event.preventDefault();
    console.log(x, y, r);
    if (!isNaN(x) && !isNaN(y) && !isNaN(r)) {
        if (x > -3 && x < 5) {
            //message
            validateMessage.innerHTML = "<object data=\"./res/web_access_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div class='validate-message' style='margin-top: 30px;\n" +
                 "    margin-left: 8px;\n float: left; '>The parametrs are correct</div>";

            let data = "?x="+ x + "&y=" + y + "&r=" + r + "&clean=false";
            let xhr = new XMLHttpRequest();
            xhr.open("GET", document.URL + "controller" + data, true);
            console.log(data);
            xhr.send();
            //add data in .answer_table
            xhr.onload = () => {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        window.location = document.URL + 'result.jsp';
                    }
                }
            }

        } else {
            validateMessage.innerHTML = "<object data=\"./res/web1_err_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div style='margin-top: 30px;\n" +
                 "    margin-left: 8px;\n float: left'>X must be in range from -3 to 5</div>";
        }
    } else {
        validateMessage.innerHTML = "<object data=\"./res/web1_err_icon.svg\" width=\"100px\" height=\"100px\" style='float: left'></object> <div style='margin-top: 30px;\n" +
             "    margin-left: 8px;\n float: left'>Not all the parameters are correct</div>";
    }
    console.log(x + "; ", y + "; ", r + ";");
    return false;
}
