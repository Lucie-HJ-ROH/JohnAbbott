import React from "react";
import Toggle from "./Toggle";

function UserActions(props) {
    const handleOnClick = () =>{
        props.setColor(Toggle(props.color));
        props.setCount(props.count + 1)
    }
    return (
        <button onClick={handleOnClick}>
            Click me React
        </button>
    )
}

export default UserActions