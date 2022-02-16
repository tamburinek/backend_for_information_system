import React from 'react';
import {Link} from "react-router-dom";
import AuthService from "./Login/auth.service";



const MainPage = () => {
    AuthService.logout();

    return (<div id="index">
        <div className="topic">
            <p id="mainHeader">WELCOME TO INSTAKOS</p>
        </div>
        <div id="buttonLogin">
            <button className="bn29"><Link to="/login">LOGIN NOW</Link></button>
        </div>
        <div id="buttonRegister">
            <button className="bn29"><Link to="/register">REGISTER NOW</Link></button>
        </div>

    </div>)
}

export default MainPage;