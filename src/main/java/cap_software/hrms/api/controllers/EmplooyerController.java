package cap_software.hrms.api.controllers;

import cap_software.hrms.bussiness.abstracts.EmplooyerService;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import cap_software.hrms.entities.concretes.users.Emplooyer;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplooyers")
public class EmplooyerController {

    @Autowired
    private EmplooyerService emplooyerService;




    @PostMapping("/add")
    void add(@RequestBody Emplooyer emplooyer){

        emplooyerService.add(emplooyer);
    }

    @GetMapping("/getall")
    List<Emplooyer> getAll()
    {
        return emplooyerService.getAll();
    }



    @GetMapping("/{id}")
    Emplooyer getAll(@PathVariable("id") int id)
    {
        return emplooyerService.getById(id);
    }

    @GetMapping("/getbyisactive/{isActive}")
    List<Emplooyer> getByIsActive(@RequestParam boolean isActive)
    {
        return emplooyerService.getByIsActive(isActive);
    }


    @GetMapping("/getalljopadvertisements")
    List<JopAdvertisement> getAllJopAdvertisements(@RequestParam int id)
    {
        return emplooyerService.getAllJopAdvertisements(id);
    }





}
