
import React, {useContext, useState} from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars,  faTimes } from "@fortawesome/free-solid-svg-icons";
import styled from "styled-components";
import {faApple} from "@fortawesome/free-brands-svg-icons";
import {Route, Routes, useNavigate} from "react-router-dom";
import Footer from "./Footer";
import NavButton from "../NavButton";
import { LoggedInContext } from "../../App";
import {Button} from "react-bootstrap";
import LogoutButton from "../LogoutButton";


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

function HomeButton() {
    return (
        <div>
            <Button className='button'>Home</Button>

        </div>
    );
}

function Header(){
    const [isToggled, setIsToggled] = useState(false);
    const navigate = useNavigate();
    const [isLoggedIn, setIsLoggedIn] = useContext(LoggedInContext);


    const logoutHandler = () => {
        setIsLoggedIn(false);
    }

    const handleSubmit = (event) => {
        try {
            navigate("/", {replace: true});
        } catch (error) {
            console.log(error);
        }
    };
    return (

            <div>
                {/*{isLoggedIn ? "Welcome" : "Please login"}*/}
                {isLoggedIn ? <LogoutButton onClick = {logoutHandler}/> : ''}
                <HomeButton/>
            </div>



    );

}

export default Header;