package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.profile.Profile;
import cz.cvut.fel.ear.instakos.model.user.Email;
import cz.cvut.fel.ear.instakos.model.user.User;
import cz.cvut.fel.ear.instakos.rest.util.RestUtils;
import cz.cvut.fel.ear.instakos.service.EmailService;
import cz.cvut.fel.ear.instakos.service.ProfileService;
import cz.cvut.fel.ear.instakos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;


@RestController
public class RegistrationRestController {

    private final UserService userService;
    private final ProfileService profileService;
    private final EmailService emailService;


    @Autowired
    public RegistrationRestController(UserService userService, ProfileService profileService, EmailService emailService) {
        this.userService = userService;
        this.profileService = profileService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public RedirectView createUser(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("age") int age,
            @RequestParam("bio") String bio,
            @RequestParam("gender") String gender,
            @RequestParam("password") String password
    ) {
        Profile profile = new Profile();
        profile.setBio(bio);
        profileService.createProfile(profile);

        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setUsername(username);
        user.setAge(age);
        user.setGender(gender);
        user.setPassword(userService.hashPassword(password));
        user.setProfile(profile);
        userService.persist(user);

        Email newEmail = new Email();
        newEmail.setEmail(email);
        newEmail.setUser(user);
        emailService.persist(newEmail);


        return new RedirectView("login");
    }
}
