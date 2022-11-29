import React from 'react';

function DbData5() {
    return (
        <>
            <button onClick={callPutBody}>Update(full)</button>
        </>)
}

export default DbData5;

function callPutBody() {
    fetch("http://localhost:3001/users", {
        method: "PUT",
        body: JSON.stringify({
            username: "lucie",
            password: "12345"
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8",
        },
    })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));
}