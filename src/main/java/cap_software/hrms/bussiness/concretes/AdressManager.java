package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.AdressService;
import cap_software.hrms.dataAccess.abstracts.AdressDao;
import cap_software.hrms.entities.concretes.contacts.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressManager implements AdressService {

    @Autowired
    private AdressDao adressDao;

    @Override
    public List<Adress> getAll() {
        return adressDao.findAll();
    }

    @Override
    public void add(Adress adress) {
        adressDao.save(adress);
    }
}
