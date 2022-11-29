/*    JavaScript 
      Project 02-04

      Application to calculate the cost of a restaurant order plus tax
      Author: Hyunju Roh
      Date:   2022.08.02

      Filename: project02-04.js
 */
 




// Function to display a numeric value as a text string in the format $##.## 
 function formatCurrency(value) {
    return "$" + value.toFixed(2);
 }

 function calcTotal()
{
    let cost, tax, totalCost;
    cost = 0;
    tax = 0;
    totalCost = 0;

    let buyChicken, buyHalibut, buyBurger, buySalmon , buySalad;
    buyChicken = document.getElementById("chicken").checked;
    buyHalibut = document.getElementById("halibut").checked;
    buyBurger = document.getElementById("burger").checked;
    buySalmon = document.getElementById("salmon").checked;
    buySalad = document.getElementById("salad").checked;

    const CHICKEN_PRICE = 10.95;
    const HALIBUT_PRICE = 13.95;
    const BURGER_PRICE = 9.95;
    const SALMON_PRICE = 18.95;
    const SALAD_PRICE = 7.95;
    const SALES_TAX = 0.07;

    cost = (buyChicken == true) ? cost+CHICKEN_PRICE : cost+0;
    cost = (buyHalibut == true) ? cost+HALIBUT_PRICE : cost+0;
    cost = (buyBurger == true) ? cost+BURGER_PRICE : cost+0;
    cost = (buySalmon == true) ? cost+SALMON_PRICE : cost+0;
    cost = (buySalad == true) ? cost+SALAD_PRICE : cost+0;

    tax = cost * SALES_TAX;
    totalCost = tax + cost;

    document.getElementById("foodTotal").innerHTML = formatCurrency(cost);
    document.getElementById("foodTax").innerHTML = formatCurrency(tax);
    document.getElementById("totalBill").innerHTML = formatCurrency(totalCost);

}