package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.user.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDao extends BaseDao<Email>{

    public EmailDao() {
        super(Email.class);
    }
}
