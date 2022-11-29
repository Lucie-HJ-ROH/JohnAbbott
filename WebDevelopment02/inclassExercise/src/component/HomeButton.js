import {useNavigate} from "react-router-dom";

function HomeButton() {
    const navigate = useNavigate();
    const handleSubmit = (event) => {
        try {
            navigate("/", {replace: true});
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <div style={{flexDirection: "row", direction: "rtl"}}>
            <button onClick={handleSubmit}>Home</button>
        </div>
    );
}

export default HomeButton;