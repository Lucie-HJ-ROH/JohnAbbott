import React, {useRef} from 'react';
import './Button.css'
import {LoggedInContext} from "../App";
import styled from "styled-components";


const Container = styled.div`
  margin-top: 100px;
  padding: 20px;
`;

const Input = styled.input`
  position: relative;
  overflow: hidden;
  width: 100%;
  height: 40px;
  margin: 0 0 8px;
  padding: 5px 39px 5px 11px;
  border: solid 1px #dadada;
  background: #fff;
  box-sizing: border-box;
`;


const Login = () => {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const [isLoggedIn, setIsLoggedIn] = React.useContext(LoggedInContext);
    const handleSubmit = (event) => {
        event.preventDefault(); // prevent page reload
        const username = usernameRef.current.value;
        const password = passwordRef.current.value;
        // to fill in based on callPostBody
        fetch("http://localhost:3001/users/login", {
            method: "POST",
            body: JSON.stringify({
                username: username,
                password: password,
            }),
            headers: {
                "Content-type": "application/json;charset=UTF-8",
            },
        })
            .then((data) => data.json())
            .then((json) => {
                alert(JSON.stringify(json));
                json.success ? setIsLoggedIn(true) : setIsLoggedIn(false);
            });
    }
    return (
        <Container>
            {isLoggedIn ? <div>
               <h2>Welcome!</h2>
                </div> :
                <div>
                <h2>Please Login </h2>
                    <form onSubmit={handleSubmit}>
                        <input className='input' id="username" type="text" ref={usernameRef} placeholder="username" required/>
                        <input className='input'  id="password" type="password" ref={passwordRef} placeholder="password" required/>
                        <button className='button' type="submit">Login</button>
                    </form>
                </div>}

        </Container>

    );
}

export default Login;
