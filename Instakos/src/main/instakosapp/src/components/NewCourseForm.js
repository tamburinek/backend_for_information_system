import axios from "axios";
import React, {useState} from "react";
import {Link, useNavigate} from "react-router-dom";
import authHeader from "../auth-header";

const NewCourseForm = () => {
    const [capacity, setCapacity] = useState('50');
    const [day, setDay] = useState('Monday');
    const [endtime, setendTIme] = useState(null);
    const [name, setname] = useState('Test');
    const [start, setStart] = useState(null);


    let navigate = useNavigate();
    const [error, setError] = useState(null);

    const handleCreate = () => {

        axios.post('http://localhost:8080/instakos/course/create', {
            "capacity": capacity, "day": day, "endtime": endtime, "name": name, "start": start
        }, {
            headers: authHeader(), params: {
                capacity: capacity, day: day, endtime: endtime, name: name, start: start,
            },
        })
            .then(navigate(`/course/myCourse`))
            .catch(error => {
                if (error.response.status === 401 || error.response.status === 400) {
                    setError(error.response.data.message);
                } else {
                    setError("JEJDA");
                }
            });
    }

    return <div id="registration">
        <div id="inputsNewCourse">
            <label>capacity
                <input type="text" name="capacity" placeholder="capacity"
                       value={capacity}
                       onChange={e => setCapacity(e.target.value)}
                />
            </label>
            <label>day
                <input type="text" name="day" placeholder="day"
                       value={day}
                       onChange={e => setDay(e.target.value)}
                />
            </label>
            <label>endtime
                <input type="time" name="endtime" placeholder="endtime"
                       value={endtime}
                       onChange={e => setendTIme(e.target.value)}
                />
            </label>
            <label>name
                <input type="text" name="name" placeholder="name"
                       value={name}
                       onChange={e => setname(e.target.value)}
                />
            </label>
            <label>start
                <input type="time" name="start" placeholder="start"
                       value={start}
                       onChange={e => setStart(e.target.value)}
                />
            </label>
            {error && <p className="error">{error}</p>}
            <button id="mainButton" onClick={handleCreate}>CREATE</button>
        </div>

    </div>
}

export default NewCourseForm