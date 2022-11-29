

export function CallGetQuery() {
    fetch("http://localhost:3001/user?username=lucie",
        { method: "GET" })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));

}
