package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.contacts.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressDao extends JpaRepository<Adress,Integer> {
}
