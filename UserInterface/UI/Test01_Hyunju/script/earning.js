function salaryCalculator() {
    const baseSalary = 200;
    const COMMISSION = 0.09;



    let salary = total() * COMMISSION + baseSalary;
    checkForNull();
    checkForNumber();
    document.getElementById("result").innerHTML =
        " $" +  salary.toFixed(2);

    document.getElementById("total").innerHTML = " (9% of $" + total().toFixed(2)+")";
    document.getElementById("commission").innerHTML = " $" + (total() * COMMISSION).toFixed(2);


}


function total(){

    let total = calculateSubTotal1() +calculateSubTotal2() +calculateSubTotal3() +calculateSubTotal4();

    return total;

}

function calculateSubTotal1(){
    let subTotalItem1;
    const ITEM1VALUE = 239.99;
    let item1Quantity =  document.getElementById("item1").value;
    subTotalItem1 = item1Quantity * ITEM1VALUE;
    document.getElementById("subTotalItem1").innerHTML = "$" +subTotalItem1;
    return subTotalItem1;
}

function calculateSubTotal2(){
    let subTotalItem2;
    const ITEM2VALUE = 129.75;

    let item2Quantity = document.getElementById("item2").value;


    subTotalItem2 = item2Quantity * ITEM2VALUE;
    document.getElementById("subTotalItem2").innerHTML = "$" +subTotalItem2;
    return subTotalItem2;
}

function calculateSubTotal3(){
    let subTotalItem3;
    const ITEM3VALUE = 99.95;

    let item3Quantity =  document.getElementById("item3").value;
    subTotalItem3 = item3Quantity * ITEM3VALUE;
    document.getElementById("subTotalItem3").innerHTML = "$" +subTotalItem3;
    return subTotalItem3;
}

function calculateSubTotal4(){
    let subTotalItem4;
    const ITEM4VALUE = 350.89;
    let item4Quantity =  document.getElementById("item4").value;
    subTotalItem4 = item4Quantity * ITEM4VALUE;
    document.getElementById("subTotalItem4").innerHTML = "$" +subTotalItem4;
    return subTotalItem4;
}
// check validation for input items
function checkForNumber() {
    let item1 = document.getElementById("item1");
    let item2 = document.getElementById("item2");
    let item3 = document.getElementById("item3");
    let item4 = document.getElementById("item4");

    if (isNaN(item1.value)) {
        alert("Please enter the number.(item1)");
        item1.focus();
        item1.style.background = "yellow";
        return false;
    } else if (isNaN(item2.value)) {
        alert("Please enter the number.(item2)");
        item2.focus();
        item2.style.background = "yellow";
        return false;
    } else if (isNaN(item3.value)) {
        alert("Please enter the number.(item3)");
        item3.focus();
        item3.style.background = "yellow";
        return false;
    } else if (isNaN(item4.value)) {
        alert("Please enter the number.(item4)");
        item4.focus();
        item4.style.background = "yellow";
        return false;
    } else {
        item1.style.background = "white";
        item2.style.background = "white";
        item3.style.background = "white";
        item4.style.background = "white";
    }
}

// when there is no number , replace to 0
function checkForNull() {
    let item1 = document.getElementById("item1");
    let item2 = document.getElementById("item2");
    let item3 = document.getElementById("item3");
    let item4 = document.getElementById("item4");

    if (item1.value.length === 0) {
        document.getElementById("item1").value = '0';
    }
    if (item2.value.length === 0) {
        document.getElementById("item2").value = '0';
    }
    if (item3.value.length === 0) {
        document.getElementById("item3").value = '0';
    }
    if (item4.value.length === 0) {
        document.getElementById("item4").value = '0';
    }

}