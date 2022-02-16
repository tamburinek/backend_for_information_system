package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegistrationController {

    @GetMapping("/registration_form")
    public String showRegistrationForm(Model model) {
        return "registration_form";
    }

}
