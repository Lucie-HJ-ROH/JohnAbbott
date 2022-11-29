/*    JavaScript 
      Project 02-01

      Celsius <-> Farenheit Coverter
      Author: Hyunju Roh
      Date:   2022.08.02

      Filename: project02-01.js
 */


// Celsius 5 (Fahrenheit 2 32)/1.8
// Fahrenheit 5 Celsius 3 1.8 1 32

let degree;

function CelsiusToFahrenheit(degree) {
    degree = degree * 1.8 + 32;
    return degree;
}

function FahrenheitToCelsius(degree) {
    degree = (degree - 32) / 1.8;
    return degree;
}