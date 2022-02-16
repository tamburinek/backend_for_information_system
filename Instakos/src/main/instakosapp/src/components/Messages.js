import authHeader from "../auth-header";
import AuthService from "../pages/Login/auth.service";
import React from "react";
import {useParams} from "react-router-dom";
import MessageDeleteButton from "./MessageDeleteButton";

class Message extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            messages: []
        }
    }

    componentDidMount() {
        this.timer = setInterval(() => this.getMessages(this.props.chatID), 1000);

    }

    componentWillUnmount() {
        this.timer = null;
    }

    getMessages(id) {
        fetch(`http://localhost:8080/instakos/chat/${id}`, {headers: authHeader()})
            .then((response) => response.json())
            .then((result) => {
                this.setState({messages: result});
            })
    }

    render() {
        return (<div id="MessageBody">
            {this.state.messages.map(message => ((!message.deleted)
                && <div
                    className={(AuthService.getCurrentProfileId() === message.sender.id) ? "LineOfMessageRight" : "LineOfMessageLeft"}>
                    <div className="MessageInChat">
                        <p>{message.message}</p>{(AuthService.getCurrentProfileId() === message.sender.id) &&
                        <MessageDeleteButton messageID={message.id}/>}</div>
                </div>))}
        </div>)
    }
}

export default Message