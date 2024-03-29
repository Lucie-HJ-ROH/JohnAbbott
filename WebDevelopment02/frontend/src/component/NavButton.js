import {NavLink, useMatch, useResolvedPath} from "react-router-dom";

function NavButton(props) {
    let resolved = useResolvedPath(props.to);
    let match = useMatch({path: resolved.pathname, end: true});
    const buttonStyle = {
        backgroundColor: "black",
        border         : "none",
        color          : "white",
        padding        : "5px 15px",
        textAlign      : "center",
        textDecoration : "none",
        display        : "inline-block",
        fontSize       : "16px",
    };
    const activeButtonStyle = {
        backgroundColor: "black",
        border         : "none",
        color          : "yellow" ,
        padding        : "5px 32px",
        textAlign      : "center",
        textDecoration : "none",
        display        : "inline-block",
        fontSize       : "16px",
    };
    return (
        <NavLink to={props.to}>
            <button style={match ? activeButtonStyle : buttonStyle}>
                <p>{props.label}</p>
            </button>
        </NavLink>
    );
}

export default NavButton;