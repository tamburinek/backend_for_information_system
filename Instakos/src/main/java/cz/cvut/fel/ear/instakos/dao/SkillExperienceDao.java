package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.user.SkillExperience;
import org.springframework.stereotype.Repository;

@Repository
public class SkillExperienceDao extends BaseDao<SkillExperience> {

    public SkillExperienceDao() {
        super(SkillExperience.class);
    }
}
