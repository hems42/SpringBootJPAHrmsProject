package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.entities.concretes.users.Emplooyer;


import java.util.List;

public interface EmplooyerService {

    void add(Emplooyer emplooyer);

    List<Emplooyer> getAll();

    Emplooyer findById(int id);
}
