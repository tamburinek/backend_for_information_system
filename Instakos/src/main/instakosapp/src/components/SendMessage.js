import {Link} from "react-router-dom";
import React from "react";

const SendMessage = () =>{
    return (
        <div id="sendMessageChatsDashBoard">
            <button type="button"><Link to="/chat/newMessage">SEND MESSAGE</Link></button>
        </div>
    );
}

export default SendMessage;