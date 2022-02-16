import React, {useState} from "react";
import {connect, useDispatch} from "react-redux";
import {Link, useNavigate} from "react-router-dom";
import axios from "axios";
import {removeUserSession, setUserSession} from "../../Commons";
import {authenticateUser} from "./Authentication";
import AuthService from "./auth.service";
import authHeader from "../../auth-header";


const Login = (props) => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);

    let navigate = useNavigate();

    AuthService.logout();


    // const dispatch = useDispatch();
    //
    // const validateUser = () => {
    //     dispatch(authenticateUser(username, password))
    //         .then((response) => {
    //             console.log(response.data);
    //         })
    //         .catch((error) => {
    //             console.log(error.message);
    //             setError("Invalid email and password");
    //         });
    // };

    const handleTest = () => {

        axios.get("http://localhost:8080/instakos/user/current", {headers: authHeader()}).then(response => {
            // console.log(response)
        });
    }

    const handleLogin = () => {
        AuthService.login(username, password).then(responce => {
            // console.log(responce);
            navigate(`/home`);
        }).catch(error => {
            if (error.response.status === 401 || error.response.status === 400) {
                setError(error.response.data.message);
            } else {
                setError("JEJDA");
            }
        })

        // axios.post(API_URL + "signin", {
        //     username, password
        // }).then(response => {
        //     if (response.data.accessToken) {
        //         localStorage.setItem("user", JSON.stringify(response.data));
        //     }
        //     return response.data;
        // });

        //     axios.post(`${SERVER_URL}/auth/signin`, {
        //     "username": username, "password": password
        // }, {
        //     headers: {"Content-Type": "application/json; charset=UTF-8"},
        //     params: {username: username, password: password},
        // })
        //     .then(response => {
        //         if (response.data.accessToken) {
        //             localStorage.setItem("user", JSON.stringify(response.data));
        //         }
        //         // navigate(`/home`)
        //     })
        //     .catch(error => {
        //         setLoading(false);
        //         removeUserSession();
        //         if (error.response.status === 401 || error.response.status === 400) {
        //             setError(error.response.data.message);
        //         } else {
        //             setError("JEJDA");
        //         }
        //     });

    }

    return (
        <div id="login">
            <div id="nameForm">
                <div className="container">
                    <div className="brand-logo"></div>
                    <div className="brand-title">INSTAKOS</div>
                    <div className="inputs">
                        <label>Username</label>
                        <input type="text" name="username" placeholder="tamburinek" value={username}
                               onChange={e => setUsername(e.target.value)}
                        />
                        <label>PASSWORD</label>
                        <input type="password" name="password" placeholder="Min 6 charaters long" value={password}
                               onChange={e => setPassword(e.target.value)}
                        />
                        {error && <p className="error">{error}</p>}
                        <button type="submit" onClick={handleLogin}>LOGIN</button>
                        <button type="button"><Link to="/register">REGISTER NOW</Link></button>
                    </div>
                </div>
            </div>
        </div>);


}

export default Login;