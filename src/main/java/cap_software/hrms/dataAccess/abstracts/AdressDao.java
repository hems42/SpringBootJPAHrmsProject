package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.contacts.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressDao extends JpaRepository<Address,Integer> {
}
