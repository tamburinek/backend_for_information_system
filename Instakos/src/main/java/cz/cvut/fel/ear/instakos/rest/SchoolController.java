package cz.cvut.fel.ear.instakos.rest;

import cz.cvut.fel.ear.instakos.model.user.SkillExperience;
import cz.cvut.fel.ear.instakos.service.SchoolService;
import cz.cvut.fel.ear.instakos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;
    private final UserService userService;

    @Autowired
    public SchoolController(SchoolService schoolService, UserService userService) {
        this.schoolService = schoolService;
        this.userService = userService;
    }

    @PostMapping(value = "/create/experience", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCourse(@RequestBody HashMap<String, String> request) {
        schoolService.createExp(request.get("description"), request.get("language"), Integer.parseInt(request.get("yearsOfExperience")));
    }

    @GetMapping(value = "/all/experience")
    public List<SkillExperience> getAllExps(){
        return schoolService.findAllExps();
    }

    @GetMapping(value = "/delete/experience/{id}")
    public boolean deleteExp(@PathVariable int id){
        schoolService.deleteExp(id);
        return true;
    }

    @PostMapping(value = "/update/experience/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateExp(@PathVariable int id, @RequestBody HashMap<String, String> request){
        schoolService.updateExp(id, request.get("description"), request.get("language"), Integer.parseInt(request.get("yearsOfExperience")));
        return true;
    }

}
