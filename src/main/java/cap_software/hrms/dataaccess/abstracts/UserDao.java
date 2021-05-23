package cap_software.hrms.dataaccess.abstracts;

import cap_software.hrms.entities.concretes.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {



}
