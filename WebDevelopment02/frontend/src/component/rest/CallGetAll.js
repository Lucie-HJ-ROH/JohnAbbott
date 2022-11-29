/* Function that will make an API call to get all users, and then pop-up an alert with the results. */
export function CallGetAll() {
    fetch("http://localhost:3001/users", {method: "GET"})
        .then((data) => data.json())
        .then((json) => alert(JSON.stringify(json)));
}