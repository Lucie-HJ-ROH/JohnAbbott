import React from "react";
import './App.css';
import Home from "./component/Home";
import Layout from "./component/layout/Layout";
import {Route, Routes} from "react-router-dom";
import About from "./component/About";
import {useState} from "react";

function Contact() {
    return null;
}

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const loggedInValueToProvide = [isLoggedIn, setIsLoggedIn]; // So we can pass down both value and setter

    return (
        <LoggedInContext.Provider value={loggedInValueToProvide}>
            {/*<div className="App">*/}
            {/*    <Routes>*/}
            {/*        <Route path="/" element={<Layout/>}>*/}
            {/*            <Route index element={<Home/>}/>*/}
            {/*            <Route path="about" element={<About/>}/>*/}
            {/*            <Route path="*" element={<p>Invalid URL</p>}/>*/}
            {/*        </Route>*/}
            {/*    </Routes>*/}
            {/*</div>*/}
            <Home/>
        </LoggedInContext.Provider>
    );
}

export default App;

// eslint-disable-next-line no-undef
export const LoggedInContext = React.createContext({
    isLoggedIn: false,
    setIsLoggedIn: () => {
    },
});
