import React from 'react';
import {CallGetAll} from "../rest/CallGetAll";

function DbData() {
    return (
        <>
            <button onClick={CallGetAll}>Read All</button>
        </>)
}

export default DbData;

