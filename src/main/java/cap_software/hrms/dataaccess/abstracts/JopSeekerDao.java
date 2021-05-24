package cap_software.hrms.dataaccess.abstracts;

import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JopSeekerDao extends JpaRepository<JopSeeker,Integer> {
}
