package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.school.Homework;
import org.springframework.stereotype.Repository;

@Repository
public class HomeworkDao extends BaseDao<Homework> {

    public HomeworkDao() {
        super(Homework.class);
    }
}
