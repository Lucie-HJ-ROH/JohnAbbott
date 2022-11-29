import React from "react";
import Main from "./component/Main";
import Home from "./component/Home";
import {BrowserRouter, Route, Routes} from 'react-router-dom'


import {About} from "./component/About";
import {Contact} from "./component/Contact";
import Header from "./layouts/Header";

function App() {
    return (
        <>
            <Header/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/about" element={<About/>}/>
                <Route path="/contact" element={<Contact/>}/>
            </Routes>
        </>

    );
}

export default App;
