import React, {useEffect} from "react";
import {Contact} from "./Contact";
import {About} from "./About";
import DisplayMessage from "./DisplayMessage";
import Clock from "./Clock";
import CounterDisplay from "./CounterDisplay";
import UserActions from "./UserActions";
function Home(){
    const [color, setColor] = React.useState(JSON.parse(sessionStorage.getItem('color')) || "blue");
    const [count, setCount] = React.useState(JSON.parse(localStorage.getItem('count')) || 0);

    console.log(color);
    console.log(count);

    useEffect(() => {
        sessionStorage.setItem('color', JSON.stringify(color));
        localStorage.setItem('count', JSON.stringify(count));

    }, [color, count]);
    return (
        <div>
            <DisplayMessage color={color}/>
            <Clock/>
            <CounterDisplay count ={count}/>
            <UserActions
                setColor={setColor}
                setCount={setCount}
                count={count}
                color={color}/>
        </div>
    );
}

export default Home