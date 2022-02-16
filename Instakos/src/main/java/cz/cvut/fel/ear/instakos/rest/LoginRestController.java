package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.user.User;
import cz.cvut.fel.ear.instakos.payload.response.JwtResponse;
import cz.cvut.fel.ear.instakos.security.DefaultAuthenticationProvider;
import cz.cvut.fel.ear.instakos.security.SecurityUtils;
import cz.cvut.fel.ear.instakos.security.jwt.JwtUtils;
import cz.cvut.fel.ear.instakos.service.EmailService;
import cz.cvut.fel.ear.instakos.service.ProfileService;
import cz.cvut.fel.ear.instakos.service.UserService;
import cz.cvut.fel.ear.instakos.service.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:3000")

//@RestController
//@RequestMapping("/auth")
public class LoginRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    private final UserService userService;
    private final ProfileService profileService;
    private final EmailService emailService;

    @Autowired
    private DefaultAuthenticationProvider provider;
    private final UserDetailsService userDetailsService;


    @Autowired
    public LoginRestController(UserService userService, ProfileService profileService, EmailService emailService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.profileService = profileService;
        this.emailService = emailService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/loginUser", produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin(origins = "http://localhost:3000")
    public void loginUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println(username + ", " + password);
        User user = userService.findByUsername(username);
        SecurityContextHolder.setContext(new SecurityContextImpl());

        String passwordFromDb = user.getPassword();

        if (userService.matches(password, passwordFromDb)) {
//            userService.setCurrentUser(user);
            provider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("i just logged as " + SecurityUtils.getCurrentUser().getRole());
        }
    }

    public User currentUser(){
        return SecurityUtils.getCurrentUser();
    }


    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestParam("username") String username,
                                              @RequestParam("password") String password) {

        System.out.println(username + ", " + password);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getProfileId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }


}
