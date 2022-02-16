package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.Start;
import cz.cvut.fel.ear.instakos.model.profile.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ComponentScan(basePackageClasses = Start.class)
public class BaseDaoTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ProfileDao profileDao;

    @Test
    public void persistSavesSpecifiedInstance() {
        final Profile profile = generateProfile();
        profileDao.persist(profile);
        assertNotNull(profile.getId());

        final Profile result = em.find(Profile.class, profile.getId());
        assertNotNull(result);
        assertEquals(profile.getId(), result.getId());
    }

    private static Profile generateProfile() {
        final Profile profile = new Profile();
        return profile;
    }
}
