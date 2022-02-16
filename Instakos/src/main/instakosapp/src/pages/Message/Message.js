import {useEffect, useState} from "react";

export default function Message() {
    const [messages, setMessage] = useState([])

    useEffect(() => {
        fetch("http://localhost:8080/instakos/chat/1")
            .then(res => res.json())
            .then((result) => {
                setMessage(result);
            })
    }, [])

    return (<div>
        MESSAGES
        {messages.map(message => (<div>
            Message:{message.message}<br/>
            Id:{message.id}<br/>
        </div>))}
    </div>)
}

