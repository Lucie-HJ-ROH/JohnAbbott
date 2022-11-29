import React from "react";
import {Link} from "react-router-dom";
import HomeButton from "../component/HomeButton";
import NavButton from "../component/NavButton";

function Header() {
    return (
        <div>
            <div>
                <HomeButton/>
                <NavButton to="/" label="Home" />
            </div>
            <div>
                <Link to="/">Home</Link>
                <Link to="/about">About</Link>
                <Link to="/contact">Contact</Link>
            </div>
        </div>
    );
}

export default Header;