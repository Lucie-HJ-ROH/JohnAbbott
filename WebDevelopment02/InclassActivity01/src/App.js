import React, {useState} from "react";
import {Route, Routes} from "react-router-dom";
import MainLayout from "./layouts/MainLayout";
import Home from "./components/Home";
import About from "./components/About";
import Contact from "./components/Contact";
import Content from "./components/Content";
import Details from "./components/Details";


function App() {

    return (
        <>
            <>
                <Routes>
                    <Route path="/" element={<MainLayout/>}>
                        <Route index element={<Home/>}/>
                        <Route path="about" element={<About/>}/>
                        <Route path="contact" element={<Contact/>}/>
                        <Route path="Content" element={<Content/>}/>
                        <Route path="Details" element={<Details/>}/>
                        <Route path="*" element={<p>Invalid URL</p>}/>
                    </Route>
                </Routes>
            </>
        </>
    );
}

export default App;