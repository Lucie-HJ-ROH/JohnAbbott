import React from 'react';

function DbData() {
    return (
        <>
            <button onClick={callGetAll}>Get all users</button>
        </>)
}

export default DbData;

/* Function that will make an API call to get all users, and then pop-up an alert with the results. */
function callGetAll() {
    fetch("http://localhost:3001/users", {method: "GET"})
        .then((data) => data.json())
        .then((json) => alert(JSON.stringify(json)));
}

async function registerUserTemp() {
    fetch("http://localhost:3001/users/register", {
        method: "POST",
        body: JSON.stringify({
            username: "lucie",
            password: "12345",
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        }, })
        .then((data) => data.json())
        .then((json) => alert(JSON.stringify(json)));
}