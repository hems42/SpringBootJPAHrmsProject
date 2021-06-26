package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.utils.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
