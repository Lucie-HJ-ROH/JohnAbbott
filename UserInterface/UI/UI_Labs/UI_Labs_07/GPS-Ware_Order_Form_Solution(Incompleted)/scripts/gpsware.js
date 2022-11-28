// JavaScript source code
// gpsware.js 

// Script Date: August 2022


/* Function list
1. startup function - displays the current date
2. today function - returns the current date
3. calculatePrice - calculates the subtotal of
     products and quantity
4. calculateShipping(shipOption) - calculates the shipping value
5. calculateTotal - calculates the total of placed order
6. validateForm - validates user data entry
*/

/**
 * displays the current date
 */
function startup() {
    // display the current date in the txtDateNow textbox
    // SYNTAX: object_name.property_name = expression
    // alert("I'm here");
    document.getElementById('txtDateNow').value = today();
} // end function startup


/**
 * returns the current date
 */
function today() {
    // create an instance of the Date object
    let currentDate = new Date();

    // extract from the current date variable the date, month, and year
    let thisDate = currentDate.getDate();
    let thisMonth = currentDate.getMonth() + 1;
    let thisYear = currentDate.getFullYear();

    // return the current date in the format mm/dd/yyyy
    let todayDate = thisMonth + '/' + thisDate + '/' + thisYear;
    return todayDate;
} // end function today


/**
 * calculates the subtotal of products and quantity
 */
function calculatePrice() {
    // declare product variables
    let product = document.getElementById('ddlProduct');
    let pIndex = product.selectedIndex;
    // alert(pIndex);

    // return the product value of the selected pIndex
    let productPrice = product.options[pIndex].value;
    // alert(productPrice);

    // declare quantity variables 
    let quantity = document.getElementById('ddlQuantity');
    let qIndex = quantity.selectedIndex;

    // return the quantity ordered of the selected product
    let quantityOrdered = quantity.options[qIndex].value;
    // alert(qIndex);

    // display the calculated price in the txtPrice textfiel
    document.getElementById('txtPrice').value =
        (productPrice * quantityOrdered).toFixed(2);

    // call function calculateTotal
    calculateTotal();

} // end function calculatePrice

/**
 * calculates the shipping value
 * @param {*} shipOption 
 */
function calculateShipping(shipOption) {
    // represent a the text box txtShippingPrice in JS
    document.getElementById('txtShipPrice').value = shipOption.value;

    // call function calculateTotal
    calculateTotal();

} // end function calculateShipping

/**
 *  calculates the total of placed order
 */
function calculateTotal() {
    // declare variables 
    let priceValue = window.parseFloat(document.getElementById('txtPrice').value);
    let shipValue = parseFloat(document.getElementById('txtShipPrice').value);

    // display the subtotal of the order in the txtSubtotal textfield
    document.getElementById('txtSubtotal').value = (priceValue + shipValue).toFixed(2);

    // declare the tax rate 
    const TAX_RATE = 0.05;

    // calculate the taxValue
    let taxValue = (priceValue + shipValue) * TAX_RATE;

    // display the tax value in the txtTax field
    document.getElementById('txtTax').value = taxValue.toFixed(2);

    // display the grand total of the order placed in the txtTotal field
    document.getElementById('txtTotal').value = (priceValue + shipValue + taxValue).toFixed(2);
} // end function calculateTotal

/**
 * validates user data entry
 */
function validateForm() {   
    // declare variables reprensting html elements
    let slectedProduct = document.getElementById('ddlProduct');
    let selectedQuantity = document.getElementById('ddlQuantity');
    let selectedShipping = document.getElementById('txtShipPrice');

    // validate Product
    if (slectedProduct.selectedIndex === 0) {
        window.alert('You must select a GPS-Ware product.');
        slectedProduct.focus();
        return false;
    } else if(selectedQuantity.selectedIndex === 0) {
        window.alert('You must select a quantity to order.')
        selectedQuantity.focus();
        return false;
    } else if(selectedShipping.value === "0.00") {
        window.alert('You must select a shipping option');
        selectedShipping.focus();
        return false;
    } else {
        return true;
    }

} // end function validateForm