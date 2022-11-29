import React from 'react';
import DisplayMessage from "./DisplayMessage";
import Layout from "./layout/Layout";
import MainContents from "./layout/MainContents";
import DbData from "./DbData";
import DbData1 from "./DbData1";
import DbData2 from "./DbData2";
import DbData3 from "./DbData3";
import DbData4 from "./DbData4";
import DbData5 from "./DbData5";
import DbData6 from "./DbData6";
import DbData7 from "./DbData7";

const Home = () => {
    return (
        <div>
            <MainContents>
                <DisplayMessage/>
                <DbData/>
                <DbData1/>
                <DbData2/>
                <DbData3/>
                <DbData4/>
                <DbData5/>
                <DbData6/>
                <DbData7/>
            </MainContents>
        </div>
    );
};

export default Home;