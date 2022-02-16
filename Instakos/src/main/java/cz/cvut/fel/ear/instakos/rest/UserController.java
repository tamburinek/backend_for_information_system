package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.enums.Roles;
import cz.cvut.fel.ear.instakos.model.profile.Profile;
import cz.cvut.fel.ear.instakos.model.user.User;
import cz.cvut.fel.ear.instakos.service.ProfileService;
import cz.cvut.fel.ear.instakos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {


    private final UserService userService;
    private final ProfileService profileService;

    @Autowired
    public UserController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ADMIN', 'ROLE_USER', 'ROLE_GUEST')")
    @RequestMapping(value = "/username", method = RequestMethod.POST)
    public String getProfileUsername(@RequestParam("id") int id) {
        return profileService.findByID(id).getUser().getUsername();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ADMIN', 'ROLE_USER', 'ROLE_GUEST')")
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public int getProfile(@RequestParam("id") int id) {
        return userService.findByID(id).getProfile().getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ADMIN')")
    @PostMapping(value = "/block/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void blockUser(@PathVariable String username){
        userService.blockUser(username);
    }

    @GetMapping(value = "/{username}")
    public User findUserByID(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping(value = "/{username}/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean changeUsersRole(@PathVariable String username, @PathVariable String role){
        User user = userService.findByUsername(username);
        user.setRole(Roles.valueOf(role));
        userService.persist(user);
        return user.getRole() == Roles.valueOf(role);
    }
}
