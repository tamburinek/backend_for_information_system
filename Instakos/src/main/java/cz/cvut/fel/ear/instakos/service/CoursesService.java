package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.CoursesDao;
import cz.cvut.fel.ear.instakos.dao.UserDao;
import cz.cvut.fel.ear.instakos.model.school.Course;
import cz.cvut.fel.ear.instakos.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CoursesService {

    private final CoursesDao dao;
    private final UserDao userDao;

    @Autowired
    public CoursesService(CoursesDao dao, UserDao userDao) {
        this.dao = dao;
        this.userDao = userDao;
    }

    @Transactional
    public boolean joinCourse(User user, Course course){
        if (course.getStudentsSize()<course.getCapacity()){
            course.addStudent(user);
            dao.persist(course);
            userDao.persist(user);
            return true;
        }
        return false;
    }

    @Transactional
    public Course findCourseById(int id) {
        return dao.find(id);
    }

    @Transactional
    public List<Course> findAllCourses(){
        return dao.findAll();
    }

    @Transactional
    public void createCourse(String capacity, String day, String endtime, String name, String start) {
        Course course = new Course();
        course.setCapacity(Integer.parseInt(capacity));
        course.setDay(day);
        course.setEndTime(Time.valueOf(endtime+":00"));
        course.setName(name);
        course.setStart(Time.valueOf(start+":00"));
        dao.persist(course);
    }
}
