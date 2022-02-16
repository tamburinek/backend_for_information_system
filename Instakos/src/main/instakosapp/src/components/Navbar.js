import {Link, useNavigate} from "react-router-dom";
import React from "react";


function Home() {

    let navigate = useNavigate();

    const handleLogout = () => {
        fetch('http://localhost:8080/instakos/logout', {mode: 'no-cors'}).then(
            response => {
                console.log('odhlaseno')
                navigate(`/`)
            }).catch(console.log('neco se stalo'))
    }


    return (<div className="navbar">
        <a href="/home"><Link to="/home"/>Home</a>
        <div className="subnav">
            <button className="subnavbtn"> Chat <i className="fa fa-caret-down"></i></button>
            <div className="subnav-content">
                <a className="no-action" href="/"><Link to="/chat/newMessage">Send Message</Link></a>
                <a className="no-action"><Link to="/chat/allchat">Show all chat</Link></a>
            </div>
        </div>
        <div className="subnav">
            <button className="subnavbtn">Courses <i className="fa fa-caret-down"></i></button>
            <div className="subnav-content">
                <a className="no-action" href="/"><Link to="/course/newCourse">Create Course</Link></a>
                <a className="no-action" href="/"><Link to="/course/all">View all course</Link></a>
                <a className="no-action" href="/"><Link to="/course/myCourse">View My Courses</Link></a>
            </div>
        </div>
        <div className="subnav">
            <button className="subnavbtn">Schedule <i className="fa fa-caret-down"></i></button>
            <div className="subnav-content">
                <a className="no-action" href="#link1"><Link to="/todo">Show Schedule</Link></a>
                <a className="no-action" href="#link2"><Link to="/todo">Find Schedule</Link></a>
            </div>
        </div>

        <div className="subnav">
            <button className="subnavbtn">Users <i className="fa fa-caret-down"></i></button>
            <div className="subnav-content">
                <a className="no-action" href="#link1"><Link to="/todo">Find User</Link></a>
                <a className="no-action" href="#link2"><Link to="/todo">Block User</Link></a>
            </div>
        </div>

        <div className="onRight">
            <a onClick={handleLogout}>
                LOG OUT
            </a>
        </div>

    </div>);
}

export default Home;