package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.entities.concretes.contacts.Adress;

import java.util.List;

public interface AdressService {
    List<Adress> getAll();
    void add(Adress adress);
}
