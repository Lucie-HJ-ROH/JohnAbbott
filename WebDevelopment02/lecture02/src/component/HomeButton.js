import {useNavigate} from "react-router-dom";
import Button from "react-bootstrap/Button";

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
    <div>
      <Button variant="primary" onClick={handleSubmit}>Home</Button>

    </div>
  );
}

export default HomeButton;