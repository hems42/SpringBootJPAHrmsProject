package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.EmplooyerService;
import cap_software.hrms.dataaccess.abstracts.EmplooyerDao;
import cap_software.hrms.entities.concretes.users.Emplooyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplooyerManager implements EmplooyerService {

    @Autowired
    private EmplooyerDao emplooyerDao;
    @Override
    public void add(Emplooyer emplooyer) {
        emplooyerDao.save(emplooyer);
    }

    @Override
    public List<Emplooyer> getAll() {
        return emplooyerDao.findAll();
    }

    @Override
    public Emplooyer findById(int id) {
        return emplooyerDao.findById(id).get();
    }
}
