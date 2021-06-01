package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.entities.concretes.JopAdvertisement;
import cap_software.hrms.entities.concretes.users.Emplooyer;


import java.util.List;

public interface EmplooyerService extends ICrudService<Emplooyer> {


    List<Emplooyer> getByIsActive(boolean isActive);

    List<JopAdvertisement> getAllJopAdvertisements(int id);

   // void addJopAdvertisement(int id,JopAdvertisement jopAdvertisement);
}
