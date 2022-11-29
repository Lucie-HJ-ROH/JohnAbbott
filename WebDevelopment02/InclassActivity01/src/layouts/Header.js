import React, {useState} from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars,  faTimes } from "@fortawesome/free-solid-svg-icons";
import styled from "styled-components";
import {faApple} from "@fortawesome/free-brands-svg-icons";
import {Route, Routes, useNavigate} from "react-router-dom";
import Footer from "./Footer";
import NavButton from "../components/NavButton";

const HeaderStyle = styled.div`
  max-width: 1280px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: white;
  background-color: black;

  .logo {
    margin: 0 1rem;
    font-size: 2rem;
  }

  .header__menulist {
    list-style: none;
    display: flex;
  }

  .header__left {
    display: flex;
  }

  .header__right {
    list-style: none;
    display: flex;
  }

  .header__right div {
    margin: 0 1rem;
  }

  li {
    padding: 0 1rem;
  }

  .toggle {
    display: none;
    font-size: 1.5rem;
    padding: 1rem 1rem;
  }


  @media screen and (max-width: 768px) {
    flex-wrap: wrap;
    
    .header__menulist {
      display: ${(props) => (props.isToggled ? "flex" : "none")};
      flex-direction: column;
      width: 100%;
      background-color: black;
    }

    .header__menulist li,
    .header__right li {
      margin: 1rem 0;
      padding: 0;
    }

    .toggle {
      display: block;
    }

    .user {
      display: block;
    }
  }
`;
function Header(){
    const [isToggled, setIsToggled] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = (event) => {
        try {
            navigate("/", {replace: true});
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <HeaderStyle isToggled={isToggled} >
            {/* hamburger button(bar) */}
            <div
                className="toggle"
                onClick={() => {
                    setIsToggled(!isToggled);
                }}
            >
                <FontAwesomeIcon icon={!isToggled ? faBars : faTimes} />
            </div>

            {/* Apple logo svg using fontawesome */}
            <div className="logo">
                <FontAwesomeIcon icon={faApple} onClick={handleSubmit} />
                {/*<FontAwesomeIcon icon="fa-solid fa-house-blank" />*/}
            </div>


            {/* menu list */}
            <ul className="header__menulist">
                <li>
                    <NavButton to="/" label="Home" />
                </li>
                <li>
                    <NavButton to="/About" label="About" />
                </li>
                <li>
                    <NavButton to="/Content" label="Content" />
                </li>
                <li>
                    <NavButton to="/Contact" label="Contact" />
                </li>
                <li>
                    <NavButton to="/Details" label="Details" />
                </li>
            </ul>

        </HeaderStyle>
    );

}

export default Header;