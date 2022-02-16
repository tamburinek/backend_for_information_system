import React, {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import Navbar from "../../components/Navbar";
import MessageForm from "../../components/MessageForm";
import Messages from "../../components/Messages";


const Chat = () => {

    const { id } = useParams();

    return (<div>
        <div id="home">
            <Navbar/>
        </div>

        <div>
            <Messages chatID={id} />
        </div>

        <div>
            <MessageForm/>
        </div>
    </div>)
}


export default Chat
