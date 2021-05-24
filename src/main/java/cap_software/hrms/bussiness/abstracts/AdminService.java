package cap_software.hrms.bussiness.abstracts;



import cap_software.hrms.entities.concretes.users.Admin;

import java.util.List;

public interface AdminService {

    void add(Admin admin);

    List<Admin> getAll();

    Admin findById(int id);
}
