package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.school.Course;
import cz.cvut.fel.ear.instakos.model.user.User;
import cz.cvut.fel.ear.instakos.service.CoursesService;
import cz.cvut.fel.ear.instakos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CoursesService coursesService;

    private final UserService userService;

    @Autowired
    public CourseController(CoursesService coursesService, UserService userService) {
        this.coursesService = coursesService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return coursesService.findCourseById(id);
    }

    @GetMapping("/myCourse")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_STUDENT', 'ROLE_TEACHER')")

    public List<Course> getMyCourses(Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<Course> result = new ArrayList<>();
        for(Course course : coursesService.findAllCourses()){
            if(course.getStudents().contains(user)){
                result.add(course);
            }
        }
        return result;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_STUDENT', 'ROLE_TEACHER')")
    public List<Course> getAllCourses(){
        return coursesService.findAllCourses();
    }


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_STUDENT', 'ROLE_TEACHER')")
    public void createCourse(@RequestParam("capacity") String capacity,
                             @RequestParam("day") String day,
                             @RequestParam("endtime") String endtime,
                             @RequestParam("name") String name,
                             @RequestParam("start") String start)
    {
        coursesService.createCourse(capacity, day, endtime, name, start);
    }

    @GetMapping(value = "/{username}/join/{id}")
    public boolean joinCourse(@PathVariable String username, @PathVariable int id){
        return coursesService.joinCourse(userService.findByUsername(username), coursesService.findCourseById(id));
    }
}
