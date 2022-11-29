import React from 'react';

function DbData3() {
    return (
        <>
            <button onClick={callGetParams}>Read-Single2</button>
        </>)
}

export default DbData3;

function callGetParams() {
    fetch("http://localhost:3001/users/lucie",
        {method: "GET"})
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));

}