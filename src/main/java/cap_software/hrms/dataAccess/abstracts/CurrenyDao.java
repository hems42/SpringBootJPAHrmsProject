package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.utils.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrenyDao extends JpaRepository<Currency,Integer> {
}
