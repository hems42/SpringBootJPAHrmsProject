package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Integer> {
}
