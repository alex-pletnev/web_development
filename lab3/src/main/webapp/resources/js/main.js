let plotR;

function getXYR(event) {
    let r = document.getElementById("j_idt11:value_R_hinput").value;
    let xc = ((event.offsetX - 200) / 150) * r;
    let yc = ((200 - event.offsetY) / 150) * r;

    let testX = (xc / r) * 150 + 200;
    let testY = 200 - (yc / r)  * 150;

    console.log(xc, yc, testX, testY)
}

function changingPlot() {
    let r = parseFloat(document.getElementById('j_idt11:value_R_hinput').value) * 40;

    $('#triangle').attr('points', (200 + r / 2) + ",200 200,200 200," + (200 - r / 2) );
    $('#rectangle').attr('points', "200,200 200," + (200 + r / 2) + " " + (200 - r) + "," + (200 + r / 2) + " " + (200 - r) + ",200");
    $('#circle').attr('d', "M" + (200 - r / 2) + ",200 A" + r / 2 + "," + r / 2 + " 90 0,1 200," + (200 - r / 2) + " L 200,200 Z");
}

function isValid(x, y, r){
    
    return (x >= -5 && x <= 5 && y >= -3 && y <= 3 && r >= 2 && r <= 5);
}


function makeDot(x, y, r){
    let svgns = "http://www.w3.org/2000/svg",
        container = document.getElementById( 'plot' );
    let circle = document.createElementNS(svgns, 'circle');
    circle.setAttributeNS(null, 'class', 'shot' );
    circle.setAttributeNS(null, 'cx', 200 + 40 * x);
    circle.setAttributeNS(null, 'cy', 200 - 40 * y);
    circle.setAttributeNS(null, 'r', 4);
    circle.setAttributeNS(null, 'style', 'fill: ' + isHit(x, y, r) + ';stroke-width: 0;' );
    container.appendChild(circle);
}

function isHit(x, y, r){
    if (isCircleZone(x, y, r) || isRectangleZone(x, y ,r) || isTriangleZone(x, y ,r)) {
        return "#008800aa";
    } else return "#880000aa";
}

function isRectangleZone(x, y, r){
    return (x<=0) && (y<=0) && (x>=(-1)*r) && (y>=(-1)*r/2);
}
function isCircleZone(x, y, r){
    return (x*x + y*y <= (r/2)*(r/2) && (x<=0) && (y>=0));
}
function isTriangleZone(x, y, r){
    if (x >=0 && y >= 0) {
        let x1 = r/2;
        let x2 = 0;
        let x3 = 0;
        let y1 = 0;
        let y2 = r/2;
        let y3 = 0;
        let p1 = (x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y);
        let p2 = (x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y);
        let p3 = (x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y);
        if (p1 === 0 || p2 === 0 || p3 === 0) {
            return true;
        }
        if (p1 > 0 && p2 > 0 && p3 > 0) {
            return true;
        } else return p1 < 0 && p2 < 0 && p3 < 0;
    } else return false;

}

