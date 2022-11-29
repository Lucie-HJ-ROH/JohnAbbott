import React from 'react';
import {CallGetQuery} from "../rest/CallGetQuery";

function DbData2() {
    return (
        <>
            <button onClick={CallGetQuery}>Read-Single</button>
        </>)
}

export default DbData2;