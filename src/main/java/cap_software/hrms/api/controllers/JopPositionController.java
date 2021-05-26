package cap_software.hrms.api.controllers;

import cap_software.hrms.api.abstracts.ICrudController;
import cap_software.hrms.bussiness.abstracts.JopPositionService;
import cap_software.hrms.core.utilities.results.Result;
import cap_software.hrms.dataAccess.abstracts.JopPositionDao;
import cap_software.hrms.entities.concretes.JopPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap/joppositions")
public class JopPositionController implements ICrudController<JopPosition> {

    @Autowired
    private JopPositionService jopPositionService;


    @PostMapping("/add")
    @Override
    public Result add(@RequestBody JopPosition jopPosition) {

        jopPositionService.add(jopPosition);
        return new Result(true,"başarıyla eklendi iş pozisyonu");
    }

    @GetMapping("/getall")
    @Override
    public List<JopPosition> getAll() {
        return jopPositionService.getAll();
    }

    @PostMapping("/update")
    @Override
    public Result update(@RequestBody JopPosition jopPosition) {
        jopPositionService.update(jopPosition);
        return new Result(true,"başarıyla güncellendi iş pozisyonu");
    }

    @PostMapping("/delete")
    @Override
    public Result delete(@RequestBody JopPosition jopPosition) {
        jopPositionService.delete(jopPosition);
        return new Result(true,"başarıyla silindi iş pozisyonu");
    }

    @GetMapping("/{id}")
    @Override
    public JopPosition getById(@PathVariable int id) {
        return jopPositionService.getById(id);
    }
}
