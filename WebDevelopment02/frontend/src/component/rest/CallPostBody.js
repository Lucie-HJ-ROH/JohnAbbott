import React from 'react';

export function CallPostBody() {
    fetch("http://localhost:3001/users", {
        method: "POST",
        body: JSON.stringify({
            username: "lucie",
            password: "luciePassword",
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8",
        },
    })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));
}