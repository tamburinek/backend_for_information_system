import React, {useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import authHeader from "../auth-header";


const MessageForm = () => {
    let {id} = useParams();


    const [message, setMessage] = useState('');


    const handleSend = () => {
        axios.post(`http://localhost:8080/instakos/chat/${id}/send`, {
                "message": message
            },
            {
                headers: authHeader(),
                params: {message: message}
            }
        ).then(setMessage(''))
    }


    return (
        <div className="MessageInputForm">
            <input type="text" name="message" value={message}
                   onChange={e => setMessage(e.target.value)}
             placeholder="Type message here"/>
            <button type="submit" id="MessageSendButton" onClick={handleSend}>SEND</button>
        </div>
    )
}

export default MessageForm;