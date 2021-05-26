package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.JopPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JopPositionDao extends JpaRepository<JopPosition,Integer> {
}
