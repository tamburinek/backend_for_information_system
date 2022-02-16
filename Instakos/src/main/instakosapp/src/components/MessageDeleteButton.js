import {Link} from "react-router-dom";
import axios from "axios";
import authHeader from "../auth-header";

const MessageDeleteButton = (props) => {

    const handleDelete = () => {
        axios.delete(`http://localhost:8080/instakos/chat/${props.messageID}/delete`,
            {
                headers: authHeader()
            }
        )
    }


return(
        <a className="deleteButtonMessage" href="" onClick={handleDelete}>...</a>
)
}

export default MessageDeleteButton