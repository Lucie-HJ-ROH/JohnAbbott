export function CallPatchBodyUsername() {
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