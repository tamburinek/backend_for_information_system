import React, {Component} from "react";

import UserService from "../user.service";

export default class TestAuth extends Component {
    constructor(props) {
        super(props);

        this.state = {
            content: ""
        };
    }

    componentDidMount() {
        UserService.getAdminBoard().then(response => {
            this.setState({
                content: response.data
            });
        }, error => {
            this.setState({
                content: (error.response && error.response.data && error.response.data.message) || error.message || error.toString()
            });

            if (error.response && error.response.status === 401) {
                console.log('logout');
            }
        });
    }

    render() {
        return (<div className="container">
                <header className="jumbotron">
                    <h3>{this.state.content}</h3>
                </header>
            </div>);
    }
}
