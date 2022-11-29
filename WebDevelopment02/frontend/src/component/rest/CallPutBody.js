export function CallPutBody() {
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