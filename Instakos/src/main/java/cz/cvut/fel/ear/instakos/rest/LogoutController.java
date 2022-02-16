package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public LogoutController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/logout")
    public String showLogoutUser() {
        //final UserDetails userDetails = (UserDetails) userDetailsService.loadUserByUsername("logout");
        //SecurityUtils.setCurrentUser(userDetails);
        return "login";
    }
}
