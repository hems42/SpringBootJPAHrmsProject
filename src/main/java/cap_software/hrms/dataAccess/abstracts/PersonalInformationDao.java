package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInformationDao extends JpaRepository<PersonalInformation,Integer> {
}
