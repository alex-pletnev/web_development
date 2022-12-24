
function getXYR(event) {
    let r = document.getElementById("j_idt10:value_R_hinput").value;
    let xc = ((event.offsetX - 200) / 150) * r;
    let yc = ((200 - event.offsetY) / 150) * r;

    let testX = (xc / r) * 150 + 200;
    let testY = 200 - (yc / r)  * 150;

    console.log(xc, yc, testX, testY)
}

function makeDot(x, y, r){
    let svgns = "http://www.w3.org/2000/svg",
        container = document.getElementById( 'plot' );
    let circle = document.createElementNS(svgns, 'circle');
    circle.setAttributeNS(null, 'class', 'shot' );
    circle.setAttributeNS(null, 'cx', (x / r) * 150 + 200);
    circle.setAttributeNS(null, 'cy', 200 - (y / r)  * 150);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: white; stroke-width: 0;' );
    container.appendChild(circle);
}


