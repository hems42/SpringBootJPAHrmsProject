package cap_software.hrms.api.controllers;

import cap_software.hrms.api.abstracts.ICrudController;
import cap_software.hrms.bussiness.abstracts.UserService;
import cap_software.hrms.core.utilities.results.Result;
import cap_software.hrms.entities.concretes.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/users")
public class UserController  {

    /*
    @Autowired
    private UserService userService;



    @PostMapping("/add")
    @Override
   public Result add(@RequestBody User user){

        userService.add(user);
        return new Result(true,"kullanıcı eklendi");
    }

    @GetMapping("/getall")
    @Override
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/update")
    @Override
    public Result update(@RequestBody User user) {
        userService.update(user);
        return new Result(true,"başarıyla güncellendi");
    }
    @PostMapping("/delete")
    @Override
    public Result delete(@RequestBody User user) {
        userService.delete(user);
        return new Result(true,"başarıyla silindi");
    }

    @GetMapping("/{id}")
    @Override
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }
*/
}
