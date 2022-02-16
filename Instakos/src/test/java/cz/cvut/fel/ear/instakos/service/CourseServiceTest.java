/*
package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.CoursesDao;
import cz.cvut.fel.ear.instakos.model.school.Course;
import cz.cvut.fel.ear.instakos.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseServiceTest {

    private final CoursesDao coursesDao = new CoursesDao();
    //private final CoursesService service = new CoursesService(coursesDao);


    @Autowired
    private TestEntityManager em;

    @Test
    public void checkThatUserCanNotJoinFullCourse(){
        //arrange
        User user = new User();
        Course course = new Course();
        course.setId(23);
        course.setCapacity(0);
        course.setEnd(Timestamp.valueOf("2018-09-01 08:01:15"));
        course.setStart(Timestamp.valueOf("2018-09-01 09:01:15"));
        course.addStudent(user);
        User user1 = new User();

        //assert + act
        //assertFalse(service.joinCourse(user1, course));
    }

    @Test
    public void checkThatUserCanJoinEmptyCourse(){
        //arrange
        User user = new User();
        Course course = new Course();
        course.setId(23);
        course.setCapacity(10);
        course.setEnd(Timestamp.valueOf("2018-09-01 08:01:15"));
        course.setStart(Timestamp.valueOf("2018-09-01 09:01:15"));
        course.addStudent(user);
        User user1 = new User();

        //assert + act
        //assertTrue(service.joinCourse(user1, course));
    }
}
*/
