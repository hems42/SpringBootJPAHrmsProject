package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {



}
