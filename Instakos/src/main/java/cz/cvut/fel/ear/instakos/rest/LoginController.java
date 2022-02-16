package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public LoginController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

}
