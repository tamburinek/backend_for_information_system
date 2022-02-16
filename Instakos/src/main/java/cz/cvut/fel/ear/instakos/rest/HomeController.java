package cz.cvut.fel.ear.instakos.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT', 'ROLE_TEACHER', 'ROLE_GUEST')")
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

}
