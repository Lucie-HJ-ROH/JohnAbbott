import React from 'react';

import './Button.css'

const LogoutButton = (props) => {
    return (
        <button className='button' style={{backgroundColor: 'black'}} onClick={props.onClick}>
            Logout
        </button>
    );
};

export default LogoutButton;