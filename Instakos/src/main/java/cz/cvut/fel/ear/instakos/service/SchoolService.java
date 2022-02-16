package cz.cvut.fel.ear.instakos.service;

import cz.cvut.fel.ear.instakos.dao.*;
import cz.cvut.fel.ear.instakos.model.user.SkillExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolService {

    private final ExamDao examDao;
    private final StudyResultDao studyResultDao;
    private final ThesesDao thesesDao;
    private final SkillExperienceDao skillExperienceDao;
    private final UserDao userDao;

    @Autowired
    public SchoolService(ExamDao examDao, StudyResultDao studyResultDao, ThesesDao thesesDao, SkillExperienceDao skillExperienceDao, UserDao userDao) {
        this.examDao = examDao;
        this.studyResultDao = studyResultDao;
        this.thesesDao = thesesDao;
        this.skillExperienceDao = skillExperienceDao;
        this.userDao = userDao;
    }

    @Transactional
    public void createExp(String description, String language, int years){
        SkillExperience skill = new SkillExperience();
        skill.setDescription(description);
        skill.setLanguage(language);
        skill.setYearsOfExperience(years);
        skillExperienceDao.persist(skill);
    }

    @Transactional
    public List<SkillExperience> findAllExps(){
        return skillExperienceDao.findAll();
    }

    @Transactional
    public void deleteExp(int id){
        skillExperienceDao.remove(skillExperienceDao.find(id));
    }

    @Transactional
    public void updateExp(int id, String description, String language, int years){
        SkillExperience skillExperience = skillExperienceDao.find(id);
        skillExperience.setDescription(description);
        skillExperience.setLanguage(language);
        skillExperience.setYearsOfExperience(years);
        skillExperienceDao.update(skillExperience);
    }
}
