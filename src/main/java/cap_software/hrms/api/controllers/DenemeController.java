package cap_software.hrms.api.controllers;

import cap_software.hrms.bussiness.abstracts.UserService;
import cap_software.hrms.entities.concretes.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deneme")
public class DenemeController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    String  getDene(){

        return "deneme";
    }

    @PostMapping("/add")
    void add(@RequestBody User user){

        userService.add(user);
    }

}
