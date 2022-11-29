import Toggle from "./Toggle";
import Button from "@mui/material/Button";

function UserActions(props) {
  const handleOnClick = () => {
    props.setColor(Toggle(props.color));
    props.setCount(props.count + 1)
  }
  
  return (
    <Button variant="outlined" onClick={handleOnClick}>
      Click me React
    
    </Button>
  )
}

export default UserActions;