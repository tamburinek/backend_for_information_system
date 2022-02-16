import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";

//Import pages
import MainPage from "./pages";
import Login from "./pages/Login/Login";
import Register from "./pages/Register/Register";
import Error from "./pages/Error/Error";
import Home from "./pages/Home/Home";
import Chats from "./pages/Chat/Chats";
import TestAuth from "./pages/TestAuth";
import NewMessageForm from "./components/NewMessageForm";
import Chat from "./pages/Chat/Chat";

import './css/style.css'
import Course from "./pages/Course/Course";
import NewCourse from "./pages/Course/NewCourse";
import MyCourse from "./pages/Course/MyCourse";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainPage/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/error" element={<Error/>}/>
                <Route path="/home" element={<Home/>}/>
                <Route path="/course/all" element={<Course/>}/>
                <Route path="/course/newCourse" element={<NewCourse/>}/>
                <Route path="/course/myCourse" element={<MyCourse/>}/>
                <Route path="/chat/allchat" element={<Chats/>}/>
                <Route path="/chat/:id" element={<Chat/>}/>
                <Route path="/chat/newMessage" element={<NewMessageForm/>}/>
                <Route path="/admin" element={<TestAuth/>} />
                <Route path='*' exact={true} element={<Error/>}/>
            </Routes>
        </BrowserRouter>);
}

export default App;


