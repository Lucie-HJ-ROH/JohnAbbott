export function CallGetBody() {
    fetch("http://localhost:3001/users/get",
        {
            method: "POST",
            body: JSON.stringify({
                username:"lucie",
            }),
            headers: {
                "Content-type":
                    "application/json;charset=UTF-8",
            }
            ,
        })
        .then((data) => data.json())
        .then((json) =>
            alert(JSON.stringify(json)));}