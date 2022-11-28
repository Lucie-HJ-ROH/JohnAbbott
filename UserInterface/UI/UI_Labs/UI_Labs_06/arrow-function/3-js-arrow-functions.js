// devide num1 / num2
const devide = (num1, num2) => {
    return num1 / num2;
}

// return the square of a number 
const  square = num1 => { return num1 * num1};


// All these functions do the same thing
const isEvent1 = function(num) { // regular function expression
    return num % 2 === 0;
}

const isEvent2 = (num) => { // arrow function with parentheses around param
    return num % 2 === 0;
}

const isEvent3 = num => { // arrow function with no parentheses around param
    return num % 2 === 0;
}

// implicit return: arrow function with no parantheses around param
const isEven4 = num => { num % 2 === 0;}


const isEven5 = num => num % 2 === 0;