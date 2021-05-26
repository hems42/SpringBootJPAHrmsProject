package cap_software.hrms.api.controllers;

import cap_software.hrms.bussiness.abstracts.AdminService;
import cap_software.hrms.entities.concretes.users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

        @Autowired
        private AdminService adminService;

    @PostMapping("/add")
    void add(@RequestBody Admin admin){

        adminService.add(admin);
    }

    @GetMapping("/getall")
    List<Admin> getAll()
    {
        return adminService.getAll();
    }



    @GetMapping("/{id}")
    Admin getAll(@PathVariable("id") int id)
    {
        return adminService.getById(id);
    }


}
