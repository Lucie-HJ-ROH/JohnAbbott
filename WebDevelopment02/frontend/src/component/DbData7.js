import React from 'react';

function DbData7() {
    return (
        <>
            <button onClick={callDeleteParams}>Delete</button>
        </>)
}

export default DbData7;

function callDeleteParams() {
    fetch("http://localhost:3001/users/lucie",
        { method: "DELETE" })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));
}