import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import authHeader from "../auth-header";
import axios from "axios";
import Navbar from "./Navbar";

const NewMessageForm = () => {


    const [username, setUsername] = useState('');
    const [message, setMessage] = useState('');

    let navigate = useNavigate();

    const handleSend = () => {
        axios.post("http://localhost:8080/instakos/chat/newChat", {
                "username": username, "message": message
            },
            {
                headers: authHeader(),
                params: {username: username, message: message}
            }
        ).then(result => {
            setMessage('')
            setUsername('')
            navigate(`/chat/${result.data}`)
        })
    }


    return (
        <div>
            <div id="home">
                <Navbar/>
            </div>
            <div id="newMessageForm">
                <input type="text" name="username" placeholder="type username" value={username}
                       onChange={e => setUsername(e.target.value)}
                />
                <br/>
                <input type="text" name="message" placeholder="type message here" value={message}
                       onChange={e => setMessage(e.target.value)}
                />
                <br/>
                <button type="submit" onClick={handleSend}>Send</button>
            </div>
        </div>

    );
}

export default NewMessageForm