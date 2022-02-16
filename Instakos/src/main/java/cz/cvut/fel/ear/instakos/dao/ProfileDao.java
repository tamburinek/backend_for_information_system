package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.profile.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDao extends BaseDao<Profile>{

    public ProfileDao() {
        super(Profile.class);
    }
}
