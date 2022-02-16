package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.school.StudyResult;
import org.springframework.stereotype.Repository;

@Repository
public class StudyResultDao extends BaseDao<StudyResult>{

    public StudyResultDao() {
        super(StudyResult.class);
    }
}
