
export function CallGetParams() {
    fetch("http://localhost:3001/users/lucie",
        {method: "GET"})
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));
}