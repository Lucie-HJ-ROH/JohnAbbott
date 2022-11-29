import React from "react";
import Main from "./component/Main";
import Home from "./component/Home";
import {BrowserRouter, Route, Routes} from 'react-router-dom'


import {About} from "./component/About";
import {Contact} from "./component/Contact";
import Header from "./layouts/Header";
import MainLayout from "./layouts/MainLayout";



function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<MainLayout />} >
                    <Route index element={<Home/>}/>
                    <Route path="about" element={<About/>}/>
                    <Route path="contact" element={<Contact/>}/>
                    <Route path="*" element={<p>Invalid URL</p>} />
                </Route>
            </Routes>
        </>

    );
}

export default App;
