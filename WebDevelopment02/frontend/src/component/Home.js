import React from 'react';
import DisplayMessage from "./DisplayMessage";
import Layout from "./layout/Layout";
import MainContents from "./layout/MainContents";
import DbData from "./DbData/DbData";
import DbData1 from "./DbData/DbData1";
import DbData2 from "./DbData/DbData2";
import DbData3 from "./DbData/DbData3";
import DbData4 from "./DbData/DbData4";
import DbData5 from "./DbData/DbData5";
import DbData6 from "./DbData/DbData6";
import DbData7 from "./DbData/DbData7";
import Login from "./Login";
import Register from "./Register";
import Header from "./layout/Header";

const Home = () => {
    return (
        <div>
            <MainContents>
                {/*<DisplayMessage/>*/}
                <DbData/>
                {/*<DbData1/>*/}
                {/*<DbData2/>*/}
                {/*<DbData3/>*/}
                {/*<DbData4/>*/}
                {/*<DbData5/>*/}
                {/*<DbData6/>*/}
                {/*<DbData7/>*/}
                <Header/>
                <Login/>
                <Register/>
            </MainContents>
        </div>
    );
};

export default Home;