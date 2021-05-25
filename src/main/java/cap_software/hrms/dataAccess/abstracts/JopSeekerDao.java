package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JopSeekerDao extends JpaRepository<JopSeeker,Integer> {
}
