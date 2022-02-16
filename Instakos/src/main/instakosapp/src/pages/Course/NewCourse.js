import Navbar from "../../components/Navbar";
import NewCourseForm from "../../components/NewCourseForm";

const NewCourse = () =>{
    return (
        <div>
            <div id="home">
                <Navbar/>
            </div>
            <div id="courseBody">
        <NewCourseForm/>
            </div>
        </div>

    )
}

export default NewCourse;