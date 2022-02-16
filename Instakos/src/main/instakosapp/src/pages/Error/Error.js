import {Link} from "react-router-dom";
import React from "react";


function Error() {
    return (
        <div id="index">
            <h1 id="mainHeader"> This is error page - you probably did something illegal </h1>

            <div id="buttonLogin">
                <button className="bn29"><Link to="/login">LOGIN NOW</Link></button>
            </div>
            <div id="buttonRegister">
                <button className="bn29"><Link to="/register">REGISTER NOW</Link></button>
            </div>
        </div>
    );
}

export default Error;