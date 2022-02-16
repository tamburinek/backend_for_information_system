import React, {useEffect, useState} from "react";
import axios from "axios";
import authHeader from "../auth-header";
import {Link} from "react-router-dom";
import Chat from "../pages/Chat/Chat";
import * as PropTypes from "prop-types";
import Navbar from "./Navbar";


function ChatLink(props) {
    const chatID = props.id;
    const [username, setUsername] = useState([])


    useEffect(() => {
        axios.get(`http://localhost:8080/instakos/chat/${chatID}/name`, {headers: authHeader()})
            .then(response => {
                // console.log(response.data);
                setUsername(response.data.toString().substring(0,1));
            }, error => {
                console.log(error.toString());
            })
    })
    return (<div>{username}</div>)
}

function AllChat() {
    const [chats, setChat] = useState([])

    useEffect(() => {
        fetch('http://localhost:8080/instakos/chat/allChat', {headers: authHeader()})
            .then((response) => response.json())
            .then((result) => {
                setChat(result);
                // console.log(result);
            })

    }, [])


    return (

        <div>
            <div id="home">
                <Navbar/>
            </div>
            <div id="chatDashboard">
                {chats.map(chat => (<div className="chatInDashBoard">
                    <p><Link to={`/chat/${chat.id}`}><ChatLink id={chat.id}/></Link></p>
                </div>))}
            </div>
        </div>
    )
};

export default AllChat;