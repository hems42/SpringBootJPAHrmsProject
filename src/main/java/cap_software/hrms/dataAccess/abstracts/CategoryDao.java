package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
