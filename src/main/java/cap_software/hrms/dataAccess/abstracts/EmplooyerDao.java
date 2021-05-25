package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.users.Emplooyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplooyerDao extends JpaRepository<Emplooyer,Integer> {
}
