document.addEventListener("DOMContentLoaded",function(){
    document.getElementById("main").innerHTML = "Welcome back to JavaScript";
});

document.addEventListener("DOMContentLoaded",function(){
    tick();
    setInterval(tick,1000);
});

function tick(){
    document.getElementById("ticker").innerHTML = new Date().toLocaleTimeString();
}

window.addEventListener("load",function(){
    if(!localStorage.clickCount){
        localStorage.clickCount =0;
    }

    document.getElementById("counter").innerHTML =localStorage.clickCount;
    if(!sessionStorage.welcomeColor){
        sessionStorage.welcomeColor = getComputedStyle(document.getElementById("main")).color;
    }else{
        document.getElementById("main").style.color = sessionStorage.welcomeColor;
    }
});

function changeColorAndCount(){

    localStorage.clickCount = Number(localStorage.clickCount) + 1;
    document.getElementById("counter").innerHTML = localStorage.clickCount;
    if(sessionStorage.welcomeColor == "rgb(0,0,255)"){
    sessionStorage.welcomeColor = "rgb(255,0,0)";
    }else{
        sessionStorage.welcomeColor = "rgb(0,0,255)";
    }
    document.getElementById("main").style.color = sessionStorage.welcomeColor;
}
