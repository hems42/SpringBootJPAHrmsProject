package cap_software.hrms.api.controllers;

import cap_software.hrms.bussiness.abstracts.AdressService;
import cap_software.hrms.entities.concretes.contacts.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @GetMapping("getall")
    List<Adress> getAll()
    {
        return adressService.getAll();
    }


    @PostMapping("add")
    public void add(@RequestBody Adress adress)
    {
        adressService.add(adress);
    }
}
