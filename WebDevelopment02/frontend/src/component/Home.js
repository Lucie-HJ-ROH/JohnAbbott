import React from 'react';
import DisplayMessage from "./DisplayMessage";
import Layout from "./layout/Layout";
import MainContents from "./layout/MainContents";
import DbData from "./DbData";

const Home = () => {
    return (
        <div>
            <MainContents>
                <DisplayMessage/>
                <DbData/>
            </MainContents>
        </div>
    );
};

export default Home;