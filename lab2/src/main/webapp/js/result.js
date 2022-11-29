let ar = document.getElementById('ar');
let reg = RegExp("true|false");

function goToMainPage() {
    window.location.replace('./');
}

function changeDataTable() {

}
function updatePic() {
    let status = reg.exec(ar.innerHTML)[0];
    if (status === "true") {
        document.getElementById('pic').innerHTML = "<img src=\"./res/web2_hit.svg\" width=\"700px\" height=\"700px\" alt=\"img\" style=\"margin: auto auto auto auto\">\n"
    } else {
        document.getElementById('pic').innerHTML = "<img src=\"./res/web2_miss.svg\" width=\"700px\" height=\"700px\" alt=\"img\" style=\"margin: auto auto auto auto\">\n"
    }
}

setTimeout(updatePic, 2000)
const mh = () => anime({
    targets: '.prew',
    translateX: window.innerWidth/2-200,
    duration: 3000,
});


let t = document.querySelector('.answer_table');

mh();