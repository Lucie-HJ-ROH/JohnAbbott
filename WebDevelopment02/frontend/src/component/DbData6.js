import React from 'react';

function DbData6() {
    return (
        <>
            <button onClick={callPatchBodyUsername}>Update(partial)</button>
        </>)
}

export default DbData6;

function callPatchBodyUsername() {
    fetch("http://localhost:3001/users/lucie/password", {
        method: "PATCH",
        body: JSON.stringify({
            password: "12345"
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8",
        }, })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));
}