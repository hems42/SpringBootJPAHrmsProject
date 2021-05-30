package cap_software.hrms.api.controllers;


import cap_software.hrms.bussiness.abstracts.JopAdvertisementSevice;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/jopadvertisementies")
public class JopAdvertisementController {

    @Autowired
    private JopAdvertisementSevice jopAdvertisementSevice;

    @PostMapping("/add")
    public void add(@RequestBody JopAdvertisement jopAdvertisement) {

        jopAdvertisementSevice.add(jopAdvertisement);
       // return new Result(true,"ekleme başarılı");
    }

    @GetMapping("getall")
   public DataResult<List<JopAdvertisement>> getAll()
    {
        return new SuccessDataResult<List<JopAdvertisement>>(jopAdvertisementSevice.getAll(),"efferinnn");
    }


}
