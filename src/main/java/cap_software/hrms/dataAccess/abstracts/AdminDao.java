package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {
}
