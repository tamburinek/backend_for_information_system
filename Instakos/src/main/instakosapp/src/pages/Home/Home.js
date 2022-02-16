import {Link, useNavigate} from "react-router-dom";
import React from "react";
import Navbar from "../../components/Navbar";
import AuthService from "../Login/auth.service";

function Home (){

    return (

        <div id="home">
            <Navbar />
            <div>
                <h2>Here will be our documentation</h2>
            </div>
        </div>
    );
}

export default Home;