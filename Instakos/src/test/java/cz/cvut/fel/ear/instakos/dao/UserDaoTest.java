package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.Start;
import cz.cvut.fel.ear.instakos.model.enums.Roles;
import cz.cvut.fel.ear.instakos.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ComponentScan(basePackageClasses = Start.class)
public class UserDaoTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserDao userDao;

    @Test
    public void findByUsernameReturnsPersonWithMatchingUsername () throws InvalidKeySpecException, NoSuchAlgorithmException {
        final User user = generateUser();
        userDao.persist(user);
        assertNotNull(user.getId());

        final User result = em.find(User.class, user.getId());
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
    }

    @Test
    public void findByUsernameReturnsNullForUnknownUsername() {
        assertEquals(userDao.findByUsername("unknownUsername"),null);
    }

    private static User generateUser() throws InvalidKeySpecException, NoSuchAlgorithmException {
        final User user = new User();
        user.setGender("man");
        user.setAge(35);
        user.setUsername("tamburinek");
        user.setFirstName("tonda");
        user.setLastName("testik");
        user.setPassword("hello");
        return user;
    }

}
