import React from "react";
import {Link, NavLink} from "react-router-dom";
import HomeButton from "../component/HomeButton";
import NavButton from "../component/NavButton";
import "../component/Header.css";
import {Contact} from "../component/Contact";
import ContactButton from "../component/ContactButton";

function Header() {
    const buttonStyle = {
        backgroundColor: "green", border: "none",
        color: "white",
        padding: "15px 32px", textAlign: "center", textDecoration: "none", display: "inline-block", fontSize: "16px",
    };
    return (
        <div>
            {/*<NavLink>*/}
            {/*    <button style={buttonStyle}> <p>Home</p>*/}
            {/*    </button>*/}
            {/*</NavLink>*/}

            <div>
                <HomeButton/>
                <ContactButton/>
                {/*<NavButton to="/" label="Home"/>*/}
            </div>
            <NavLink
                style={({isActive}) =>
                    isActive ? {color: "orange"} : {color: "blue"}
                }
                to="/"> Home
            </NavLink>

            <NavLink
                className={({isActive}) =>
                    isActive ? "link-active" : "link-inactive"}
                to="/about"> About
            </NavLink>
            <div>
                <Link to="/">Home</Link>
                <Link to="/about">About</Link>
                <Link to="/contact">Contact</Link>
            </div>
        </div>
    );
}

export default Header;