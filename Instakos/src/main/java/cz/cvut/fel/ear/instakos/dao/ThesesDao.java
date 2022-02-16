package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.school.Theses;
import org.springframework.stereotype.Repository;

@Repository
public class ThesesDao extends BaseDao<Theses>{

    public ThesesDao() {
        super(Theses.class);
    }
}
