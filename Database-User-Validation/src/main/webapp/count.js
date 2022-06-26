const startingminutes = 1;
let time = startingminutes * 60;

setInterval(updateCountdown,1000);

function updateCountdown(){
    const minutes = Math.floor(time/60);
    let seconds = time % 60;

    seconds = seconds < 0 ? window.location.href="hospital_email.jsp" : seconds;

    document.getElementById("countdown").innerHTML = `${minutes}: ${seconds}`;
    time--;
    
}
