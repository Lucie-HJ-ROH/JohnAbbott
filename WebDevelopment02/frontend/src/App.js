import logo from './logo.svg';
import './App.css';
import Home from "./component/Home";
import Layout from "./component/layout/Layout";
import {Route, Routes} from "react-router-dom";
import About from "./component/About";

function Contact() {
    return null;
}

function App() {
  return (
    <div className="App">
          <Routes>
              <Route path="/" element={<Layout/>}>
                  <Route index element={<Home/>}/>
                  <Route path="about" element={<About/>}/>
                  <Route path="*" element={<p>Invalid URL</p>}/>
              </Route>
          </Routes>
    </div>
  );
}

export default App;
