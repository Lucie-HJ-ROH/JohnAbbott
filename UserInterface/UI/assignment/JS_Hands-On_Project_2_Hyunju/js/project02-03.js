/*    JavaScript 
      Project 02-03

      Application to return the shape of a clicked object
      Author: 
      Date:   

      Filename: project02-03.js
 */


// document.getElementById("square").onmouseover = function (){
//     document.getElementById("feedback").innerHTML = 'You ‘re hovering over the square';
// }

window.onload=function(){
    let square = document.getElementById("square");
    square.addEventListener("mouseover",function(){ document.getElementById("feedback").innerHTML = 'You‘re hovering over the square';});
    square.addEventListener("mouseout",function(){ document.getElementById("feedback").innerHTML = '';});
    let triangle = document.getElementById("triangle");
    triangle.addEventListener("mouseover",function(){ document.getElementById("feedback").innerHTML = 'You‘re hovering over the triangle';});
    triangle.addEventListener("mouseout",function(){ document.getElementById("feedback").innerHTML = '';});
    let circle = document.getElementById("circle");
    circle.addEventListener("mouseover",function(){ document.getElementById("feedback").innerHTML = 'You‘re hovering over the circle';});
    circle.addEventListener("mouseout",function(){ document.getElementById("feedback").innerHTML = '';});
}
