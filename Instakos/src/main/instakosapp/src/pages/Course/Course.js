import Navbar from "../../components/Navbar";
import React, {useEffect, useState} from "react";
import authHeader from "../../auth-header";
import {Link} from "react-router-dom";
import axios from "axios";

const Course = () => {

    const [courses, setCourse] = useState([])

    useEffect(() => {
        axios.get(`http://localhost:8080/instakos/course/all`, {headers: authHeader()})
            .then(response => {
                console.log(JSON.stringify(response.data));
            })
    })


    return (
        <div>
            <div id="home">
                <Navbar/>
            </div>
            <div id="courseBody">
                {courses.map(course => (<div className="chatInDashBoard">
                    <p>{course.id}</p>
                </div>))}
            </div>
        </div>

    )
}


export default Course