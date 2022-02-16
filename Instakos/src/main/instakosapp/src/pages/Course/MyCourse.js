import Navbar from "../../components/Navbar";
import React, {useEffect, useState} from "react";
import authHeader from "../../auth-header";

const MyCourse = () =>{
    const [courses, setCourse] = useState([])

    useEffect(() => {
        fetch('http://localhost:8080/instakos/course/myCourse', {headers: authHeader()})
            .then((response) => response.json())
            .then((result) => {
                setCourse(result);
                // console.log(result);
            })

    }, [])


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

export default MyCourse;