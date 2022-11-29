import React, {useRef} from 'react';

const LoginForm = () => {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const handleSubmit = (event) => {
        event.preventDefault(); // prevent page reload
        // to fill in based on callPostBody
    }
    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="username">Username</label>
            <input id="username" type="text" ref={usernameRef} required/>
            <label htmlFor="password">Password</label>
            <input id="password" type="password" ref={passwordRef} required/>
            <button type="submit">Login</button>
        </form>
    );
}

export default LoginForm;
