package cz.cvut.fel.ear.instakos.model;

import cz.cvut.fel.ear.instakos.model.user.User;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTest {

    @Test
    public void passwordTest_hashedPasswordIsNotSameAsOld() throws InvalidKeySpecException, NoSuchAlgorithmException {
        //arrange
        String password = "password";
        User user = new User();

        //act
        user.setPassword(password);

        //assert
        assertNotEquals(password, user.getPassword());
    }
}
