package cap_software.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deneme")
public class DenemeController {


    @GetMapping("get")
    String  getDene(){

        return "deneme";
    }

}
