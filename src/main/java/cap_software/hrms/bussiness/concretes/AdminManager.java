package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.AdminService;
import cap_software.hrms.dataAccess.abstracts.AdminDao;
import cap_software.hrms.entities.concretes.users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManager implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public void add(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminDao.findAll();
    }

    @Override
    public void update(Admin admin) {

        adminDao.save(admin);
    }

    @Override
    public void delete(Admin admin) {

        adminDao.delete(admin);

    }

    @Override
    public Admin getById(int id) {
        return adminDao.findById(id).get();
    }
}
