import React from 'react';

function DbData2() {
    return (
        <>
            <button onClick={callGetQuery}>Read-Single</button>
        </>)
}

export default DbData2;

function callGetQuery() {
    fetch("http://localhost:3001/user?username=lucie",
        { method: "GET" })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));

}