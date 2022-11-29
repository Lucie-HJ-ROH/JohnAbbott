import React, {useRef} from 'react';
import {LoggedInContext} from "../App";
import CallRegister from "./rest/CallRegister";
import './Container.css'


const Register = () => {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const [isLoggedIn, setIsLoggedIn] = React.useContext(LoggedInContext);
    const handleSubmit = (event) => {
        event.preventDefault(); // prevent page reload
        // to fill in based on callPostBody
        const username = usernameRef.current.value;
        const password = passwordRef.current.value;
        fetch("http://localhost:3001/users/register", {
            method: "POST",
            body: JSON.stringify({
                username: username,
                password: password,
            }),
            headers: {
                "Content-type": "application/json;charset=UTF-8",
            }, })
            .then((data) => data.json())
            .then((json) => alert(JSON.stringify(json)));
    }
    return (
        <div className='container'>
            <h2>If you don't have an account, Please join us.</h2>
            <form onSubmit={handleSubmit}>
                <input className='input'  id="username" type="text" ref={usernameRef} placeholder="username" required/>
                <input className='input'  id="password" type="password" ref={passwordRef} placeholder="password" required/>
                <button className='button' type="submit">Register</button>
            </form>
        </div>
    );
}

export default Register;
