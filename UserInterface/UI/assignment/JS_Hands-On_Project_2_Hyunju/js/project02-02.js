/*    JavaScript 
      Project 02-02

      Application to test for completed form
      Author: 
      Date:   

      Filename: project02-02.js
 */



let name;
let email;
let phone;
window.onload=function() {
 let submit =   document.getElementById("submit").addEventListener("click", verifyForm);
}
function verifyForm() {


    name = document.getElementById("name").value;
    email = document.getElementById("email").value;
    phone = document.getElementById("phone").value;


    if (name.length>1 && email.length>1 && phone.length>1) {
        window.alert('Thank you');
    } else {
        window.alert('Please fill in all fields');
    }
}