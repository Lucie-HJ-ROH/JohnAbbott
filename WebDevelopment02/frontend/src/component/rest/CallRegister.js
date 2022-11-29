async function CallRegister() {
    fetch("http://localhost:3001/users/register", {
        method: "POST",
        body: JSON.stringify({
            username: "usertest",
            password: "usertestpw",
        }),
        headers: {
            "Content-type": "application/json;charset=UTF-8",
        }, })
        .then((data) => data.json())
        .then((json) => alert(JSON.stringify(json)));
}
export default CallRegister;