package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.concretes.users.User;

import java.util.List;

public interface UserService {


    void add(User user);

    List<User> getAll();

    User findById(int id);
}
