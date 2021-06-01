package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import cap_software.hrms.entities.concretes.users.Emplooyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmplooyerDao extends JpaRepository<Emplooyer,Integer> {

    @Query("From Emplooyer where authParametres.isActive=:isActive")
    List<Emplooyer> getByIsActive(boolean isActive);

    @Query("Select e.jopAdvertisementies From Emplooyer e where e.id=:id")
    List<JopAdvertisement> getJopAdvertisements(int id);

/*    @Query("from Emplooyer e where e.id=:id ")
    void addJopAdvertisement(int id,JopAdvertisement jopAdvertisement);*/


}
