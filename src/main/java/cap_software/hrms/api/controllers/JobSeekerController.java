package cap_software.hrms.api.controllers;

import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

    @Autowired
    private JopSeekerService jopSeekerService;




    @PostMapping("/add")
    void add(@RequestBody JopSeeker jopSeeker){

        jopSeekerService.add(jopSeeker);
    }

    @GetMapping("/getall")
    List<JopSeeker> getAll()
    {
       return jopSeekerService.getAll();
    }



    @GetMapping("/{id}")
    JopSeeker getAll(@PathVariable("id") int id)
    {
        return jopSeekerService.getById(id);
    }


}
