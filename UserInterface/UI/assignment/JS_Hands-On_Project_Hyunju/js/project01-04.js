/*  JavaScript 
    Hands-On Project 1-4

    Author: Hyunju Roh
    Date:   2022.08.01

    Filename: project01-02.js
*/

//define variables for home and work addresses

let homeStreet, homeCity, homeState, homeCode;
let workStreet, workCity, workState, workCode;

homeStreet = '1 Main St.';
homeCity  = 'Sicilia';
homeState  = 'MA';
homeCode = '02103';

workStreet = '15 Oak Ln.';
workCity = 'Central City';
workState = 'MA';
workCode = '02104';

function homeClick() {
    document.getElementById("street").value = homeStreet;
    document.getElementById("city").value = homeCity;
    document.getElementById("state").value = homeState;
    document.getElementById("code").value = homeCode;
}

function workClick() {
    document.getElementById("street").value = workStreet;
    document.getElementById("city").value = workCity;
    document.getElementById("state").value = workState;
    document.getElementById("code").value = workCode;
}
