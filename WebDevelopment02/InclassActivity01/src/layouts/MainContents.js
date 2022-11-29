import React from "react";

function MainContents(props) {

    const mainStyle = {
        minHeight: '300px',
        textAlign : 'center'

    };
    return(
        <div style={mainStyle}>
            {props.children}
        </div>
    )
}


export default MainContents