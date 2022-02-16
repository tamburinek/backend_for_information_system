import React, {useState} from "react";
import {Link, useNavigate} from "react-router-dom";
import axios from "axios";


const Register = () => {

    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [username, setUsername] = useState(null);
    const [email, setEmail] = useState(null);
    const [age, setAge] = useState(null);
    const [bio, setBio] = useState(null);
    const [gender, setGender] = useState(null);
    const [password, setPassword] = useState(null);


    let navigate = useNavigate();
    const [error, setError] = useState(null);



    const handleRegistration = () => {

        axios.post('http://localhost:8080/instakos/newUser', {
            "username": username, "password": password
        }, {
            headers: {"Content-Type": "application/json; charset=UTF-8"},
            params: {
                firstname: firstname,
                lastname: lastname,
                username: username,
                email: email,
                age: age,
                bio: bio,
                gender: gender,
                password: password
            },
        })
            .then(response => {
                navigate(`/login`)
            })
            .catch(error => {
                if (error.response.status === 401 || error.response.status === 400) {
                    setError(error.response.data.message);
                } else {
                    setError("JEJDA");
                }
            });
    }


    return <div id="registration">
        <div className="configForm">
            <div id="nameForm">
                <div className="container">
                    <div id="inputs">
                        <label>firstname
                            <input type="text" name="firstname" placeholder="first name"
                                   value={firstname}
                                   onChange={e => setFirstName(e.target.value)}
                            />
                        </label>
                        <label>lastname
                            <input type="text" name="lastname" placeholder="last name"
                                   value={lastname}
                                   onChange={e => setLastName(e.target.value)}
                            />
                        </label>
                        <label>username
                            <input type="text" name="username" placeholder="username"
                                   value={username}
                                   onChange={e => setUsername(e.target.value)}
                            />
                        </label>
                        <label>email
                            <input type="email" name="email" placeholder="email"
                                   value={email}
                                   onChange={e => setEmail(e.target.value)}
                            />
                        </label>
                        <label>age
                            <input type="number" name="age" placeholder="age"
                                   value={age}
                                   onChange={e => setAge(e.target.value)}
                            />
                        </label>
                        <label>bio
                            <input type="text" name="bio" placeholder="your bio"
                                   value={bio}
                                   onChange={e => setBio(e.target.value)}
                            />
                        </label>
                        <label>gender
                            <select name="gender"
                                    value={gender}
                                    onChange={e => setGender(e.target.value)}>
                                <option value="Unspecified">Unspecified</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </label>
                        <label>password
                            <input type="password" name="password"
                                   value={password}
                                   onChange={e => setPassword(e.target.value)}
                            />
                        </label>
                        {error && <p className="error">{error}</p>}
                        <button id="mainButton" onClick={handleRegistration}>REGISTER</button>
                        <button type="button"><Link to="/login">Already Registered?</Link></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
}

export default Register;