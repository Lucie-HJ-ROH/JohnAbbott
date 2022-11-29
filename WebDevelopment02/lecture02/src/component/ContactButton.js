import {useNavigate} from "react-router-dom";
import Button from "react-bootstrap/Button";

function ContactButton() {
  const navigate = useNavigate();
  const handleSubmit = (event) => {
    try {
      navigate("/contact", {replace: true});
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div>
      <Button variant="primary" onClick={handleSubmit}>Contact</Button>

    </div>
  );
}

export default ContactButton;