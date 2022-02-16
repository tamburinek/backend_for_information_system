package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.school.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesDao extends BaseDao<Course>{

    public CoursesDao() {
        super(Course.class);
    }
}
