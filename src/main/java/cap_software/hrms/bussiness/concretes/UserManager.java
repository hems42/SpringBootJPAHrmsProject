package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.UserService;
import cap_software.hrms.dataAccess.abstracts.UserDao;
import cap_software.hrms.entities.concretes.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user) {
        this.userDao.save(user);
    }
}
