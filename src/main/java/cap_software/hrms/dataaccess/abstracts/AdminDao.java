package cap_software.hrms.dataaccess.abstracts;

import cap_software.hrms.entities.concretes.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {
}
