var customerOrder = {
    "CustomerName": "John",
    "phoneNumber": "123",
    "items": ["cellphone","laptop"]
};

console.log(customerOrder.CustomerName);
console.log(customerOrder.phoneNumber);
console.log(customerOrder.items[0]);

var jsonString = JSON.stringify(customerOrder);

console.log(jsonString);

var customerOrderDeserializer = JSON.parse(jsonString);
console.log(customerOrderDeserializer);