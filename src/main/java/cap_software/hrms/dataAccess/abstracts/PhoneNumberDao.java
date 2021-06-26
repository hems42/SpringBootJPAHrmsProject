package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.contacts.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberDao extends JpaRepository<PhoneNumber,Integer> {
}
