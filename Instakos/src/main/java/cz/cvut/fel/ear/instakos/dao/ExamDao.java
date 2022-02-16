package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.school.Exam;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDao extends BaseDao<Exam> {

    public ExamDao() {
        super(Exam.class);
    }
}
