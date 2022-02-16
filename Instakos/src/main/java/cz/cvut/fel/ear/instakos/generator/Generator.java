package cz.cvut.fel.ear.instakos.generator;

import cz.cvut.fel.ear.instakos.model.user.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

public class Generator {

    private static final Random RAND = new Random();

    public static int randomInt() {
        return RAND.nextInt();
    }

    public static boolean randomBoolean() {
        return RAND.nextBoolean();
    }

    public static User generateUser() throws InvalidKeySpecException, NoSuchAlgorithmException {
        final User user = new User();
        user.setFirstName("FirstName" + randomInt());
        user.setLastName("LastName" + randomInt());
        user.setUsername("username" + randomInt());
        user.setPassword(Integer.toString(randomInt()));
        user.setAge(randomInt());
        user.setGender("man");
        return user;
    }
}
