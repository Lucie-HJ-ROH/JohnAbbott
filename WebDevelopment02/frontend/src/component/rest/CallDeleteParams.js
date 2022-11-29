function callDeleteParams() {
    fetch("http://localhost:3001/users/lucie",
        { method: "DELETE" })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));
}