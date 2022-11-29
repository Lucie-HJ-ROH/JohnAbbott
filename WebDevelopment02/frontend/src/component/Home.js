import React from 'react';
import DisplayMessage from "./DisplayMessage";
import Layout from "./layout/Layout";
import MainContents from "./layout/MainContents";

const Home = () => {
    return (
        <div>
            <MainContents>
                <DisplayMessage/>
            </MainContents>
        </div>
    );
};

export default Home;